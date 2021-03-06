package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsCollection extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isCollection.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
        String type=geom.getGeometryType().toUpperCase();
        if("GEOMETRYCOLLECTION".equals(type) || "COMPOUNDCURVE".equals(type) || type.startsWith("MUTLI")) {
            return true;
        }
        return false;
    
	}

}
