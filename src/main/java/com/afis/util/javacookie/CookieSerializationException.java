package com.afis.util.javacookie;

public class CookieSerializationException extends Exception {
	private static final long serialVersionUID = 1;
	@SuppressWarnings( "unused" )
	private CookieSerializationException() {}
	CookieSerializationException( Throwable cause ) {
		super( cause );
	}
}
