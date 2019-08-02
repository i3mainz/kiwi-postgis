package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class EqualsNorm extends GeometricRelationBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_equalsNorm.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		return g1.equalsNorm(g2);
	}

}
