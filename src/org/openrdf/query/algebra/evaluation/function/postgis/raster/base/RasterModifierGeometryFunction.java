package org.openrdf.query.algebra.evaluation.function.postgis.raster.base;

import org.apache.sis.coverage.grid.GridCoverage;
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

public abstract class RasterModifierGeometryFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 3) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		if(l instanceof RasterLiteral) {
			GridCoverage geom=((RasterLiteral)l).read(args[0].stringValue());
			Geometry geom2=((VectorLiteral)l).read(args[1].stringValue());
			GridCoverage result = modify(geom,geom2);
			return valueFactory.createLiteral(((RasterLiteral) l).unparse(result),((Literal)args[0]).getDatatype());
		}
		return null;
	}
	
	public abstract GridCoverage modify(GridCoverage coverage, Geometry cropgeom);

}
