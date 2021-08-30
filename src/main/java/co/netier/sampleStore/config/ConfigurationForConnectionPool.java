package co.netier.sampleStore.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import co.netier.sampleStore.dao.CartRepository;
import co.netier.sampleStore.dao.CartRepositoryImpl;
import co.netier.sampleStore.dao.ProductRepository;
import co.netier.sampleStore.dao.ProductRepositoryImpl;

@Configuration
public class ConfigurationForConnectionPool {
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() throws PropertyVetoException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sampleStore");
		dataSource.setUsername("root");
		dataSource.setPassword("aze102030.");
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	
	@Bean 
	public ProductRepository productRepository() throws PropertyVetoException {
		ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
		productRepositoryImpl.setJdbcTemplate(jdbcTemplate()); // injection happens here
		return productRepositoryImpl;
	}
	
	
	@Bean
	public CartRepository cartRepository() throws PropertyVetoException {
		CartRepositoryImpl cartRepositoryImpl = new CartRepositoryImpl();
		cartRepositoryImpl.setJdbcTemplate(jdbcTemplate());
		return cartRepositoryImpl;
		
	}
	

	

}
