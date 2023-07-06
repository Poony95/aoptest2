package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.oracle.wls.shaded.org.apache.bcel.classfile.Method;

@Component
@Aspect
public class ControllerCommon {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void before_controller() {}
	
	/*
	@Before("before_controller()")
	public void pro() {System.out.println("컨트롤러 동작하기 전입니다.");}
	*/
	
	@Around("before_controller()")
	public Object pro(ProceedingJoinPoint joinPoint) {
		Object object = null;
		try {
			long start = System.currentTimeMillis();
			//타깃메소드를 호출
			object = joinPoint.proceed();
			long end = System.currentTimeMillis();
			long delay = end-start;
			
			String methodName = joinPoint.getSignature().toShortString();
			System.out.println(methodName+" / "+delay);
		} catch (Throwable e) {
			// TODO: handle exception
		}
		return object;
	}
}
