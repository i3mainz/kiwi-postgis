package org.openrdf.query.algebra.evaluation.function.postgis.raster.base;

import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.Function;
import org.apache.sis.coverage.grid.GridCoverage;

public abstract class RasterAttributeFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract double attribute(GridCoverage geom);
	
}
