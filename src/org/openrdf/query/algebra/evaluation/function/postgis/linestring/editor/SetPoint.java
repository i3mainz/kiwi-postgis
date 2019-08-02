package org.openrdf.query.algebra.evaluation.function.postgis.linestring.editor;

import java.math.BigInteger;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;

public class SetPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setPoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
        BigInteger zerobasedposition=arg1.getInteger();
        if (geom1 instanceof LineString && transformed instanceof Point) {
            Coordinate[] coords=geom1.getCoordinates();
            Coordinate[] newcoords=coords;
            newcoords[zerobasedposition.intValue()]=geom2.getCoordinate();
            return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
        }
	}

}