package com.maodun.aop;

import com.maodun.ant.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author tongjian
 * @date 2020/9/16 10:16
 */
@Aspect
@Component
public class AopWithAnnatation {
    @Pointcut("@annotation(com.maodun.ant.Action)")
    public void annatationPointCut() {
    }

    @Before("execution(* com.maodun.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法拦截：" + method.getName());
    }

    @After("annatationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截..." + action.name());
    }
}
