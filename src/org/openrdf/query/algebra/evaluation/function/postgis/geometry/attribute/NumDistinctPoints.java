package org.openrdf.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import java.util.Set;
import java.util.HashSet;

/**
 * Returns the number of distinct points of the given geometry.
 */
public class NumDistinctPoints extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numDistinctPoints.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		Set<Coordinate> coordset=new HashSet<Coordinate>();
		for(Coordinate coord:geom.getCoordinates()) {
			coordset.add(coord);
		}
		return coordset.size();
	}
}
