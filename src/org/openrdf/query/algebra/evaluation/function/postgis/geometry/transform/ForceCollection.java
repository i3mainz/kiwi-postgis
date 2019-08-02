package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class ForceCollection extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_forceCollection.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         GeometryFactory fac=new GeometryFactory();
         return fac.createGeometryCollection(new Geometry[] {geom});
	}

}
