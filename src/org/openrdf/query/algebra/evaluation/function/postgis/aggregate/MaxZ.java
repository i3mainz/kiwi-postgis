package org.openrdf.query.algebra.evaluation.function.postgis.aggregate;

import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.ValueExpr;

public class MaxZ extends org.openrdf.query.algebra.AggregateOperatorBase {

	public MaxZ(ValueExpr arg) {
		super(arg);
	}

	public MaxZ(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MaxZ && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MaxZ".hashCode();
	}

	@Override
	public MaxZ clone() {
		return (MaxZ) super.clone();
	}

}
