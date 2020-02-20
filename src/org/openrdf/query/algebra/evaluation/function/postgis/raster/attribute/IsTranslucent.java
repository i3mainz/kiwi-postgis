package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;

public class IsTranslucent extends RasterAttributeBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isTranslucent.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage raster) {
	    ImageWorker worker=new ImageWorker(raster.getRenderedImage());
		return worker.isTranslucent();
	}

}
