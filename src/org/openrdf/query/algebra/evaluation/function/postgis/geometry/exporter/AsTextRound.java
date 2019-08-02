package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.precision.GeometryPrecisionReducer;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportIntegerFunction;

public class AsTextRound extends GeometricStringExportIntegerFunction {

	@Override
	public String operation(Geometry geom,Integer value) {
        PrecisionModel pm = new PrecisionModel(Math.pow(10.0, value));
        Geometry geom_mod=GeometryPrecisionReducer.reduce(geom, pm);
        return geom_mod.toText();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASTEXTROUND.stringValue();
	}

}
