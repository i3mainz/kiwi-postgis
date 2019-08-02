package org.openrdf.query.algebra.evaluation.function.postgis.envelope.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;

public class BBOXDistance extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxdistance.stringValue();
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, g1);
		return g1.getEnvelope().distance(transformed.getEnvelope());
	}

}
