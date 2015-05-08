package org.common.interceptor;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * イベント関連のAOP
 */
public class EventInterceptor {

	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {

		Object ret = null;
		try {
			ret = joinpoint.proceed();
		} catch (Throwable t) {
			t.printStackTrace();
			throw t;
		}

		return ret;
	}

	protected void beforeEventProceed(ProceedingJoinPoint joinpoint, Method method) {
	}

	protected void afterEventProceed(ProceedingJoinPoint joinpoint, Method method) {
	}

}
