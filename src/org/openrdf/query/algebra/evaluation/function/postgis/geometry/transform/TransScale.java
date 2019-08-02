package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class TransScale extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_transscale.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
