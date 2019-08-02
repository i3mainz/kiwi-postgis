package org.openrdf.query.algebra.evaluation.function.postgis.polygon;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;
import org.locationtech.jts.geom.Geometry;

public class InteriorRingN extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_interiorRingN.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
		// TODO Auto-generated method stub
		return null;
	}

}
