package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.geometry.DirectPosition2D;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.coverage.grid.GridGeometry;
import org.opengis.geometry.DirectPosition;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntGeomFunction;

public class WorldToRasterCoord extends RasterAttributeIntIntGeomFunction {
	
	@Override
	public String getURI() {
		return POSTGIS.st_worldToRasterCoord.stringValue();
	}

	@Override
	public Geometry attribute(GridCoverage raster,Integer longitude,Integer latitude) {
        try {
        	
       	 GridGeometry gg2D = raster.getGridGeometry();
            MathTransform gridToCRS = gg2D.getGridToCRS();
            MathTransform crsToGrid = gridToCRS.inverse();
            DirectPosition realPos=new DirectPosition2D(latitude, longitude);
            DirectPosition gridPos = new DirectPosition2D();
            DirectPosition res=crsToGrid.transform(realPos, gridPos);
            Coordinate coord=new Coordinate(res.getCoordinate()[0],res.getCoordinate()[1]);
            GeometryFactory fac=new GeometryFactory();
            return fac.createPoint(coord);
       } catch (TransformException e) {
           return null;
       }
	}
}