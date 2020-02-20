package org.openrdf.query.algebra.evaluation.function.postgis.geometry.constructor;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.wololo.jts2geojson.GeoJSONReader;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

public class GeomFromGeoJSON extends GeometricConstructor {

	
	@Override
	public Geometry construct(String input) {
		GeoJSONReader reader = new GeoJSONReader();
		Geometry geom = reader.read(input);
        return geom;	 
	}

	@Override
	public String getURI() {
		return POSTGIS.st_geomFromGeoJSON.toString();
	}
}
