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

public abstract class GeometricRelationDoubleFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 2) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 2 arguments, got " + args.length);
		}
	
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		LiteralType l2=LiteralRegistry.getLiteral(((Literal)args[1]).getDatatype().toString());
		if(l instanceof VectorLiteral && l2 instanceof VectorLiteral) {
			Geometry geom=((VectorLiteral)l).read(args[0].stringValue());
			Geometry geom2=((VectorLiteral)l).read(args[1].stringValue());
			double result = relation(geom,geom2);
			return valueFactory.createLiteral(result);
		}
		throw new ValueExprEvaluationException("Arguments given are not a geometry literal");

	}

	protected abstract double relation(Geometry g1, Geometry g2);
}
