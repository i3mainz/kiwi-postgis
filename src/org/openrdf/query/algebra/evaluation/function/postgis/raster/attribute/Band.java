package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.GridCoverage2D;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;

public class Band extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BAND.stringValue();
	}

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double attribute(GridCoverage2D geom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
