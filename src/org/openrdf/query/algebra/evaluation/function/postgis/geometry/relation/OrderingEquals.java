package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;

public class OrderingEquals extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_orderingEquals.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom1, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
		boolean equalsExact = geom1.equalsExact(transformed);
		return equalsExact;
	}

}
