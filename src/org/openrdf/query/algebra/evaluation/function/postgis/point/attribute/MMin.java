package org.openrdf.query.algebra.evaluation.function.postgis.point.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class MMin extends GeometricDoubleAttributeFunction{

	@Override
	public double attribute(Geometry geom) {
        Double minM=Double.MAX_VALUE;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(minM>coord.getM()) {
        		minM=coord.getM();
        	}
        }
        return minM;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_mMin.stringValue();
	}

}
