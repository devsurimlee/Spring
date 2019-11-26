package co.ej.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.ej.web.service.BoardService;
import co.ej.web.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("/boardWriteForm.do")
	public String boardWriteForm() {

		return "board/boardWrite";
	}

	@RequestMapping("/boardWrite.do")
	public String boardWrite(HttpServletRequest request, Model model) {
		BoardVO vo = new BoardVO();

		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		System.out.println(request.getParameter("regDate"));

		return "board/boardList";
	}

	@RequestMapping("/boardList.do")
	public String BoardList(Model model) {

		List<BoardVO> list = null;

		try {
			list = boardService.select();
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("list", list);

		return "board/boardList";
	}
}