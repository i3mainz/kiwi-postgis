package org.openrdf.query.algebra.evaluation.function.postgis.linestring.constructor;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class LineFromMultiPoint extends GeometricUnaryFunction {


	@Override
	protected Geometry operation(Geometry geom) {
		if("MultiPoint".equals(geom.getGeometryType())){
			return LiteralUtils.createGeometry(geom.getCoordinates(), "LINESTRING", geom.getSRID());
		}	
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_lineFromMultiPoint.stringValue();
	}

}
