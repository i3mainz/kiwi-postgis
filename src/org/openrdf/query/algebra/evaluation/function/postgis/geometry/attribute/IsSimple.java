package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsSimple extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isSimple.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return geom.isSimple();
	}



}
