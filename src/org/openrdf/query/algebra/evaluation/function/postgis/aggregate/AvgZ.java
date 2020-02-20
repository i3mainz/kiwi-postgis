package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class AvgZ extends org.openrdf.query.algebra.AggregateOperatorBase {

	public AvgZ(ValueExpr arg) {
		super(arg);
	}

	public AvgZ(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof AvgZ && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "AvgZ".hashCode();
	}

	@Override
	public AvgZ clone() {
		return (AvgZ) super.clone();
	}

}
