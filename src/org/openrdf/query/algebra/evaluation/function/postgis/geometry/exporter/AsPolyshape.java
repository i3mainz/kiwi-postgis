package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsPolyshape extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASPOLYSHAPE.stringValue();
	}

}
