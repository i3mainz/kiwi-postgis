package org.openrdf.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsLocationOnEdge extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isLocationOnEdge.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		// TODO Auto-generated method stub
		return false;
	}

}
