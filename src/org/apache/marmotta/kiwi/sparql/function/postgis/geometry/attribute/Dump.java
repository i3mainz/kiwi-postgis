package org.apache.marmotta.kiwi.sparql.function.postgis.geometry.attribute;

import org.apache.marmotta.kiwi.persistence.KiWiDialect;
import org.apache.marmotta.kiwi.sparql.builder.ValueType;
import org.apache.marmotta.kiwi.sparql.function.NativeFunction;
import org.locationtech.jts.geom.Geometry;
import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class Dump extends GeometricStringExportFunction implements NativeFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSupported(KiWiDialect dialect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNative(KiWiDialect dialect, String... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueType getReturnType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueType getArgumentType(int arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMinArgs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxArgs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
