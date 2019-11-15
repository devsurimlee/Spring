package co.sr.testHello;

import org.springframework.stereotype.Component;

@Component("jcl")
public class JCLSpeaker implements SpeakerInterface {
	
	public JCLSpeaker() {
		System.out.println("JCl 스피커 객체 생성");
	}

	@Override
	public void volumnUp() {
		System.out.println("jcl 볼륨을 높혀요");
	}

	@Override
	public void volumnDown() {
		System.out.println("jcl 볼륨을 낮춰요");
	}

}
