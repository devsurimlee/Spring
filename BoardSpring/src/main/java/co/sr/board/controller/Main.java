package co.sr.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import co.sr.board.users.UserService;
import co.sr.board.vo.UserVO;

public class Main {
	
	public static void main(String[] args) {
		
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext cnt = new GenericXmlApplicationContext("applicationContext.xml");
//		BoardService boardService = (BoardService) cnt.getBean("boardService"); //@Service
//		
//		BoardVO vo = new BoardVO(); //DTO 선언
//		vo = boardService.select();
//		System.out.println(vo.toString());
		
		
		//2. 스프링 컨테이너 Ioc로부터 userServiceImpl 객체를 찾아옴
		UserService userService = (UserService) cnt.getBean("userService");
		
		//3. 사용할 기능을 구현
		
		
		  //회원 한명 조회 
		  UserVO dto = new UserVO(); 
		  dto.setId("surimi"); 
		  UserVO user = userService.select(dto.getId()); 
		  System.out.println(user.getName() +" 님 입국을 환영합니다");
		  
		  List<UserVO> list = userService.select(); //전체회원 리스트
		  System.out.println("*****전체회원 리스트*****"); 
		  
		  for (UserVO vo : list) {
			  System.out.println(list); 
		  }
		 
		
		   //회원등록 
			UserVO dto1 = new UserVO(); 
			dto1.setId("surimi");
			dto1.setPassword("1234"); 
			dto1.setName("이수림"); 
			dto1.setRole("u");
			
			int r = userService.insert(dto1);
			
			if(r != 0) {
				System.out.println(dto.getName() + "님 회원등록을 환영합니다");
			} else {
				System.out.println("이미 있는 회원입니다");
			}
			
		 
			//회원삭제 
//			UserVO userDelete = new UserVO(); 
//			userDelete.setId("surimi"); 
//			int r = userService.delete(userDelete);
//			
//			if(r != 0) {
//				System.out.println(r + "건 사용자 삭제하였습니다");
//			} else {
//				System.out.println("없는 아이디입니다");
//			}
		
		
		
			//회원갱신
//			UserVO userUpdate = new UserVO(); 
//			userUpdate.setName("이름변경잼");
//			userUpdate.setId("surim");
//		  
//			userService.update(userUpdate);
		  
		  
		 
		 
		
		
		
		// 4. 스프링 컨테이너를 닫아준다~
		cnt.close();
	} 
}
