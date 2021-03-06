package org.openrdf.query.algebra.evaluation.function.postgis.geometry;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class Perimeter extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_perimeter.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
		return geom.getLength();
	}

}
