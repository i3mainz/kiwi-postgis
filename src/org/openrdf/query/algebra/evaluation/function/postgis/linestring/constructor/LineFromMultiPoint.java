package org.openrdf.query.algebra.evaluation.function.postgis.linestring.constructor;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPoint;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class LineFromMultiPoint extends GeometricUnaryFunction {


	@Override
	protected Geometry operation(Geometry geom) {
		if(geom.getGeometryType()=="MultiPoint"){
			MultiPoint mp=(MultiPoint) geom;
			GeometryFactory fac=new GeometryFactory();
			return LiteralUtils.createGeometry(geom.getCoordinates(), "LINESTRING", geom.getSRID());
		}	
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_lineFromMultiPoint.stringValue();
	}

}
