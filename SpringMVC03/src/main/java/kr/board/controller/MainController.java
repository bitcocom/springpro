package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
   
	@RequestMapping("/")
	public String index() {
		return "index"; // WEB-INF/views/index.jsp
	}
}
