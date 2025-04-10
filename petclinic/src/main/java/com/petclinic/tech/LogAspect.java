package com.petclinic.tech;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Around("within(@org.springframework.stereotype.Service *)")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch =  new StopWatch();
		stopWatch.start();
		try {
			return joinPoint.proceed();
		} finally {
			stopWatch.stop();
			double duration = stopWatch.getTotalTime(TimeUnit.MILLISECONDS);
			if(duration>1) {
				logger.info("Calling {} spent more than 1ms ({} ms)", 
						joinPoint.getSignature(), duration);
			}
		}
	}
}
