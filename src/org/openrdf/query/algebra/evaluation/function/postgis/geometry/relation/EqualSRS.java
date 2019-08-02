package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class EqualSRS extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_equalSRS.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		return g1.getSRID()==g2.getSRID();
	}

}
