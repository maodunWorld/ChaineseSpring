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
    private static boolean trigger = true;

    @Pointcut("@annotation(com.maodun.ant.Action)")
    public void annatationPointCut() {
    }

    @Pointcut(value = "execution(* com.maodun.controller.DemoService.demo2(*))")
    public void demo2Aop() {
    }

    @Pointcut(value = "execution(* com.maodun.controller.DemoService.demo3())")
    public void demo3() {
    }

    @Before("execution(* com.maodun.controller.*.*(..))")
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

    @Around("demo3()")
    public Object test(ProceedingJoinPoint point) throws Throwable {
        Object proceed = point.proceed();
        if (false) {
            return "test1";
        }
        return proceed;
    }

    @After("annatationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截..." + action.name());
    }
}
