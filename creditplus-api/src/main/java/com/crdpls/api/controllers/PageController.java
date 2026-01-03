package com.crdpls.api.controllers;

import com.crdpls.api.models.Page;
import com.crdpls.api.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pages")
@CrossOrigin(origins = "http://localhost:4200") // allow Angular dev server
public class PageController {

    @Autowired
    private PageService pageService;

    @GetMapping("/{id}")
    public Page getPage(@PathVariable Long id) {
        return pageService.getPageWithChoices(id);
    }
}
