package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationIntegerFunction;
import org.locationtech.jts.geom.Geometry;

public class IsMorePrecise extends GeometricRelationIntegerFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isMorePrecise.stringValue();
	}

	@Override
	protected int relation(Geometry geom, Geometry geom2) {
            if(geom.getPrecisionModel().getMaximumSignificantDigits()>geom2.getPrecisionModel().getMaximumSignificantDigits()) {
            	return 1;
            }else if(geom.getPrecisionModel().getMaximumSignificantDigits()==geom2.getPrecisionModel().getMaximumSignificantDigits()) {
            	return 0;
            }else {
            	return -1;
            }
	}

}
