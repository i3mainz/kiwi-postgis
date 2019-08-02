package org.openrdf.query.algebra.evaluation.function.postgis.point.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class YMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Double minY=0.;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(minY<coord.getY()) {
        		minY=coord.getY();
        	}
        }
        return minY;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_yMin.stringValue();
	}

}
