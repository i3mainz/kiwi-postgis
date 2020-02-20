package org.openrdf.query.algebra.evaluation.function.postgis.geometry;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.BoundaryOp;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Boundary extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_BOUNDARY.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        BoundaryOp boundop=new BoundaryOp(geom);
        return boundop.getBoundary();     
	}

}
