package com.crdpls.api.repository;

import com.crdpls.api.models.KbArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KbArticleRepository extends JpaRepository<KbArticle, Long> {

    List<KbArticle> findByCategoryIdAndIsActiveTrueOrderByDisplayOrderAsc(Long categoryId);
}
