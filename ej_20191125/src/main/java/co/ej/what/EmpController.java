package co.ej.what;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.ej.what.service.EmpService;
import co.ej.what.vo.EmpVO;

//@Controller
public class EmpController {

	@Autowired
	private EmpService empService;

	//@RequestMapping("/empList.do")
	public String empList(Model model) {

		List<EmpVO> list=empService.select();
		
		model.addAttribute("list", list);
		
		return "empList"; 
	}

}
