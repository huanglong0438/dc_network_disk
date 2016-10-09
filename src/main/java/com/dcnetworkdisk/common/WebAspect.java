package com.dcnetworkdisk.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WebAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebAspect.class);
	
	@Pointcut(value="@within(com.dcnetworkdisk.common.DcWebResponse) || @annotation(com.dcnetworkdisk.common.DcWebResponse)")
	public void DcWebResponse() {}
	
	@Around(value="DcWebResponse()")
	public Object WebResonseAspect(ProceedingJoinPoint joinPoint) throws Throwable{
		Object args[] = {joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), joinPoint.getArgs()};
		logger.info(">>>>>>>>>>>> entering {}#{}, params: {}", args);
		long startTime = System.currentTimeMillis();
		Object result = null;
		result = joinPoint.proceed();
		logger.info("<<<<<<<<<<<< leaving {}#{}, params: {}", args);
		logger.info("using time {}ms", System.currentTimeMillis() - startTime);
		return result;
	}
}
