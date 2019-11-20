package co.sr.aoptest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogAop { //Aspect
	
	public void loggerAop() { //Advice
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
				
		Date time = new Date();
		String today = format.format(time);
				
		System.out.println("today: " + today);
		
	}
}

