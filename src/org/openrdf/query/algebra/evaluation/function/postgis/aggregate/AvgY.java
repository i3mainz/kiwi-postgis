package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class AvgY extends org.openrdf.query.algebra.AggregateOperatorBase {

	public AvgY(ValueExpr arg) {
		super(arg);
	}

	public AvgY(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof AvgY && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "AvgY".hashCode();
	}

	@Override
	public AvgY clone() {
		return (AvgY) super.clone();
	}

}
