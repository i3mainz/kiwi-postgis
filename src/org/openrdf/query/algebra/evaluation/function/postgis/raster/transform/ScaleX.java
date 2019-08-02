package org.openrdf.query.algebra.evaluation.function.postgis.raster.transform;

import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;

public class ScaleX extends RasterModifierFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_scaleX.stringValue();
	}

}
