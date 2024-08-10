package com.zerobase.fastlms.banner.controller;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerCreateDto;
import com.zerobase.fastlms.banner.dto.BannerListDto;
import com.zerobase.fastlms.banner.dto.BannerOutput;
import com.zerobase.fastlms.banner.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class BannerController extends BaseController {

    private final BannerService bannerService;

    @GetMapping("/admin/banner/list")
    public String bannerList(Model model, CommonParam param) {
        param.init();
        List<BannerListDto.Response> bannerList = bannerService.bannerAllList(param).stream()
                .map(BannerListDto.Response::from)
                .collect(Collectors.toList());

        long totalCount = 0;
        if (bannerList != null && bannerList.size() > 0) {
            totalCount = bannerList.get(0).getTotalCount();
        }
        String queryString = param.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, param.getPageSize(), param.getPageIndex(), queryString);

        model.addAttribute("list", bannerList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/banner/list";
    }

    @GetMapping("/admin/banner/add")
    public String addBanner(Model model) {

        return "admin/banner/add";
    }

    @PostMapping("/admin/banner/add")
    public String addBannerSubmit(
            Model model,
            BannerCreateDto.Request request,
            @RequestPart MultipartFile file
    ) {

        String fullPath = null;
        if (!file.isEmpty()) {
             fullPath = "D:\\zerobase\\project4-zerobase-file\\" + file.getOriginalFilename();
            System.out.println("fullPath: " + fullPath);
            try {
                file.transferTo(new File(fullPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        bannerService.addBanner(request.toBannerInput(fullPath));

        return "redirect:/admin/banner/list";
    }


    @GetMapping("/admin/banner/modify")
    public String modifyBanner(Model model) {

        return "admin/banner/modify";
    }

    @PostMapping("/admin/banner/modify")
    public String modifyBannerSubmit(Model model) {

        return "redirect:/admin/banner/list";
    }

    @PostMapping("/admin/banner/remove")
    public String removeBannerSubmit(Model model) {

        return "redirect:/admin/banner/list";
    }
}
