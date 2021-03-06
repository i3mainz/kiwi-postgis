package org.openrdf.query.algebra.evaluation.function.postgis.linestring;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.linearref.LengthLocationMap;
import org.locationtech.jts.linearref.LinearLocation;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;

public class LineInterpolatePoint extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_lineInterpolatePoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
        Double a_fraction = value;
        if(geom.getGeometryType().equals("LineString")) {
        	Double length=geom.getLength();
        	Double fractionlength=a_fraction*length;
            LengthLocationMap locmap=new LengthLocationMap(geom);
            LinearLocation linloc=locmap.getLocation(fractionlength);
            Coordinate coord=linloc.getCoordinate(geom);
            GeometryFactory fac=new GeometryFactory();
            return fac.createPoint(coord);
        }
        return null;
	}

}
