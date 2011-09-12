package com.darekzon.shoppinglist.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.bson.types.ObjectId;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class StringToIntConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if(arg1.length>0){
			return Integer.valueOf(arg1[0]);
		}
		throw new TypeConversionException();
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return arg1.toString();
	}
	
	@Override
    protected Object performFallbackConversion(Map context, Object o, Class toClass) {
			return new Object();
	}

}
