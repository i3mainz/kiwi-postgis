package org.openrdf.query.algebra.evaluation.function.postgis.envelope.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXRightOf extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxrightof.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, geom);
		if(geom.getEnvelopeInternal().getMinX()>transformed.getEnvelopeInternal().getMaxX()) {
			return true;
		}
		return false;
	}

}
