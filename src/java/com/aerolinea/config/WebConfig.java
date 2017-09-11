package com.aerolinea.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.aerolinea")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
        new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
    return resolver;
    }
    //CONEXION PRINCIPAL
    @Bean(name = "principal")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(restDataSource());
        sfb.setPackagesToScan(new String[] { "com.aerolinea.entidad" });
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }
   @Bean
    public DriverManagerDataSource restDataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/aerolinea?zeroDateTimeBehavior=convertToNull");
      dataSource.setUsername("root");
      dataSource.setPassword("admin");
      return dataSource;
   }
   //----------------------------------------------------------------------
    
    //CONEXION BACKUP
    @Bean(name = "backup")
    public LocalSessionFactoryBean sessionFactory_Backup() {
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(restDataSource_backup());
        sfb.setPackagesToScan(new String[] { "com.aerolinea.entidad" });
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        sfb.setHibernateProperties(props);
        return sfb;
    }
    @Bean
    public DriverManagerDataSource restDataSource_backup() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://localhost:3306/aerolinea_backup?zeroDateTimeBehavior=convertToNull");
      dataSource.setUsername("root");
      dataSource.setPassword("admin");
      return dataSource;
   }
    //--------------------------------------------------------------------
    @Override
    public void configureDefaultServletHandling(
        DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
}
