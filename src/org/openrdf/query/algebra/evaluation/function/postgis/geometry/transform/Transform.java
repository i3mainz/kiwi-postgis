package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;

public class Transform extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_transform.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
