package org.openrdf.query.algebra.evaluation.function.postgis.raster.editor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;

public class SetSkew extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setSkew.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		// TODO Auto-generated method stub
		return null;
	}

}
