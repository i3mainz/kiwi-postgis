package org.openrdf.query.algebra.evaluation.function.postgis.geometry.exporter;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.openrdf.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBWriter;

import org.openrdf.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsBinary extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        String endianness = arg1.getString();
        WKBWriter writer=new WKBWriter();
        
        byte[] result=writer.write(geom);
        if(arg1!=null) {
            ByteBuffer bb = ByteBuffer.wrap(result);
        	if("XDR".equals(endianness)) {
                bb.order( ByteOrder.BIG_ENDIAN);
        	}else if("NDR".equals(endianness)) {
        		bb.order( ByteOrder.LITTLE_ENDIAN);
        	}
            return bb.toString();
        }
        return result.toString();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASBINARY.stringValue();
	}
	
	

}
