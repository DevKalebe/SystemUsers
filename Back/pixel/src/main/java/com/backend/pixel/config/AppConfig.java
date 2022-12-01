package com.backend.pixel.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer	{
	
	// ERRO CORS
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	// CONFIGURANDO BANCO
	 @Bean
     public DataSource dataSource() {
         
         DriverManagerDataSource drivManargerDataSource = new DriverManagerDataSource();
         drivManargerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
         drivManargerDataSource.setUrl("jdbc:mysql://localhost:3307/pixel");
         drivManargerDataSource.setUsername("root");
         drivManargerDataSource.setPassword("root");
         
         return drivManargerDataSource;
     }


     // JPA
     @Bean
     public JpaVendorAdapter jpaVendorAdapter() {
         
         HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
         adapter.setDatabase(Database.MYSQL);
         adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
         adapter.setPrepareConnection(true);
         adapter.setGenerateDdl(true);
         adapter.setShowSql(true);
         
         return adapter;
     }
	
}
