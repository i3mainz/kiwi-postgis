package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class AvgX extends org.openrdf.query.algebra.AggregateOperatorBase {

	public AvgX(ValueExpr arg) {
		super(arg);
	}

	public AvgX(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof AvgX && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "AvgX".hashCode();
	}

	@Override
	public AvgX clone() {
		return (AvgX) super.clone();
	}
}