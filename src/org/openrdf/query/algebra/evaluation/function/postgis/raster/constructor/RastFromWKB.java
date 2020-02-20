package org.openrdf.query.algebra.evaluation.function.postgis.raster.constructor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterConstructorFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.WKBRastDatatype;

public class RastFromWKB extends RasterConstructorFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rastFromWKB.stringValue();
	}

	@Override
	public GridCoverage construct(String input) {
		return WKBRastDatatype.INSTANCE.read(input);
	}

}
