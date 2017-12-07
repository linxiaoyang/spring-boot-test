/**
 * pajk.com Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package com.shuqi;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Configuration
@MapperScan(basePackages = "com.shuqi.dal",sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class DalConfig {


    @Value(value = "classpath:mybatis/sqlmap/*.xml")
    private Resource[] mapperLocations;

    @Value(value = "classpath:mybatis/mybatis-config.xml")
    private Resource configLocation;


    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource) {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setMapperLocations(mapperLocations);
        ssfb.setConfigLocation(configLocation);
        ssfb.setTypeAliasesPackage("com.shuqi.dal.model");
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource(@Value("${ds.jdbc.url}") String url,
                                      @Value("${ds.jdbc.username}") String username,
                                      @Value("${ds.jdbc.password}") String password) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(60);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxWait(60000);//60s
        druidDataSource.setMinIdle(1);
        druidDataSource.setTimeBetweenEvictionRunsMillis(3000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("select 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setFilters("config");
        Properties properties = new Properties();
        properties.put("config.decrypt", "false");
        druidDataSource.setConnectProperties(properties);

        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(10000);//10s。。慢
        statFilter.setMergeSql(true);
        statFilter.setLogSlowSql(true);

        List<Filter> filterList = new ArrayList<Filter>();
        filterList.add(statFilter);
        druidDataSource.setProxyFilters(filterList);

        return druidDataSource;
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws SQLException {
        return new DataSourceTransactionManager(dataSource);
    }

}
