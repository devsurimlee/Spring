package com.yedam.exam.board.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.exam.board.BoardSearchVO;
import com.yedam.exam.board.BoardVO;
import com.yedam.exam.board.common.Paging;
import com.yedam.exam.board.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService boardService;
	
	//엑셀출력
	@RequestMapping("/downloadExcel")
	public ModelAndView excelView(Model model, BoardSearchVO svo) throws IOException{
	List<Map<String, Object>> list = boardService.getBoardListMap();
	HashMap<String, Object> map = new HashMap<String, Object>(); 
	String[] header = {"seq", "title","writer","regDate"}; //vo 컬럼명
	map.put("headers", header);
	map.put("filename", "excel_dept");
	map.put("datas", list);
	return new ModelAndView("commonExcelView", map);
	}


	// 목록조회
	@RequestMapping("getBoardList")
	public String getBoardList(Model model, BoardSearchVO svo, Paging p) {
		model.addAttribute("boardList", boardService.getBoardList(svo, p)); // 커맨드객체는 모델에 저장
		model.addAttribute("paging", p);

		return "board/getBoardList"; // forword
	}

	// 목록조회 - 맵
	@RequestMapping("getBoardListMap")
	public String getBoardListMap(Model model, BoardSearchVO svo, BoardVO vo) {
		model.addAttribute("boardList", boardService.getBoardListMap());

		return "board/getBoardList";
	}

	// 등록페이지 가기
	@RequestMapping("insertBoardForm")
	public String insertBoardForm() {
		return "popup/board/insertBoard"; //popup/*/* 레이아웃 빠짐
	}

	// 글등록처리
	@RequestMapping("insertBoard")
	public String insertBoard(BoardVO vo, HttpServletRequest request, MultipartFile uploadFile
	// MultipartHttpServletRequest multipartRequest

	) throws IllegalStateException, IOException {
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		logger.debug(path);
		// List<MultipartFile> uploadFile = multipartRequest.getFiles("uploadFile");

		// 업로드 파일 처리하고 파일명을 vo에 담기
		String fileName = null;
		if (!uploadFile.isEmpty() && uploadFile.getSize() > 0) {
			fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(path, fileName));
			vo.setUploadFilename(fileName);
		}

		boardService.insertBoard(vo);
		return "redirect:getBoardList";
	}

	// 파일 다운로드
	@RequestMapping("/download/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws Exception {

		String dataDirectory = request.getSession().getServletContext().getRealPath("/resources/upload");
		Path file = Paths.get(dataDirectory, fileName);

		// 파일이 존재하면 다운
		if (Files.exists(file)) {
			response.setContentType("application/pdf;charset=UTF-8");

			// filename 인코딩
			setDisposition(fileName, request, response);
			// response.addHeader("Content-Disposition", "attachment; filename=" +
			// fileName); //첨부파일 이름
			try {
				Files.copy(file, response.getOutputStream()); // 파일을 담음
				response.getOutputStream().flush(); // 파일 내려보내줌
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} //
	}

	/**
	 * Disposition 지정하기. *
	 * 
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */

	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String browser = getBrowser(request);
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}
}
