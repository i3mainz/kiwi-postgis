package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.locationtech.jts.geom.Geometry;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class GeometryType extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		return geom.getGeometryType();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_geometryType.stringValue();
	}

}
