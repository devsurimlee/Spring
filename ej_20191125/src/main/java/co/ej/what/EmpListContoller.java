package co.ej.what;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import co.ej.what.service.EmpService;
import co.ej.what.vo.EmpVO;

public class EmpListContoller implements Controller {
	@Autowired
	private EmpService empService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<EmpVO> list = empService.select();
		
		mv.addObject("list", list);
		mv.setViewName("empList");
		
		return mv;
	}
}
