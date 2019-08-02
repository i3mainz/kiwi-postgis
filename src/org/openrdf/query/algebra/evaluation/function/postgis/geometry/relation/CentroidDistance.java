package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;

public class CentroidDistance extends GeometricRelationDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_CENTROIDDISTANCE.stringValue();
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
		return g1.getCentroid().distance(g2.getCentroid());
	}

}
