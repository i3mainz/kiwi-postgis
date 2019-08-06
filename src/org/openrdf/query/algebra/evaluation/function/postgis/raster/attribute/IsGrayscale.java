package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.image.ImageWorker;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;

public class IsGrayscale extends RasterAttributeBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isGrayscale.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage2D raster) {
	    ImageWorker worker=new ImageWorker(raster.getRenderedImage());
		return worker.isGrayScale();
	}

}
