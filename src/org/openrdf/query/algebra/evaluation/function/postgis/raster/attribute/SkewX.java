package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.geom.AffineTransform;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.opengis.referencing.datum.PixelInCell;

public class SkewX extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_skewX.stringValue();
	}

	@Override
	public double attribute(GridCoverage raster) {
		GridGeometry gridGeometry2D = raster.getGridGeometry();
        AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS(PixelInCell.CELL_CENTER);
        return gridToWorld.getShearX();
	}


}
