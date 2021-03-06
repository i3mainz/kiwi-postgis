package org.openrdf.query.algebra.evaluation.function.postgis.polygon.constructor;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructorInteger;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class Polygon extends GeometricConstructorInteger {

	@Override
	public String getURI() {
		return POSTGIS.st_polygon.stringValue();
	}
	
	@Override
	public Geometry construct(String input, Integer srid) {
            WKTReader wktreader=new WKTReader();
            Geometry geom;
			try {
				geom = wktreader.read(input);
	            if("LINESTRING".equals(geom.getGeometryType().toUpperCase())){
	            	return LiteralUtils.createGeometry(geom.getCoordinates(), "Polygon", srid);
	            }
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     

            return null;
	}
	
}
