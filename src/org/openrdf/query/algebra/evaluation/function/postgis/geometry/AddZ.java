package org.openrdf.query.algebra.evaluation.function.postgis.geometry;

import java.util.LinkedList;
import java.util.List;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;

public class AddZ extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ADDZ.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom,Double value) {
        Double zValue=value;
        List<Coordinate> newcoords=new LinkedList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	newcoords.add(new CoordinateXYZM(coord.x,coord.y,zValue,Double.NaN));
        }
        return LiteralUtils.createGeometry(newcoords, geom.getGeometryType(), geom.getSRID());

	}


}
