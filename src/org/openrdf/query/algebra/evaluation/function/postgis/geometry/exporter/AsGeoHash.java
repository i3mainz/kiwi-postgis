package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.locationtech.jts.geom.Geometry;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GeoHashDatatype;


public class AsGeoHash extends GeometricStringExportFunction {
	
	@Override
	public String operation(Geometry geom) {
		return GeoHashDatatype.INSTANCE.unparse(geom);
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOHASH.stringValue();
	}

}
