package org.wjh.common.datasource;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

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
                log.info(Thread.currentThread().getId() + "=" + data.value() + " method=" + m.getName());
            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error("set datasource failed, method=" + method,e);
        }
    }
}
