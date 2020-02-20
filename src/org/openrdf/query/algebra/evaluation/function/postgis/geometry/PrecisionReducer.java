package org.openrdf.query.algebra.evaluation.function.postgis.geometry;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.precision.GeometryPrecisionReducer;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;

public class PrecisionReducer extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_precisionReducer.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
        PrecisionModel pm = new PrecisionModel(Math.pow(10.0, value));
        Geometry geom_mod=GeometryPrecisionReducer.reduce(geom, pm);
        return geom_mod;
	}

}
