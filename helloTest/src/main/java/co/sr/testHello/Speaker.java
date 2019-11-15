package co.sr.testHello;

public class Speaker implements SpeakerInterface{
	
	public Speaker() {
		System.out.println("JCB 스피커 객체 생성");
	}

	public void volumnUp() {
		System.out.println("스피커 소리 올림");
	}
	
	public void volumnDown() {
		System.out.println("스피커 소리 내림");
	}
}
