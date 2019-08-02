package org.openrdf.query.algebra.evaluation.function.postgis.envelope.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXOverlapsLeft extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxoverlapsleft.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, geom);
		if(geom.getEnvelope().overlaps(transformed.getEnvelope())) {
			return true;
		}
		if(geom.getEnvelopeInternal().getMaxX()<transformed.getEnvelopeInternal().getMinX()) {
			return true;
		}
		return false;
	}

}
