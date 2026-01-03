package com.crdpls.api.controllers;

import com.crdpls.api.models.KbArticle;
import com.crdpls.api.service.KbArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kb/articles")
@CrossOrigin
public class KbArticleController {

    private final KbArticleService articleService;

    public KbArticleController(KbArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/category/{categoryId}")
    public List<KbArticle> getArticlesByCategory(@PathVariable Long categoryId) {
        return articleService.getArticlesByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public KbArticle getArticle(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }
}
