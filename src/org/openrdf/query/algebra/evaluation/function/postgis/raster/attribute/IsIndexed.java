package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;

public class IsIndexed extends RasterAttributeBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isIndexed.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage raster) {
	    ImageWorker worker=new ImageWorker(raster.getRenderedImage());
		return worker.isIndexed();
	}

}
