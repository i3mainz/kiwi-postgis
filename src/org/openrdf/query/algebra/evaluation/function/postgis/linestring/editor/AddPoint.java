package org.openrdf.query.algebra.evaluation.function.postgis.linestring.editor;

import java.util.Arrays;
import java.util.List;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;

public class AddPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ADDPOINT.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		Coordinate[] coords=geom1.getCoordinates();
        Point point = ((Point) geom2);
        List<Coordinate> newcoords=Arrays.asList(coords);
        newcoords.add(point.getCoordinate());
        return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
    }

}
