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
public class DalConfig {


    @Configuration
    @MapperScan(basePackages = "com.shuqi.dal.mapper.user",sqlSessionFactoryRef = "userSqlSessionFactory")
    @EnableTransactionManagement
    static class UserDalConfig{

        @Value(value = "classpath:mybatis/sqlmap/user/*.xml")
        private Resource[] mapperLocations;

        @Value(value = "classpath:mybatis/mybatis-config.xml")
        private Resource configLocation;


        @Bean
        public SqlSessionFactoryBean userSqlSessionFactory(DruidDataSource userDataSource) {
            SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
            ssfb.setMapperLocations(mapperLocations);
            ssfb.setConfigLocation(configLocation);
            ssfb.setDataSource(userDataSource);
            return ssfb;
        }

        @Bean(initMethod = "init", destroyMethod = "close")
        public DruidDataSource userDataSource(@Value("${ds.user.jdbc.url}") String url,
                                          @Value("${ds.user.jdbc.username}") String username,
                                          @Value("${ds.user.jdbc.password}") String password) throws SQLException {
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
        public PlatformTransactionManager userTransactionManager(DataSource userDataSource) throws SQLException {
            return new DataSourceTransactionManager(userDataSource);
        }

        @Bean
        public TransactionTemplate userTransactionTemplate(PlatformTransactionManager userTransactionManager) {
            return new TransactionTemplate(userTransactionManager);
        }

    }

    @Configuration
    @MapperScan(basePackages = "com.shuqi.dal.mapper.log",sqlSessionFactoryRef = "logSqlSessionFactory")
    @EnableTransactionManagement
    static class LogDalConfig{

        @Value(value = "classpath:mybatis/sqlmap/log/*.xml")
        private Resource[] mapperLocations;

        @Value(value = "classpath:mybatis/mybatis-config.xml")
        private Resource configLocation;


        @Bean
        public SqlSessionFactoryBean logSqlSessionFactory(DruidDataSource logDataSource) {
            SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
            ssfb.setMapperLocations(mapperLocations);
            ssfb.setConfigLocation(configLocation);
            ssfb.setDataSource(logDataSource);
            return ssfb;
        }

        @Bean(initMethod = "init", destroyMethod = "close")
        public DruidDataSource logDataSource(@Value("${ds.log.jdbc.url}") String url,
                                          @Value("${ds.log.jdbc.username}") String username,
                                          @Value("${ds.log.jdbc.password}") String password) throws SQLException {
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
        public PlatformTransactionManager logTransactionManager(DataSource logDataSource) throws SQLException {
            return new DataSourceTransactionManager(logDataSource);
        }

        @Bean
        public TransactionTemplate logTransactionTemplate(PlatformTransactionManager logTransactionManager) {
            return new TransactionTemplate(logTransactionManager);
        }

    }







}
