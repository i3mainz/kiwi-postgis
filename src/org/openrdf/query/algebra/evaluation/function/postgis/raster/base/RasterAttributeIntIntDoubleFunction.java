package org.openrdf.query.algebra.evaluation.function.postgis.raster.base;

import org.opengis.coverage.grid.GridCoverage;
import org.openrdf.model.Literal;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.Function;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.RasterLiteral;

public abstract class RasterAttributeIntIntDoubleFunction implements Function {


	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 3) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		if(l instanceof RasterLiteral) {
			GridCoverage geom=((RasterLiteral)l).read(args[0].stringValue());
			Integer longitude = Integer.valueOf(args[1].stringValue());
			Integer latitude = Integer.valueOf(args[2].stringValue());
			Double result = attribute(geom,longitude,latitude);
			return valueFactory.createLiteral(result);
		}
		return null;
	}
	
	public abstract Double attribute(GridCoverage geom,Integer longitude,Integer latitude);

}
