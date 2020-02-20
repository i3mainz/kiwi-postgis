package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;

public class NumPoints extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numPoints.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		return geom.getNumPoints();
	}

}
