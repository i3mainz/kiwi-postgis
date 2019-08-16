package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import java.math.BigInteger;

import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.apache.sis.coverage.grid.GridCoverage;

public class HasNoBand extends RasterAttributeBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hasNoBand.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage raster) {
		BigInteger noband=v1.getInteger();
		if(noband.intValue()>raster.getRenderedImage().getData().getNumBands()) {
			return false;
		}
		return true;
	}

}
