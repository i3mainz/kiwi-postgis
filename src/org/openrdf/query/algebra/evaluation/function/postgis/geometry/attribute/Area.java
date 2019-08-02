package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class Area extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		return geom.getArea();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_AREA.stringValue();
	}

}
