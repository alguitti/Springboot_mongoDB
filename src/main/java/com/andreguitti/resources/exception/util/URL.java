package com.andreguitti.resources.exception.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	//método auxiliar para decodificar o parametro de busca no padrão HTTP
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
