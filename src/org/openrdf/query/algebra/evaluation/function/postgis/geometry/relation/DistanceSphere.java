package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.operation.TransformException;
import org.opengis.util.FactoryException;

public class DistanceSphere extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.ST_DISTANCESPHERE.stringValue();
	}


	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
			Geometry transformed=LiteralUtils.transform(geom2, geom1);
            double distance = geom1. distanceGreatCircle(transformed);
            return distance;
       
	}

}
