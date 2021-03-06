package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;

public class Width extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_width.stringValue();
	}

	@Override
	public double attribute(GridCoverage raster) {
		//return raster.getRenderedImage().getWidth();
		return 0.;
	}

}
