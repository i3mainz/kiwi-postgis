package org.openrdf.query.algebra.evaluation.function.postgis.geometry.base;

import org.openrdf.model.Literal;
import org.openrdf.model.Value;
import org.openrdf.model.ValueFactory;
import org.openrdf.query.algebra.evaluation.ValueExprEvaluationException;
import org.openrdf.query.algebra.evaluation.function.Function;
import org.openrdf.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.spatial4j.context.SpatialContext;

public abstract class GeometricModifierDoubleFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 2) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 2 arguments, got " + args.length);
		}

		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		Double value=Double.valueOf(args[1].stringValue());
		if(l instanceof VectorLiteral) {
			Geometry geom=((VectorLiteral)l).read(args[0].stringValue());
			Geometry result = relation(geom,value);
			return valueFactory.createLiteral(((VectorLiteral) l).unparse(result),((Literal)args[0]).getDatatype());
		}
		throw new ValueExprEvaluationException("Argument given is not a geometry literal");
	}

	protected abstract Geometry relation(Geometry geom, Double value);

}
