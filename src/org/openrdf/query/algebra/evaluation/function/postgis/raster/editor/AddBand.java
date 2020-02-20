package org.openrdf.query.algebra.evaluation.function.postgis.raster.editor;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;

public class AddBand extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ADDBAND.stringValue();
	}

}
