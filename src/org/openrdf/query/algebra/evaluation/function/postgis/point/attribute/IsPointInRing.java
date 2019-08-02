package org.openrdf.query.algebra.evaluation.function.postgis.point.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.CGAlgorithms;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class IsPointInRing extends GeometricRelationBinaryFunction{

	@Override
	public boolean relation(Geometry ringgeom,Geometry pointgeom) {
        CGAlgorithms algos=new CGAlgorithms();
        return algos.isPointInRing(pointgeom.getCoordinate(), ringgeom.getCoordinates());
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPointInRing.stringValue();
	}

}
