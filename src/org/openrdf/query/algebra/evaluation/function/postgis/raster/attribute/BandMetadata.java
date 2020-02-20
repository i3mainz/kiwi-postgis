package org.openrdf.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.openrdf.model.vocabulary.POSTGIS;
import org.openrdf.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;

public class BandMetadata extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BANDMETADATA.stringValue();
	}

	@Override
	public String operation(GridCoverage raster) {
		// TODO Auto-generated method stub
		return null;
	}

}
