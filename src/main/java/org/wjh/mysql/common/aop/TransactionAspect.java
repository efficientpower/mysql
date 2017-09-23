package org.wjh.mysql.common.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    Log log = LogFactory.getLog(TransactionAspect.class);

    @Pointcut("execution(public * org.wjh..*.service..*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public Object begin(JoinPoint joinPoint) {
        log.info("@Before method=" + joinPoint.getTarget());
        return null;
    }

    @AfterReturning("pointCut()")
    public Object commit(JoinPoint joinPoint) {
        log.info("@AfterReturning method=" + joinPoint.getTarget());
        return null;
    }

    @AfterThrowing("pointCut()")
    public Object rollBack(JoinPoint joinPoint) {
        log.info("@AfterThrowing method=" + joinPoint.getTarget());
        return null;
    }
}
