package org.iclass.mvc.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.iclass.mvc.dao.CommunityMapper;
import org.iclass.mvc.dto.Community;
import org.iclass.mvc.dto.PageRequestDTO;
import org.iclass.mvc.dto.PageResponseDTO;
import org.iclass.mvc.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/community")    // url이 Community 로 시작하면 DispatcherServlet 으로부터 CommunityController가 위임받아 처리합니다.
@Log4j2
@RequiredArgsConstructor
public class CommunityController {


    private final CommunityService service;

    @GetMapping("list")
    public void pagelist(PageRequestDTO pageRequestDTO ,Model model){
        log.info(">>>>>>pageRequestDTO : {}", pageRequestDTO.getPage());
        PageResponseDTO PageResponseDTO = service.listWithSearch(pageRequestDTO);
        PageResponseDTO.getList().forEach(i-> {
            log.info(">>>>> 글 : {}",i);
        });
        model.addAttribute("paging",PageResponseDTO);
    }

    @GetMapping({"read","update"})
    public void read(PageRequestDTO pageRequestDTO,long idx,Model model){
        Community community = service.read(idx);
        model.addAttribute("dto",community);
        //요청이 /read 이면 뷰리졸버가 read.html 로 요청 전달
        //요청이 /update 이면 뷰리졸버가 update.html 로 요청 전달
    }



    @PostMapping("update")
        public String modify (PageRequestDTO pageRequestDTO , Community community,
                RedirectAttributes redirectAttributes) {
        String link = pageRequestDTO.getLink();

        service.update(community);
        redirectAttributes.addFlashAttribute("result", "글을 수정 했습니다.");
        redirectAttributes.addAttribute("idx", community.getIdx());
        log.info(">>>>>>>>>>>>>>>> : {}",redirectAttributes);

        return "redirect:/community/read?" + link;
    }

    @PostMapping("delete")
    public String remove(PageRequestDTO pageRequestDTO,Long idx,
                         RedirectAttributes redirectAttributes){
        service.delete(idx);
        redirectAttributes.addFlashAttribute("result","글을 삭제 했습니다.("+ idx + "번)");
        return "redirect:/community/list?" + pageRequestDTO.getLink();
    }

    @GetMapping("write")
    public void write(){
    }

    @PostMapping("write")
        public String writeAction(Community vo,Model model,RedirectAttributes redirectAttributes){
        int insert = service.insert(vo);
        redirectAttributes.addFlashAttribute("result","글을 작성 완료했습니다.("+ insert +"번)");
        return "redirect:/community/list";
    }

   /* @PostMapping("write"){
        public void writeAction()
    }*/
}
