package com.senxiu.config;

import com.github.pagehelper.PageInterceptor;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * description: 持久层配置和Druid和Mybatis配置 使用一个配置文件
 * @author 森修
 */
@Configuration
@MapperScan("com.senxiu.mapper")
public class MapperJavaConfig {
    /**
     * 配置SqlSessionFactoryBean，指定连接池对象和外部配置文件即可
     * @param dataSource 需要注入的连接池对象
     * @return 返回配置好的SqlSessionFactoryBean工厂
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        // 实例化SqlSessionFactory工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 设置连接池
        sqlSessionFactoryBean.setDataSource(dataSource);

        // TODO: 用Java配置替代XML文件中的配置
        /*

            <settings>
                <!-- 开启驼峰式映射 -->
                <setting name="mapUnderscoreToCamelCase" value="true"/>
                <!-- 开启logback日志输出 -->
                <setting name="logImpl" value="SLF4J"/>
                <!-- 开启resultMap自动映射 -->
                <setting name="autoMappingBehavior" value="FULL"/>
            </settings>

            <typeAliases>
                <!-- 给实体类起别名 -->
                <package name="com.atguigu.pojo"/>
            </typeAliases>

            <plugins>
                <plugin interceptor="com.github.pagehelper.PageInterceptor">
                    <!--
                        helperDialect：分页插件会自动检测当前的数据库链接，自动选择合适的分页方式。
                        可通过配置helperDialect属性指定分页插件使用的方言。
                         （完整内容见 PageAutoDialect）
                         特别注意：使用 SqlServer2012 数据库时的配置文档链接。
                    -->
                    <property name="helperDialect" value="mysql"/>
                </plugin>
            </plugins>

         */

        // 创建MyBatis配置对象，并设置相关参数
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // 开启驼峰式映射
        configuration.setMapUnderscoreToCamelCase(true);
        // 设置日志实现
//        configuration.setLogImpl(Slf4jImpl.class);
        // 设置自动映射行为
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        // 将配置对象设置到SqlSessionFactoryBean
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 设置Type Aliases包，用于简化实体类的别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.senxiu.entity");
         // 指定 MyBatis 的 mapper XML 文件的路径
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        // 分页插件配置
        PageInterceptor pageInterceptor = new PageInterceptor();

        Properties properties = new Properties();
        // 设置分页插件的数据库方言为mysql
        properties.setProperty("helperDialect", "mysql");
        // 将属性设置到分页插件
        pageInterceptor.setProperties(properties);
        // 将分页插件添加到SqlSessionFactoryBean中
        sqlSessionFactoryBean.addPlugins(pageInterceptor);
        // 返回配置好的SqlSessionFactoryBean
        return sqlSessionFactoryBean;
    }

/*
    */
/**
     * 配置Mapper实例扫描工厂，指定<mapper>的package对应接口和mapper XML文件所在的包
     * @return 返回配置好的MapperScannerConfigurer
     *//*

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 设置mapper接口和xml文件所在的公共包路径
        mapperScannerConfigurer.setBasePackage("com.senxiu.mapper");
        // 返回配置好的MapperScannerConfigurer
        return mapperScannerConfigurer;
    }
*/


}