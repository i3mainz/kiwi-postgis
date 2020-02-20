package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class MinX extends org.openrdf.query.algebra.AggregateOperatorBase {

	public MinX(ValueExpr arg) {
		super(arg);
	}

	public MinX(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MinX && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MinX".hashCode();
	}

	@Override
	public MinX clone() {
		return (MinX) super.clone();
	}
}