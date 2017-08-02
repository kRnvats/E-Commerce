package com.niit.CarShopB.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.h2.engine.Database;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit")
public class HibernateConfig {
	@Bean(name="dataSource")
	public BasicDataSource geth2DataSource()
	{


		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/karan");
		dataSource.setUsername("krn");
		dataSource.setPassword("krn");
		return dataSource;
	}
	@Autowired
	@Bean
	public  LocalSessionFactoryBean getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan(new String[]{"com.niit.CarShopB.model"});
		return sessionFactory;
		
		}
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			properties.setProperty("hibernate.show_sql", "true");
			properties.setProperty("hibernate.hbm2ddl.auto","update");
			return properties;
		}
		@Autowired
		@Bean
		public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
		{
			HibernateTransactionManager transactionManager=new HibernateTransactionManager();
			transactionManager.setSessionFactory(sessionFactory);
			return transactionManager;
		}

	}
