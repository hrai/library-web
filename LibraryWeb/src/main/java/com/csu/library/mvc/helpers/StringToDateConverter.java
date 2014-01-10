package com.csu.library.mvc.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        
        try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return date;
    }
}