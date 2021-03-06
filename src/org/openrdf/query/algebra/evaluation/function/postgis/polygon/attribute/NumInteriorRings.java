package org.openrdf.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;

public class NumInteriorRings extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numInteriorRings.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
	     if (geom instanceof Polygon) {
	         return ((Polygon) geom).getNumInteriorRing();
	     }
	     return 0;
	}

}
