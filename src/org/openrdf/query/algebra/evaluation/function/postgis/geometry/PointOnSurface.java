package org.openrdf.query.algebra.evaluation.function.postgis.geometry;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class PointOnSurface extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pointOnSurface.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		return geom.getInteriorPoint();
	}

}
