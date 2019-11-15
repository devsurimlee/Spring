package co.sr.testHello;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lgtv")//어노테이션 이용
public class LGTV implements TV {
	@Autowired
	//@Resource(name="jcl")
	private SpeakerInterface speaker;
	private int price;

	@Override
	public void powerOn() {
		System.out.println("LG TV 전원을 켠다 가격: " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("LG TV 전원을 끈다");
		
	}

	@Override
	public void volumnUp() {
		//System.out.println("LG TV 소리를 올린다");
		speaker.volumnUp();
		
	}

	@Override
	public void volumnDown() {
		//System.out.println("LG TV 소리를 내린다");
		speaker.volumnDown();
	}

	public SpeakerInterface getSpeaker() {
		return speaker;
	}

	public void setSpeaker(SpeakerInterface speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
