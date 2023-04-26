package com.example.webscraper;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scraper/api")
public class ScraperController {

    private final Scraper scraper;

    public ScraperController(Scraper scraper) {
        this.scraper = scraper;
    }

    @GetMapping("/bbc")
    public List<News> getBBCNewsArticles() {
        return scraper.getBBCNewsArticles("https://www.bbc.com");
    }

    @GetMapping("/bbc/links")
    public List<String> getBBCNewsLinks() {
        return scraper.getLinksToArticles("https://www.bbc.com");
    }

    @GetMapping
    public News getArticleContent(@RequestParam String link, @RequestParam String source) {
        return scraper.retrieveArticle(link, source);
    }
}
