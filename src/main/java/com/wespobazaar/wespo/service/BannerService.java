package com.wespobazaar.wespo.service;

import com.wespobazaar.wespo.Repository.BannerRepo;
import com.wespobazaar.wespo.entity.helperClasses.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerRepo bannerRepo;

    public String adBanner(Banner banner){
        bannerRepo.save(banner);
        return "Banner Added";
    }
    public List<Banner> getBanner(){
       return bannerRepo.findAll();
    }
    public void deleteBanner(Banner banner){
      bannerRepo.delete(banner);
    }
}
