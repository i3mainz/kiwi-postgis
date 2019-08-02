package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class MinimumClearanceLine extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_minimumClearanceLine.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.precision.MinimumClearance clearance=new org.locationtech.jts.precision.MinimumClearance(geom);
        return clearance.getLine();
	}

}
