package cn.tv189.test;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.tv189.domain.Student;
import cn.tv189.service.TestService;

public class TestSpring {
	private int i=0;
	private TestSpring(){
		System.out.println("i="+ ++i);
	}
	private static TestSpring ts = new TestSpring();
	public static TestSpring getInstance(){
//		TestSpring ts = new TestSpring();
		return ts;
	}
	/*private static TestSpring ts;
	public static TestSpring getInstance(){
		if(ts == null){
			synchronized (TestSpring.class) {
				if(ts == null){
					System.out.println("创建了一个实例");
					ts = new TestSpring();
				}
			}
			System.out.println("打了一壶酱油");
		}
		return ts;
	}*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		// TODO Auto-generated method stub
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService ts = (TestService)ac.getBean("testService");
		String re = ts.doService();
		System.out.println(re);*/
		/*SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		Session s = sf.openSession();
		Student stu = new Student("吴庆健0");
		Transaction ts = s.beginTransaction();
		s.save(stu);
		ts.commit();*/
//		TestService ts1 = (TestService)ac.getBean("testService");
//		String re1 = ts1.doService();
//		System.out.println(re1);
//		URL url = ClassLoader.getSystemResource("jdbc.properties");
//
//		final File file = new File(url.getFile());
//		System.out.println(file.exists());
//		System.out.println(file.getAbsolutePath());
	}
	
	public String letsdo(){
		// TODO Auto-generated method stub
				ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
				TestService ts = (TestService)ac.getBean("testService");
				String re = ts.doService();
				System.out.println(re);
				TestService ts1 = (TestService)ac.getBean("testService");
				String re1 = ts1.doService();
				System.out.println(re1);
		return "搞起";
	}

}
