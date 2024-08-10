package com.zerobase.fastlms.banner.controller;

import com.zerobase.fastlms.admin.model.CommonParam;
import com.zerobase.fastlms.banner.dto.BannerCreateDto;
import com.zerobase.fastlms.banner.dto.BannerListDto;
import com.zerobase.fastlms.banner.dto.BannerModifyDto;
import com.zerobase.fastlms.banner.dto.BannerOutput;
import com.zerobase.fastlms.banner.service.BannerService;
import com.zerobase.fastlms.course.controller.BaseController;
import com.zerobase.fastlms.util.file.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

        try {
            FileUtils.storedFile(file);
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 실패");
        }

        bannerService.addBanner(request.toBannerInput(file.getOriginalFilename()));

        return "redirect:/admin/banner/list";
    }


    @GetMapping("/admin/banner/modify")
    public String modifyBanner(
            Model model,
            @RequestParam Long id
    ) {
        model.addAttribute("banner", bannerService.findBanner(id));

        return "admin/banner/modify";
    }

    @PostMapping("/admin/banner/modify")
    public String modifyBannerSubmit(
            Model model,
            BannerModifyDto.Request request,
            @RequestPart MultipartFile file
    ) {

        if (!file.isEmpty()) {
            try {
                FileUtils.storedFile(file);
            } catch (IOException e) {
                throw new RuntimeException("이미지 저장 실패");
            }

            request.setFileName(file.getOriginalFilename());
        }

        bannerService.modifyBanner(request.toBannerInput());

        return "redirect:/admin/banner/list";
    }

    @PostMapping("/admin/banner/remove")
    public String removeBannerSubmit(
            Model model,
            @RequestParam List<Long> idList
    ) {
        bannerService.removeBanners(idList);

        return "redirect:/admin/banner/list";
    }
}
