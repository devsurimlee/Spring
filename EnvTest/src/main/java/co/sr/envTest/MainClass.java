package co.sr.envTest;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(); //환경객체 생성을 위한 스프링 컨테이너 추출
		ConfigurableEnvironment env = ctx.getEnvironment();  //환경객체 생성
		MutablePropertySources propertySources = env.getPropertySources(); //프로포티 소스를 생성한다
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.propoties")); //프로포티 파일 주입
			System.out.println( env.getProperty("admin.id"));
			System.out.println( env.getProperty("admin.pw"));
			
			GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx; //스프링 컨테이너 생성
			gCtx.load("applicationContext.xml"); 
			gCtx.refresh();
			
			AdminConnection adminConn = (AdminConnection) gCtx.getBean("adminConnection");
			System.out.println("admin ID: " + adminConn.getAdminId());
			System.out.println("admin PW: " + adminConn.getAdminPw());
			
			gCtx.close();
			ctx.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
