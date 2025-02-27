package com.senxiu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 代替web.xml文件，配置SpringMVC的DispatcherServlet
 * @author 森修
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  //指定root容器对应的配置类
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] {ServiceJavaConfig.class, MapperJavaConfig.class, DataSourceJavaConfig.class };
  }

  //指定web容器对应的配置类
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebJavaConfig.class };
  }

  //指定dispatcherServlet处理路径，通常为 /
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }
}