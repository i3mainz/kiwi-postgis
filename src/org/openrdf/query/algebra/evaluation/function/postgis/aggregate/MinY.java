package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class MinY extends org.openrdf.query.algebra.AggregateOperatorBase {

	public MinY(ValueExpr arg) {
		super(arg);
	}

	public MinY(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MinY && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MinY".hashCode();
	}

	@Override
	public MinY clone() {
		return (MinY) super.clone();
	}

}
