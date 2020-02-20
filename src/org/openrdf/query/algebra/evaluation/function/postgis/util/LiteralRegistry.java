package org.openrdf.query.algebra.evaluation.function.postgis.util;

import java.util.Map;
import java.util.TreeMap;

import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.GMLCOVDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.GeoTIFFDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.HexWKBRastDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.NetCDFDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.raster.WKBRastDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.DXFDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.EncodedPolylineDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GMLDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GPXDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GeoJSONDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GeoURIDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.GeobufDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.HexWKBDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.KMLDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.OSMDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.PolyshapeDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.SVGDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.TWKBDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.TopoJSONDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.WKBDatatype;
import org.openrdf.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;

public class LiteralRegistry {
	
	public static final Map<String,LiteralType> literals=new TreeMap<>();
	
	public static final LiteralRegistry INSTANCE=new LiteralRegistry();
	
	public LiteralRegistry() {
		literals.put(GMLDatatype.URI, GMLDatatype.INSTANCE);
		literals.put(KMLDatatype.URI, KMLDatatype.INSTANCE);
		literals.put(TWKBDatatype.URI, TWKBDatatype.INSTANCE);
		literals.put(WKBDatatype.URI, WKBDatatype.INSTANCE);
		literals.put(WKTDatatype.URI, WKTDatatype.INSTANCE);
		literals.put(GeoJSONDatatype.URI, GeoJSONDatatype.INSTANCE);
		literals.put(GeoURIDatatype.URI, GeoURIDatatype.INSTANCE);
		literals.put(GPXDatatype.URI, GPXDatatype.INSTANCE);
		literals.put(HexWKBDatatype.URI, HexWKBDatatype.INSTANCE);
		literals.put(OSMDatatype.URI, OSMDatatype.INSTANCE);
		literals.put(SVGDatatype.URI, SVGDatatype.INSTANCE);
		literals.put(GeobufDatatype.URI, GeobufDatatype.INSTANCE);
		literals.put(TopoJSONDatatype.URI, TopoJSONDatatype.INSTANCE);
		literals.put(PolyshapeDatatype.URI, PolyshapeDatatype.INSTANCE);
		literals.put(DXFDatatype.URI, DXFDatatype.INSTANCE);
		literals.put(EncodedPolylineDatatype.URI, EncodedPolylineDatatype.INSTANCE);
		literals.put(WKBRastDatatype.URI, WKBRastDatatype.INSTANCE);
		literals.put(GeoTIFFDatatype.URI, GeoTIFFDatatype.INSTANCE);
		literals.put(GMLCOVDatatype.URI, GMLCOVDatatype.INSTANCE);
		literals.put(CovJSONDatatype.URI, CovJSONDatatype.INSTANCE);
		literals.put(NetCDFDatatype.URI, NetCDFDatatype.INSTANCE);
		literals.put(HexWKBRastDatatype.URI, HexWKBRastDatatype.INSTANCE);
	}
	
	
	public static LiteralType getLiteral(String uri) {
		if(literals.containsKey(uri)) {
			return literals.get(uri);
		}
		return null;
	}
	
	
	

}
