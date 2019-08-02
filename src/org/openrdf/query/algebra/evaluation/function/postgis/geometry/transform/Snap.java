package org.openrdf.query.algebra.evaluation.function.postgis.geometry.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.overlay.snap.GeometrySnapper;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;

public class Snap extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_snap.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		GeometrySnapper snapper = new GeometrySnapper(g1);
        //Geometry snapGeom = snapper.snapTo(g2, tolerance);
		return null;
	}

}