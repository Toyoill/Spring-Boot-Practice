package me.toyoill.stringbootblog.controller;

import lombok.RequiredArgsConstructor;
import me.toyoill.stringbootblog.dto.ArticleListViewResponse;
import me.toyoill.stringbootblog.dto.ArticleViewResponse;
import me.toyoill.stringbootblog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles);

        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        ArticleViewResponse article = new ArticleViewResponse(blogService.findById(id));

        model.addAttribute("article", article);

        return "article";
    }

}
