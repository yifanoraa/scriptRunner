package com.yliu.elasticjob.Config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.yliu.elasticjob.Mapper", sqlSessionFactoryRef = "twoSqlSessionTemplate")
public class DataSourceTwoConfig {

    @Bean("two")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource twoDataSource(){
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "twoTransactionManager")
    public DataSourceTransactionManager twoTransactionManager(@Qualifier("two") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory twoSqlSessionFactory(@Qualifier("two") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryTwo = new MybatisSqlSessionFactoryBean();
        factoryTwo.setDataSource(dataSource);
        return factoryTwo.getObject();
    }

    @Bean(name = "twoSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate oneSqlSessionTemplate(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
