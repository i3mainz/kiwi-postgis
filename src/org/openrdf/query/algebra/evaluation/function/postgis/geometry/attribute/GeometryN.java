package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;

public class GeometryN extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_geometryN.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
		return geom.getGeometryN(value);
	}

}
