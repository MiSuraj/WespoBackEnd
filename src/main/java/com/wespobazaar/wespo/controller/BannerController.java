package com.wespobazaar.wespo.controller;


import com.wespobazaar.wespo.entity.helperClasses.Banner;
import com.wespobazaar.wespo.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/add")
    public String add_banner(@RequestBody Banner banner){
        return bannerService.adBanner(banner);
    }

    @GetMapping("/get")
    public List<String> getBanner(){
        List<String> str=new ArrayList<>();
        for (Banner banner:bannerService.getBanner()) {
            str.add(banner.getUrl1());
            str.add(banner.getUrl2());
            str.add(banner.getUrl3());
        }
        return  str;

    }
    @DeleteMapping("/delete")
    public String delete(@RequestBody Banner banner){
        bannerService.deleteBanner(banner);
        return "Deleted";
    }



}
