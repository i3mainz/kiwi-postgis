package org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.referencing.CRS;
import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;
import org.opengis.referencing.crs.CRSAuthorityFactory;
import org.opengis.referencing.crs.GeocentricCRS;
import org.opengis.referencing.crs.GeographicCRS;
import org.opengis.util.FactoryException;

public class HexWKBRastDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.HexWKBRaster;
	
	public static final HexWKBRastDatatype INSTANCE =new HexWKBRastDatatype();
	
	@Override
	public GridCoverage read(String geometryLiteral) {
		/*WKBRasterReader reader2=new WKBRasterReader();
		BufferedImage img=reader2.read(WKBReader.hexToBytes(geometryLiteral));
		GridCoverage coverage=reader2.readCoverage(WKBReader.hexToBytes(geometryLiteral), CRS.forCode("EPSG:4326"));
		return coverage;*/
		return null;
	}
	
    @Override
    public String toString() {
        return "HexWKBRasterDatatype{" + URI + '}';
    }


	@Override
	public String unparse(GridCoverage geom) {
		/*
        WKBRasterWriter writer=new WKBRasterWriter();
		String rasterWKB;
		try {
			rasterWKB = WKBWriter.toHex(writer.write((GridCoverage) geom)).toString();
			return rasterWKB.toString();
		} catch (IOException | FactoryException e) {
			throw new AssertionError(e.getMessage());
		}*/
		return null;
	}
}