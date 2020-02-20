package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.valid.RepeatedPointTester;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class HasRepeatedPoints extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		RepeatedPointTester tester=new RepeatedPointTester();
        return tester.hasRepeatedPoint(geom);
	}

	@Override
	public String getURI() {
		return POSTGIS.st_hasRepeatedPoints.stringValue();
	}
}
