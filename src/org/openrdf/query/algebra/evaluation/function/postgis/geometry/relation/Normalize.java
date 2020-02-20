package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;

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
