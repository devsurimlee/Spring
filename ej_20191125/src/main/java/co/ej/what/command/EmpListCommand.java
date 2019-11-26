package co.ej.what.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import co.ej.what.service.EmpService;
import co.ej.what.vo.EmpVO;

public class EmpListCommand implements ECommand {

	@Autowired
	private EmpService empService;
	
	@Override
	public void execute(Model model) {
		List<EmpVO> list = empService.select();
		model.addAttribute("list", list);
	}

}
