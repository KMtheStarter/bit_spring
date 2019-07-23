package kr.co.myBatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {

	private static SqlSessionFactory factory;
	private MyConfig() {}
	static {
		try (Reader reader = Resources.getResourceAsReader("myBatisConfigure.xml");){
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException ex){
			ex.printStackTrace();
		}
	}
	public static SqlSessionFactory getInstance() {
		return factory;
	}
}
