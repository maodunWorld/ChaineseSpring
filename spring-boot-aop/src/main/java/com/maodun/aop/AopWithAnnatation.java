package com.maodun.aop;

import com.maodun.ant.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @Pointcut(value = "execution(* com.maodun.service.DemoService.demo2(*))")
    public void demo2Aop() {
    }

    @Before("execution(* com.maodun.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法拦截：" + method.getName());
    }

    @Around("demo2Aop()")
    public Object beforeDemo2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        args[0] = "this is aop";
        proceedingJoinPoint.proceed(args);
        return "this after aop";
    }

//    @Before("demo2Aop()")
//    public void beforeDemo2(JoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        System.out.println(args[0]);
//        args[0] = "this aop before";
//    }

    @After("annatationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截..." + action.name());
    }
}
