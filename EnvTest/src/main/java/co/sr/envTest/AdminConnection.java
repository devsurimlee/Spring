package co.sr.envTest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	
	private Environment env; //환경설정을 위한 객체
	private String adminId; //환경변수
	private String adminPw; //환경변수
	
	@Override
	public void setEnvironment(Environment env) { //환경설정 1번
		System.out.println("1. setEnvironment()");
		setEnv(env);
	}

	@Override
	public void afterPropertiesSet() throws Exception { //Env객체로부터 값을 추출 2번
		System.out.println("2. afterPropoertiesSet()");
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}
	
	@Override
	public void destroy() throws Exception { //소멸자 3번
		System.out.println("3. destroy Test()");
	}


	

	//
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	
	//////////////////////


}
