package com.crdpls.api.service;

import com.crdpls.api.models.KbArticle;
import com.crdpls.api.repository.KbArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KbArticleService {

    private final KbArticleRepository articleRepository;

    public KbArticleService(KbArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<KbArticle> getArticlesByCategory(Long categoryId) {
        return articleRepository.findByCategoryIdAndIsActiveTrueOrderByDisplayOrderAsc(categoryId);
    }

    public KbArticle getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }
}
