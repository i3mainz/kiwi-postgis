package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.image.ImageWorker;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;

public class IsTranslucent extends RasterAttributeBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isTranslucent.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage2D raster) {
	    ImageWorker worker=new ImageWorker(raster.getRenderedImage());
		return worker.isTranslucent();
	}

}
