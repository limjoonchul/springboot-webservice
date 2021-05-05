package com.example.springbootwebservice.controller;

import com.example.springbootwebservice.domain.Posts;
import com.example.springbootwebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        return "index";
    }
    // 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정 된다.
    // index.mustache로 가게 된다.

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
