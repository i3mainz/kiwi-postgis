package org.openrdf.query.algebra.evaluation.function.postgis.polygon;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class ExteriorRing extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_exteriorRing.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        if (geom instanceof Polygon) {
        	LineString result=((Polygon) geom).getExteriorRing();
        	return result;
        }
        return null;
	}

}
