package org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;


public class GMLCOVDatatype extends RasterLiteral {
	

	public static final String URI=POSTGIS.GMLCOV;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();

	@Override
	public GridCoverage read(String geometryLiteral) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String unparse(GridCoverage geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
