package org.openrdf.query.algebra.evaluation.function.postgis.geometry;

import java.util.LinkedList;
import java.util.List;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Points extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_points.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		GeometryFactory fac=new GeometryFactory();
        List<Point> res=new LinkedList<Point>();
        for(Coordinate coord:geom.getCoordinates()) {
        	res.add(fac.createPoint(coord));
        }
        return fac.createMultiPoint(geom.getCoordinates());
	}

}
