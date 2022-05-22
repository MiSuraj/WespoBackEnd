package com.wespobazaar.wespo.Repository;

import com.wespobazaar.wespo.entity.SuperCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperCategoryRepo extends JpaRepository<SuperCategory,Long> {

}
