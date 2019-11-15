package co.sr.testHello;

import org.springframework.stereotype.Component;

@Component("sstv")
public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		// TODO Auto-generated constructor stub
	}
	
	public SamsungTV(Speaker speaker) { //생성할때 스피커를 넘겨준다
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		this.speaker = speaker;
		this.price = price;
	}
	

	@Override
	public void powerOn() {
		
		if (price != 0)
			System.out.println("삼성 TV 전원을 켠다 가격: " + price);
		else
			System.out.println("삼성티비 전원켠다");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 TV 전원을 끈다");
	}
	
	@Override
	public void volumnUp() {
		System.out.println("삼성 TV 소리를 올린다");
		
		if (speaker != null) {
			speaker.volumnUp();
		}
	}

	@Override
	public void volumnDown() {
		//System.out.println("삼성 TV 소리를 내린다");
		speaker.volumnDown();
		
		if (speaker != null) {
			speaker.volumnDown();
		}
	}
}
