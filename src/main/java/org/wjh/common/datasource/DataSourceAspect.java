package org.wjh.common.datasource;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.annotation.Transactional;

public class DataSourceAspect {

    Log log = LogFactory.getLog(DataSourceAspect.class);

    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = (DataSource) m.getAnnotation(DataSource.class);
                DynamicDataSourceHolder.putDataSource(data.value());
                log.info("set datasource,tid=" + Thread.currentThread().getId() + "; datasource=" + data.value() + " method=" + m.getName());
            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error("set datasource failed, method=" + method,e);
        }
    }

    public void beforeTx(JoinPoint point) {
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = target.getClass().getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(Transactional.class)) {
                DynamicDataSourceHolder.putDataSource(DataSourceConstant.MASTER);
                log.info("beforeTransaction set datasource,tid=" +Thread.currentThread().getId() + " method=" + m.getName());
            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error("beforeTransaction set datasource failed, method=" + method,e);
        }
    }
}
