package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.geometry.DirectPosition2D;
import org.locationtech.jts.geom.Coordinate;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.coverage.grid.GridGeometry;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntDoubleFunction;

public class WorldToRasterCoordY extends RasterAttributeIntIntDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_worldToRasterCoordY.stringValue();
	}

	@Override
	public Double attribute(GridCoverage raster,Integer longitude,Integer latitude) {
        try {     	
        	 GridGeometry gg2D = raster.getGridGeometry();
             MathTransform gridToCRS = gg2D.getGridToCRS();
             MathTransform crsToGrid = gridToCRS.inverse();
             DirectPosition realPos=new DirectPosition2D(latitude, longitude);
             DirectPosition gridPos = new DirectPosition2D();
             DirectPosition res=crsToGrid.transform(realPos, gridPos);
             Coordinate coord=new Coordinate(res.getCoordinate()[0],res.getCoordinate()[1]);
             return coord.y;
        } catch (TransformException e) {
            return (Double) null;
        }
	}

}