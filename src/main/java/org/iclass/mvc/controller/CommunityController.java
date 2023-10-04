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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/community")    // url이 Community 로 시작하면 DispatcherServlet 으로부터 CommunityController가 위임받아 처리합니다.
@Log4j2
@RequiredArgsConstructor
public class CommunityController {


    private final CommunityService service;

    @GetMapping("/list")
    public void pagelist(PageRequestDTO pageRequestDTO ,Model model){
        PageResponseDTO PageResponseDTO = service.listWithSearch(pageRequestDTO);
        log.info(">>>>>>pageRequestDTO : {}", pageRequestDTO.getPage());
        PageResponseDTO.getList().forEach(i-> {
            log.info(">>>>> 글 : {}",i);
        });
        model.addAttribute("PageResponseDTO",PageResponseDTO);
    }
}
