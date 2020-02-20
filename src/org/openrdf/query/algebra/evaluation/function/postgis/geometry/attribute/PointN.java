package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXY;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;

public class PointN extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pointN.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
        Coordinate[] coords = geom.getCoordinates();
        CoordinateXY coord = new CoordinateXY(coords[value].x, coords[value].y);
        GeometryFactory fac=new GeometryFactory();
        return fac.createPoint(coord);
	}

}
