package com.yedam.exam.common;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.service.BoardService;



public class SpringSocketHandler extends TextWebSocketHandler implements InitializingBean {
	Logger logger = LoggerFactory.getLogger(SpringSocketHandler.class);
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	

	@Resource
	private BoardService boardService;
	
	public SpringSocketHandler (){ 
		super();
		this.logger.info("create SocketHandler instance!");
	}

	@Override
//onClose
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessionSet.remove(session);
		this.logger.info("remove session!");
	}

	@Override
	//onOpen 
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		sessionSet.add(session);
		this.logger.info("add session!"); 
		
} 
	@Override
	//onMessage 
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception { super.handleMessage(session, message);
	System.out.println(session.getAttributes().get("loginvo") + "!!");
	
	this.logger.info("receive message:"+ message.toString()); //json string을 vo로 변환
		ObjectMapper mapper = new ObjectMapper(); //jackson에서 제공
		MsgVO msgvo = mapper.readValue((String) message.getPayload(), MsgVO.class);
		
		String msg = ""; //메세지
		MsgVO result = new MsgVO();
		if (msgvo.getCmd().equals("msg")) {
			msg = (String) message.getPayload();
		} else if (msgvo.getCmd().equals("board")) {
			String board = mapper.writeValueAsString(boardService.getBoardListMap());
			result.setCmd("board");
			result.setMsg(board);
			msg = mapper.writeValueAsString(result);
		}
		sendMessage(msg);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		this.logger.error("web socket error!", exception);
	}

	@Override
	public boolean supportsPartialMessages() {
		this.logger.info("call method!"); 
		return super.supportsPartialMessages();
	}

	public void sendMessage(String message) {
		for (WebSocketSession session : this.sessionSet) {
			if (session.isOpen()) {
				try {
					session.sendMessage(new TextMessage(message));
				} catch (Exception ignored) {
					this.logger.error("fail to send message!", ignored);
				}
			}
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Thread thread = new Thread() {
			int i = 0;

			@Override
			public void run() {
				while (true) {
					try {
						sendMessage("send message index " + i++);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						break;
					}
				}
			}
		};
		//thread.start();
	}
}
