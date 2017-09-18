package org.wjh.mysql.common.datasource;

public class DynamicDataSourceHolder {
    public static ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
        return holder.get();
    }
}
