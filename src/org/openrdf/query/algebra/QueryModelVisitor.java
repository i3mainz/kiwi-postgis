/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.openrdf.query.algebra;

import org.openrdf.query.algebra.Add;
import org.openrdf.query.algebra.And;
import org.openrdf.query.algebra.ArbitraryLengthPath;
import org.openrdf.query.algebra.Avg;
import org.openrdf.query.algebra.BNodeGenerator;
import org.openrdf.query.algebra.BindingSetAssignment;
import org.openrdf.query.algebra.Bound;
import org.openrdf.query.algebra.Clear;
import org.openrdf.query.algebra.Coalesce;
import org.openrdf.query.algebra.Compare;
import org.openrdf.query.algebra.CompareAll;
import org.openrdf.query.algebra.CompareAny;
import org.openrdf.query.algebra.Copy;
import org.openrdf.query.algebra.Count;
import org.openrdf.query.algebra.Create;
import org.openrdf.query.algebra.Datatype;
import org.openrdf.query.algebra.DeleteData;
import org.openrdf.query.algebra.DescribeOperator;
import org.openrdf.query.algebra.Difference;
import org.openrdf.query.algebra.Distinct;
import org.openrdf.query.algebra.EmptySet;
import org.openrdf.query.algebra.Exists;
import org.openrdf.query.algebra.Extension;
import org.openrdf.query.algebra.ExtensionElem;
import org.openrdf.query.algebra.Filter;
import org.openrdf.query.algebra.FunctionCall;
import org.openrdf.query.algebra.Group;
import org.openrdf.query.algebra.GroupConcat;
import org.openrdf.query.algebra.GroupElem;
import org.openrdf.query.algebra.IRIFunction;
import org.openrdf.query.algebra.If;
import org.openrdf.query.algebra.In;
import org.openrdf.query.algebra.InsertData;
import org.openrdf.query.algebra.Intersection;
import org.openrdf.query.algebra.IsBNode;
import org.openrdf.query.algebra.IsLiteral;
import org.openrdf.query.algebra.IsNumeric;
import org.openrdf.query.algebra.IsResource;
import org.openrdf.query.algebra.IsURI;
import org.openrdf.query.algebra.Join;
import org.openrdf.query.algebra.Label;
import org.openrdf.query.algebra.Lang;
import org.openrdf.query.algebra.LangMatches;
import org.openrdf.query.algebra.LeftJoin;
import org.openrdf.query.algebra.Like;
import org.openrdf.query.algebra.ListMemberOperator;
import org.openrdf.query.algebra.Load;
import org.openrdf.query.algebra.LocalName;
import org.openrdf.query.algebra.MathExpr;
import org.openrdf.query.algebra.Max;
import org.openrdf.query.algebra.Min;
import org.openrdf.query.algebra.Modify;
import org.openrdf.query.algebra.Move;
import org.openrdf.query.algebra.MultiProjection;
import org.openrdf.query.algebra.Namespace;
import org.openrdf.query.algebra.Not;
import org.openrdf.query.algebra.Or;
import org.openrdf.query.algebra.Order;
import org.openrdf.query.algebra.OrderElem;
import org.openrdf.query.algebra.Projection;
import org.openrdf.query.algebra.ProjectionElem;
import org.openrdf.query.algebra.ProjectionElemList;
import org.openrdf.query.algebra.QueryModelNode;
import org.openrdf.query.algebra.QueryModelVisitor;
import org.openrdf.query.algebra.QueryRoot;
import org.openrdf.query.algebra.Reduced;
import org.openrdf.query.algebra.Regex;
import org.openrdf.query.algebra.SameTerm;
import org.openrdf.query.algebra.Sample;
import org.openrdf.query.algebra.Service;
import org.openrdf.query.algebra.SingletonSet;
import org.openrdf.query.algebra.Slice;
import org.openrdf.query.algebra.StatementPattern;
import org.openrdf.query.algebra.Str;
import org.openrdf.query.algebra.Sum;
import org.openrdf.query.algebra.Union;
import org.openrdf.query.algebra.ValueConstant;
import org.openrdf.query.algebra.Var;
import org.openrdf.query.algebra.ZeroLengthPath;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.AvgX;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.AvgY;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.AvgZ;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.BoundingBox;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.MaxX;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.MaxY;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.MaxZ;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.MinX;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.MinY;
import org.openrdf.query.algebra.evaluation.function.postgis.aggregate.MinZ;

