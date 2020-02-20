package org.openrdf.query.algebra.evaluation.function.postgis.raster.exporter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.HexWKBRastDatatype;

public class AsHexWKB extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return null;
	}

	@Override
	public String operation(GridCoverage raster) {	
		return HexWKBRastDatatype.INSTANCE.unparse(raster);
	}
	
}
