package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.opengis.geometry.coordinate.PolyhedralSurface;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;

public class NumPatches extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numPatches.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		return ((PolyhedralSurface)geom).getPatches().size();
	}

}
