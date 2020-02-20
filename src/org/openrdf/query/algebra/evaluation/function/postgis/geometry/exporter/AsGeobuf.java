package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;


import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GeobufDatatype;


public class AsGeobuf extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
 		return GeobufDatatype.INSTANCE.unparse(geom);
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOBUF.stringValue();
	}

}
