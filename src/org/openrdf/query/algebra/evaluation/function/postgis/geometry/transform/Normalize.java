package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Normalize extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_normalize.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		return geom.norm();
	}

}
