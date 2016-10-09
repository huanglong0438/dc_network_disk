package com.dcnetworkdisk.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD, ElementType.TYPE})
public @interface DcWebResponse {

	boolean requireSecureToken() default true;
	
	boolean allowDuplicateSubmit() default true;
	
}
