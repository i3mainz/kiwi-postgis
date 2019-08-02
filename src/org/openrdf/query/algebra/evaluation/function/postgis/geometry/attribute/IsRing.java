package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsRing extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof LineString) {

            boolean isRing = ((LineString) geom).isRing();
            return isRing;
        }
		return false;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isRing.stringValue();
	}

}
