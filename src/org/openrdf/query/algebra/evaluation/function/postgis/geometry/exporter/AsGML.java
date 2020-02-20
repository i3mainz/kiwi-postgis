package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.gml2.GMLWriter;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsGML extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		GMLWriter writer=new GMLWriter();
        String result=writer.write(geom);
        return result.toString();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGML.stringValue();
	}

}
