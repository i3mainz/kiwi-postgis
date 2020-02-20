package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class MaxY extends org.openrdf.query.algebra.AggregateOperatorBase {

	public MaxY(ValueExpr arg) {
		super(arg);
	}

	public MaxY(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MaxY && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MaxY".hashCode();
	}

	@Override
	public MaxY clone() {
		return (MaxY) super.clone();
	}

}
