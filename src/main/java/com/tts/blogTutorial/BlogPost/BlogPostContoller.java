package com.tts.blogTutorial.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostContoller {
	
	@Autowired
    private BlogPostRepository blogPostRepository;
	
	@GetMapping(value="/")
	public String index(BlogPost blogPost) {
		return "blogPost/index";
	}
	
}