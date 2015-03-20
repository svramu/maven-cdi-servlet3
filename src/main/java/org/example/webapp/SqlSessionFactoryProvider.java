package org.example.webapp;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

public class SqlSessionFactoryProvider {

  //NOTE: ensure to create DS in WildFly with JNDI name "java:/chirpDS"
  //No web.xml entry is required for JavaEE 6
	@Resource(lookup="chirpDS")
	DataSource chirpDS;
	
	@Produces
	@ApplicationScoped
	public SqlSessionFactory produceFactory() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, chirpDS);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(UserDao.class); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return sqlSessionFactory;
	}

}

