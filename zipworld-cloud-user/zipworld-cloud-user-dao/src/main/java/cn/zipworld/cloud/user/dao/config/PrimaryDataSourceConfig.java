package cn.zipworld.cloud.user.dao.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 主数据源@Primary
 */
@Configuration
@MapperScan(basePackages = "cn.zipworld.cloud.user.dao", sqlSessionTemplateRef = PrimaryDataSourceConfig.Prefix.value+"SqlSessionTemplate")
public class PrimaryDataSourceConfig {
    public static final String DB_PREFIX = "spring.datasource";
    public static class Prefix{
        public final static String value="zipworld-erp";//按前缀规则其他数据库复制本类稍作修改后快速配置
    }

    @Value("${mybatis.mapper-locations}")
    private String locationPattern;

    @Bean(name = Prefix.value+"DataSource")
    @ConfigurationProperties(prefix = DB_PREFIX+"."+ Prefix.value)
    @Primary
    public DataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = Prefix.value+"TransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier(Prefix.value+"DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 读取mybatis配置，否则无法开启驼峰命名转换
     * @return
     */
    @Bean(name = "mybatis.configuration")
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration setConfiguration(){
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean(name = Prefix.value+"SqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier(Prefix.value+"DataSource") DataSource dataSource
            ,@Qualifier("mybatis.configuration")org.apache.ibatis.session.Configuration configuration                                   ) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(configuration);//读取mybatis配置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(locationPattern));
        return bean.getObject();
    }

    @Bean(name = Prefix.value+"SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier(Prefix.value+"SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
