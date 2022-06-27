package kr.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"kr.board.mapper"})
@PropertySource({"classpath:persistence-mysql.properties"})
public class RootConfig {
     
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource myDataSource() {
		HikariConfig hikariConfig=new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty("jdbc.driver"));
		hikariConfig.setJdbcUrl(env.getProperty("jdbc.url"));
		hikariConfig.setUsername(env.getProperty("jdbc.user"));
		hikariConfig.setPassword(env.getProperty("jdbc.password"));
		
		HikariDataSource myDataSource=new HikariDataSource(hikariConfig);
		return myDataSource;
	}
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception{
	  SqlSessionFactoryBean sessionFactory=new SqlSessionFactoryBean();
	  sessionFactory.setDataSource(myDataSource());
	  return (SqlSessionFactory)sessionFactory.getObject();
	}
	
}
