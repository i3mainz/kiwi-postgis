package org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.GMLCOVDatatype;
import org.locationtech.jts.geom.Geometry;

public class SVGDatatype extends VectorLiteral {

	public static final String URI=POSTGIS.SVG;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();
	
	@Override
	public String unparse(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Geometry read(String literalValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
