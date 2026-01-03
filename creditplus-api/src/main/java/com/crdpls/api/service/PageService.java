package com.crdpls.api.service;

import com.crdpls.api.models.Page;
import com.crdpls.api.models.Choice;
import com.crdpls.api.repository.PageRepository;
import com.crdpls.api.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ChoiceRepository choiceRepository;

    public Page getPageWithChoices(Long id) {
        Page page = pageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + id));

        // Load choices where sourcePageId = current page id
        List<Choice> choices = choiceRepository.findBySourcePageIdOrderByDisplayOrderAsc(id);
        page.setChoices(choices);

        return page;
    }
}
