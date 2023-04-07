package com.qfedu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBUtils {
    private static final DruidDataSource dataSource;
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(DBUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
