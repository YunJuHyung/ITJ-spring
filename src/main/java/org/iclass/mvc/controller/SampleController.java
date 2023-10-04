package org.iclass.mvc.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.iclass.mvc.dao.CommunityMapper;
import org.iclass.mvc.dto.Community;
import org.iclass.mvc.dto.CommunityComments;
import org.iclass.mvc.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sample")    // url이 Community 로 시작하면 DispatcherServlet 으로부터 CommunityController가 위임받아 처리합니다.
@Log4j2
public class SampleController {

	@Autowired
	private CommunityMapper communityMapper;


	@GetMapping("/hello")
	public void read(Model model) {
		model.addAttribute("message", "하이 스프링~~~!!!");
		model.addAttribute("list", List.of("모모", "나연", "nana", "쯔위"));

	}

	@GetMapping("/spring")
	public void spring(Community community, Model model,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age) {
		log.info("파라미터 name: {},name", name);
		log.info("파라미터 age: {},age", age);
		log.info("Community dto : {} ", community); //Community 클래스의 모든 필드들이 파라미터로 전달될수 있다.
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		//required = false 로 하면 파라미터 값이 null 이 되어야하므로
	}
	//복습 10월 4일
	//DTO 클래스는 파라미터를 받고 다시 view 의 Model(view 로 전달하는 데이터 저장객체) 로 전달도 할 수 있습니다.
	//int,long 등 기본형과 String 은 파라미터 받은것을 Model에 직접 저장해야 view로 넘어갑니다 예시) 44번째줄



}


//	@PostMapping("/comments")
//	public String comments(int page, int f,
//						   CommunityComments dto , RedirectAttributes redirectAttributes) {
//		log.info(">>>>>>>>>>>>>>>>>>>>>> dto :{}",dto);
//		CommunityMapper.comments(dto,f);
//		redirectAttributes.addAttribute("page",page);
//		redirectAttributes.addAttribute("idx",dto.getMref());
//		String message = null;
//		if(f==1) message ="댓글 등록 하였습니다.";
//		else if(f==2) message = "댓글 삭제 하였습니다.";
//		redirectAttributes.addFlashAttribute("message", message);
//
////	  return "redirect:/community/read?page="+page +"&idx="+dto.getMref();
//		return "redirect:/community/read"; //리다이렉트 애트리뷰트 사용하므로 쿼리스트링 안씁니다. }
//
//	}



