package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationModifierFunction;
import org.locationtech.jts.geom.Geometry;

public class Relate extends GeometricRelationModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_relate.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		// TODO Auto-generated method stub
		return null;
	}

}
