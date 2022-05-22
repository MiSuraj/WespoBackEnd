package com.wespobazaar.wespo.Repository;

import com.wespobazaar.wespo.entity.helperClasses.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepo extends JpaRepository<Banner,Integer> {
}
