package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;

public class TileGridYOffset extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_tileGridYOffset.stringValue();
	}

	@Override
	public double attribute(GridCoverage raster) {
		return raster.render(raster.getGridGeometry().getExtent()).getTileGridYOffset();
	}

}
