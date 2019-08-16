package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.apache.sis.coverage.grid.GridCoverage;

public class Width extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_width.stringValue();
	}

	@Override
	public double attribute(GridCoverage raster) {
		return raster.render(raster.getGridGeometry().getExtent()).getWidth();
	}

}
