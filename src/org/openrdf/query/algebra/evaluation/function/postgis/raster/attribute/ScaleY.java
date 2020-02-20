package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.geom.AffineTransform;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.opengis.referencing.datum.PixelInCell;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;

public class ScaleY extends RasterAttributeFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_scaleY.stringValue();
	}

	@Override
	public double attribute(GridCoverage raster) {
		GridGeometry gridGeometry2D = raster.getGridGeometry();
        AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS(PixelInCell.CELL_CENTER);
        return gridToWorld.getScaleY();
	}

}
