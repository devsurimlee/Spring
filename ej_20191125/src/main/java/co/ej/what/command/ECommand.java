package co.ej.what.command;

import org.springframework.ui.Model;

public interface ECommand {	// 비지니스 컴포넌트를 다룬다.

	public void execute(Model model);
	
}
