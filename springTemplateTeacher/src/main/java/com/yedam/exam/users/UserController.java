package com.yedam.exam.users;

import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	//세션 null일시 로그인 폼으로 감
	@RequestMapping("user/loginForm")
	public String loginForm() {
		return "/user/login";
	}
	
	//로그인 했으면 게시판 목록으로 감
	@RequestMapping("user/login")
	public String login() {
		return "redirect:/getBoardList";
	}
	
	
	//pdf 저장
	@RequestMapping("/userReport")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			JasperReport report = JasperCompileManager
					.compileReport(request.getSession().getServletContext().getRealPath("reports/micol.jrxml"));
			JRDataSource JRdataSource = new JRBeanCollectionDataSource(userService.getUserListMap(null));
			JasperPrint print = JasperFillManager.fillReport(report, map, JRdataSource);
			JRExporter exporter = new JRPdfExporter();
			OutputStream out;
			response.reset();
			out = response.getOutputStream();
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "report3.pdf");
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			exporter.exportReport();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("getUser.do")
	public String getUser(UserVO vo, Model model) {
		model.addAttribute("user",  userService.getUser(vo));
		return "users/getUser"; //포워드
	}
	
	@RequestMapping("getUserList.do")
	public String getUserList(Model model, UserVO vo) {
		model.addAttribute("userList", 
				             userService.getUserList(vo));
		return "users/getUserList";
	}
	
	@RequestMapping("getUserListMap.do")
	public String getUserListMap(Model model, UserVO vo) {
		model.addAttribute("userList", 
				             userService.getUserListMap(vo));
		return "users/getUserList";
	}	
}
