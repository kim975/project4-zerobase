package com.zerobase.fastlms.main.controller;


import com.zerobase.fastlms.banner.service.BannerService;
import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.main.dto.BannerDisplayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;
    private final BannerService bannerService;
    @RequestMapping("/")
    public String index(Model model) {

        List<BannerDisplayDto.Response> bannerDisplayDtoList = bannerService.getDisplayBanner()
                .stream()
                .map(e -> new BannerDisplayDto.Response(e.getFileName(), e.getLinkUrl()))
                .collect(Collectors.toList());

        model.addAttribute("list", bannerDisplayDtoList);
        return "index";
    }
    
    
    
    @RequestMapping("/error/denied")
    public String errorDenied() {
        
        return "error/denied";
    }
    
    
    
}
