package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.kml.KMLWriter;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsKML extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        KMLWriter writer=new KMLWriter();
        String result=writer.write(geom);
        return result;
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASKML.stringValue();
	}

}
