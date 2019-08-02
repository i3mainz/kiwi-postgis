package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Rotate extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rotate.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom,Double rotRadians) {
        AffineTransformation trans = new AffineTransformation();
        trans = trans.rotate(rotRadians);
        Geometry transformGeom = trans.transform(geom);
        return transformGeom;
	}	

}