/**
 * An interface for query model visitors, implementing the Visitor pattern. Core query model nodes will call their
 * type-specific method when {@link QueryModelNode#visit(QueryModelVisitor)} is called. The method
 * {@link #meetOther(QueryModelNode)} is provided as a hook for foreign query model nodes.
 */
public interface QueryModelVisitor<X extends Exception> {

	public void meet(QueryRoot node) throws X;

	public void meet(Add add) throws X;

	public void meet(And node) throws X;

	public void meet(ArbitraryLengthPath node) throws X;

	public void meet(Avg node) throws X;
	
	public void meet(AvgX node) throws X;
	
	public void meet(AvgY node) throws X;
	
	public void meet(AvgZ node) throws X;

	public void meet(BindingSetAssignment node) throws X;

	public void meet(BNodeGenerator node) throws X;

	public void meet(Bound node) throws X;
	
	public void meet(BoundingBox node) throws X;

	public void meet(Clear clear) throws X;

	public void meet(Coalesce node) throws X;

	public void meet(Compare node) throws X;

	public void meet(CompareAll node) throws X;

	public void meet(CompareAny node) throws X;

	public void meet(DescribeOperator node) throws X;

	public void meet(Copy copy) throws X;

	public void meet(Count node) throws X;

	public void meet(Create create) throws X;

	public void meet(Datatype node) throws X;

	public void meet(DeleteData deleteData) throws X;

	public void meet(Difference node) throws X;

	public void meet(Distinct node) throws X;

	public void meet(EmptySet node) throws X;

	public void meet(Exists node) throws X;

	public void meet(Extension node) throws X;

	public void meet(ExtensionElem node) throws X;

	public void meet(Filter node) throws X;

	public void meet(FunctionCall node) throws X;

	public void meet(Group node) throws X;

	public void meet(GroupConcat node) throws X;

	public void meet(GroupElem node) throws X;

	public void meet(If node) throws X;

	public void meet(In node) throws X;

	public void meet(InsertData insertData) throws X;

	public void meet(Intersection node) throws X;

	public void meet(IRIFunction node) throws X;

	public void meet(IsBNode node) throws X;

	public void meet(IsLiteral node) throws X;

	public void meet(IsNumeric node) throws X;

	public void meet(IsResource node) throws X;

	public void meet(IsURI node) throws X;

	public void meet(Join node) throws X;

	public void meet(Label node) throws X;

	public void meet(Lang node) throws X;

	public void meet(LangMatches node) throws X;

	public void meet(LeftJoin node) throws X;

	public void meet(Like node) throws X;

	public void meet(Load load) throws X;

	public void meet(LocalName node) throws X;

	public void meet(MathExpr node) throws X;

	public void meet(Max node) throws X;
	
	public void meet(MaxX node) throws X;
	
	public void meet(MaxY node) throws X;
	
	public void meet(MaxZ node) throws X;

	public void meet(Min node) throws X;
	
	public void meet(MinX node) throws X;
	
	public void meet(MinY node) throws X;
	
	public void meet(MinZ node) throws X;

	public void meet(Modify modify) throws X;

	public void meet(Move move) throws X;

	public void meet(MultiProjection node) throws X;

	public void meet(Namespace node) throws X;

	public void meet(Not node) throws X;

	public void meet(Or node) throws X;

	public void meet(Order node) throws X;

	public void meet(OrderElem node) throws X;

	public void meet(Projection node) throws X;

	public void meet(ProjectionElem node) throws X;

	public void meet(ProjectionElemList node) throws X;

	public void meet(Reduced node) throws X;

	public void meet(Regex node) throws X;

	public void meet(SameTerm node) throws X;

	public void meet(Sample node) throws X;

	public void meet(Service node) throws X;

	public void meet(SingletonSet node) throws X;

	public void meet(Slice node) throws X;

	public void meet(StatementPattern node) throws X;

	public void meet(Str node) throws X;

	public void meet(Sum node) throws X;

	public void meet(Union node) throws X;

	public void meet(ValueConstant node) throws X;

	/**
	 */
	public void meet(ListMemberOperator node) throws X;

	public void meet(Var node) throws X;

	public void meet(ZeroLengthPath node) throws X;

	public void meetOther(QueryModelNode node) throws X;
}
