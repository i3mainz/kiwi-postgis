package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Reverse extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_reverse.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {		
        Geometry reverseGeom = geom.reverse();
        return reverseGeom;
	}

}
