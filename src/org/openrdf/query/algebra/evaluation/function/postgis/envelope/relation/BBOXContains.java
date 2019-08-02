package org.openrdf.query.algebra.evaluation.function.postgis.envelope.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXContains extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxcontains.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, geom);
		return geom.getEnvelope().contains(transformed.getEnvelope());
	}

}
