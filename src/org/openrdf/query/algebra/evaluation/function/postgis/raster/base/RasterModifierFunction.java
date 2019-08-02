package org.openrdf.query.algebra.evaluation.function.postgis.raster.base;

import org.openrdf.model.Literal;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.Function;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.RasterLiteral;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Geometry;
import org.opengis.coverage.grid.GridCoverage;

public abstract class RasterModifierFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 1) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		if(l instanceof RasterLiteral) {
			String geomString = args[0].stringValue();
			GridCoverage result = modify(geomString);
			return valueFactory.createLiteral(((RasterLiteral) l).unparse(result),((Literal)args[0]).getDatatype());
		}
	}
	
	public abstract GridCoverage modify(GridCoverage coverage);

}
