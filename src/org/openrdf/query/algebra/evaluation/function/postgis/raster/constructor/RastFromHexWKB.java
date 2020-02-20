package org.openrdf.query.algebra.evaluation.function.postgis.raster.constructor;

import java.io.IOException;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterConstructorFunction;
import org.apache.sis.coverage.grid.GridCoverage;
import org.opengis.util.FactoryException;

import org.locationtech.jts.io.WKBReader;

public class RastFromHexWKB extends RasterConstructorFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rastFromHexWKB.stringValue();
	}

	@Override
	public GridCoverage construct(String input) {
	            String wkbstring=input;
	    		WKBRasterReader reader=new WKBRasterReader();
	    		GridCoverage coverage;
				try {
					coverage = reader.readCoverage(WKBReader.hexToBytes(wkbstring),null);
					return coverage;
				} catch (IOException | FactoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return null;
	}

}
