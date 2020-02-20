package org.openrdf.query.algebra.evaluation.function.postgis.geometry.relation;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.locationtech.jts.geom.Geometry;

public class DistanceSphere extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.ST_DISTANCESPHERE.stringValue();
	}


	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
			//Geometry transformed=LiteralUtils.transform(geom2, geom1);
			return 0.;
            //double distance = geom1. distanceGreatCircle(transformed);
            //return distance;
       
	}

}
