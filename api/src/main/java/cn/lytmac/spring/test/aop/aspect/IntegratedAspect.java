package cn.lytmac.spring.test.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;

public class IntegratedAspect {


    void before() {
        System.out.println(" before ");
    }

    void after() {
        System.out.println(" after ");
    }

    void afterReturning() {
        System.out.println(" after returning ");
    }

    void afterThrowing() {
        System.out.println(" after throwing ");
    }

    void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(" around begin ");
        System.out.println(" around target: " + joinPoint.getTarget() + " ");
        System.out.println(" around signature: " + joinPoint.getSignature() + " ");
        joinPoint.proceed();
        System.out.println(" around end ");
    }
}
