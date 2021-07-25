package com.challenge.currency.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.util.MultiValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public final class CurrencyUtil {

	private static Logger log = LoggerFactory.getLogger(CurrencyUtil.class);

	private static DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	private static String zoneId = "-05:00";
	
	private static ObjectMapper obtenerMapper() {
    	ObjectMapper mapperObj = new ObjectMapper();
		mapperObj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapperObj.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
		mapperObj.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
		mapperObj.disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS);		
		mapperObj.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapperObj.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		mapperObj.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);			
		mapperObj.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapperObj.registerModule(new JavaTimeModule());
		TimeZone tz = TimeZone.getTimeZone("UTC");
		tz.setID(zoneId);
		mapperObj.setTimeZone(TimeZone.getTimeZone("UTC"));
		return mapperObj;
    }
    
    public static Map<String,Object>  jsonStringToMap(String jsonString) {
    	HashMap<String, Object> mapaResult= new HashMap<>();
		try {						
			mapaResult = (HashMap<String, Object>) obtenerMapper().readValue(jsonString, HashMap.class);			
			return mapaResult;
		} catch (Exception e) {
			log.info(e.getMessage());
			return mapaResult;
		}
	}   
    
    public static LocalDateTime obtenerFechaIsoLocal(ZonedDateTime zdt) {
        ZonedDateTime zonedtime = ZonedDateTime
        	.parse(zdt.format(formatter),formatter)     
        	.withZoneSameInstant(ZoneId.of(zoneId));
		return  zonedtime.toLocalDateTime();
	}
    
    public static <T> T objectToObject(Class<T> type, Object o) {
		try {			
			String jsonString = objectToJson(o);
			return obtenerMapper().readValue(jsonString, type);
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	public static String objectToJson(Object o) {
		String jsonInString = null;
		try {
			jsonInString = obtenerMapper().writeValueAsString(o);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return jsonInString;
	}

	public static <T> List<T> listObjectToListObject(Class<T> type,Iterable<?> inList) {
		ArrayList<T> outList=new ArrayList<>(); 
		try {
			for(Object o:inList) {
				T t=objectToObject(type,o); 
				outList.add(t);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} 
		return outList;
	}

}
