package co.sr.testHello;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		//의존성 주입(DI)
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV) ctx.getBean("lgtv"); // 위의 xml에서 bean 가져옴 =ctx.getBean("tv", TV.class);
		tv.powerOn();
		tv.powerOff();
		tv.volumnUp();
		tv.volumnDown();
		
		ctx.close();
		
		
		/*
		 * //factory patterns 
		 * // run configuration > ars에 값넣음
		 * BeanFactory factory = new BeanFactory(); TV tv = (TV)
		 * factory.getBean(args[0]);
		 * 
		 * tv.powerOn(); tv.powerOff();
		 */
		
		
		/* 인스턴트화
		 * SamsungTV samsungTV = new SamsungTV();
		 * samsungTV.powerOn(); samsungTV.powerOff();
		 * 
		 * LGTV lg = new LGTV();
		 * lg.powerOff();
		 */
	}
}
