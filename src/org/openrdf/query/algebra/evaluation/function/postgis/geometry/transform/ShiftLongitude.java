package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.LinkedList;
import java.util.List;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class ShiftLongitude extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_shiftLongitude.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		List<Coordinate> newcoords=new LinkedList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	if(coord.getX()<0) {
        		newcoords.add(new Coordinate(coord.getX()+360,coord.getY(),coord.getZ()));
        	}else {
            	newcoords.add(coord);            		
        	}
        }
        return LiteralUtils.createGeometry(newcoords, geom.getGeometryType(), geom.getSRID());
	}

}
