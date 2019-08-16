package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.IllegalGridGeometryException;
import org.opengis.referencing.datum.PixelInCell;
import org.opengis.referencing.operation.TransformException;

public class UpperLeftX extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_upperLeftX.stringValue();
	}
	
	@Override
	public double attribute(GridCoverage raster) {
		try {
			return raster.getGridGeometry().getGridToCRS(PixelInCell.CELL_CENTER).transform(new GridCoordinates(0, 0),null).getX();
		} catch (IllegalGridGeometryException | TransformException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
