package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

/**
 * Returns the centroid of the given geometry.
 */
public class Centroid extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CENTROID.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         Point centroid = geom.getCentroid();
         return centroid;
	}

}
