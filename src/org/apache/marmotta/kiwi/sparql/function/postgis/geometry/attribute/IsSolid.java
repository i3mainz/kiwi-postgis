/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.marmotta.kiwi.sparql.function.postgis.geometry.attribute;

import org.apache.marmotta.kiwi.persistence.KiWiDialect;
import org.apache.marmotta.kiwi.persistence.pgsql.PostgreSQLDialect;
import org.apache.marmotta.kiwi.sparql.builder.ValueType;
import org.apache.marmotta.kiwi.sparql.function.NativeFunction;
import org.apache.marmotta.kiwi.vocabulary.FN_POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.openrdf.query.algebra.evaluation.function.FunctionRegistry;

public class IsSolid extends org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute.IsSolid implements NativeFunction {

    // auto-register for SPARQL environment
    static {
        if (!FunctionRegistry.getInstance().has(FN_POSTGIS.st_isSolid.toString())) {
            FunctionRegistry.getInstance().add(new IsSolid());
        }
    }

    @Override
    public String getURI() {
        return FN_POSTGIS.st_isSolid.stringValue();
    }

    /**
     * Return true if this function has available native support for the given
     * dialect
     *
     * @param dialect
     * @return
     */
    @Override
    public boolean isSupported(KiWiDialect dialect) {
        return dialect instanceof PostgreSQLDialect;
    }

    /**
     * Return a string representing how this GeoSPARQL function is translated
     * into SQL ( Postgis Function ) in the given dialect
     *
     * @param dialect
     * @param args
     * @return
     */
    @Override
    public String getNative(KiWiDialect dialect, String... args) {
        if (dialect instanceof PostgreSQLDialect) {
            if (args.length == 1) {
                String geom1 = args[0];
                String SRID_default = "4326";
                /*
                 * The following condition is required to read WKT  inserted directly into args[0] and create a geometries with SRID
                 * POINT, MULTIPOINT, LINESTRING ... and MULTIPOLYGON conditions: 
                 *   example: geof:convexHull("POLYGON(( -7 43, -2 43, -2 38, -7 38, -7 43))"^^geo:wktLiteral)
                 * st_AsText condition: It is to use the geometry that is the result of another function geosparql.
                 *   example: geof:convexHull(geof:buffer(?geom, 50, units:meter))
                 */
                if (args[0].contains("POINT") || args[0].contains("MULTIPOINT") || args[0].contains("LINESTRING") || args[0].contains("MULTILINESTRING") || args[0].contains("POLYGON") || args[0].contains("MULTIPOLYGON") || args[0].contains("ST_AsText")) {
                    geom1 = String.format("ST_GeomFromText(%s,%s)", args[0], SRID_default);
                }
                return String.format("ST_IsSolid(%s)", geom1);
            }
        }
        throw new UnsupportedOperationException(FN_POSTGIS.st_isSolid.stringValue()+" function not supported by dialect " + dialect);
    }

    /**
     * Get the return type of the function. This is needed for SQL type casting
     * inside KiWi.
     *
     * @return
     */
    @Override
    public ValueType getReturnType() {
        return ValueType.BOOL;
    }

    /**
     * Get the argument type of the function for the arg'th argument (starting
     * to count at 0). This is needed for SQL type casting inside KiWi.
     *
     * @param arg
     * @return
     */
    @Override
    public ValueType getArgumentType(int arg
    ) {
        return ValueType.GEOMETRY;
    }

    /**
     * Return the minimum number of arguments this function requires.
     *
     * @return
     */
    @Override
    public int getMinArgs() {
        return 0;
    }

    /**
     * Return the maximum number of arguments this function can take
     *
     * @return
     */
    @Override
    public int getMaxArgs() {
        return 0;
    }

	@Override
	public boolean attribute(Geometry geom) {
		return geom.isEmpty();
	}
}

