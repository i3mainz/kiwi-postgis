package org.openrdf.query.algebra.evaluation.function.postgis.point.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.CGAlgorithms;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class IsPointOnLine extends GeometricRelationBinaryFunction{

	@Override
	protected boolean relation(Geometry linegeom, Geometry pointgeom) {
		CGAlgorithms algos=new CGAlgorithms();
        return algos.isOnLine(pointgeom.getCoordinate(), linegeom.getCoordinates());
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPointOnLine.stringValue();
	}
	
}
