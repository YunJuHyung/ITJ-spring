package org.iclass.mvc.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.iclass.mvc.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sample")    // url이 Community 로 시작하면 DispatcherServlet 으로부터 CommunityController가 위임받아 처리합니다.
@Log4j2
public class SampleController {

	@GetMapping("/hello")
	public void read(Model model) {
		model.addAttribute("message", "하이 스프링~~~!!!");
		model.addAttribute("list", List.of("모모", "나연", "nana", "쯔위"));

	}

	@GetMapping("/spring")
	public void spring(
			@RequestParam(required = false) String name,
			@RequestParam(required = false)Integer age) {
		log.info("파라미터 name: {},name", name);
		log.info("파라미터 age: {},age", age);
		//required = false 로 하면 파라미터 값이 null 이 되어야하므로
		//int,long 들은 Integer,Log
	}
}
