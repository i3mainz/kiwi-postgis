package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;

public class UpperLeftX extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_upperLeftX.stringValue();
	}
	
	@Override
	public double attribute(GridCoverage raster) {
		/*
		try {
			return raster.getGridGeometry().getGridToCRS2D().transform(new GridCoordinates(0, 0),null).getX();
		} catch (InvalidGridGeometryException | TransformException e) {
			throw new RuntimeException(e.getMessage());
		}*/
		return 0.;
	}

}
