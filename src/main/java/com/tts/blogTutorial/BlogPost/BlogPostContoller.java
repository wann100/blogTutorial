package com.tts.blogTutorial.BlogPost;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogPostContoller {
	
	@GetMapping(value="/")
	public String index(BlogPost blogPost) {
		return "blogPost/index";
	}
}