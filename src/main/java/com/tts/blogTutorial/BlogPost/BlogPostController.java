package com.tts.blogTutorial.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	
	@Autowired
    private BlogPostRepository blogPostRepository;
	
	@GetMapping(value="/")
	public String index(BlogPost blogPost, Model model) {
		
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogPost/index";
	}
	
	@GetMapping(value = "/blog_posts/new")
    public String newBlog(BlogPost blogPost) {
        return "blogPost/new";
    }
	
    @GetMapping(value = "/blog_posts/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostRepository.deleteById(id);
        return "redirect:/";
    }
	
//	private BlogPost blogPost;
	@PostMapping(value = "/blog_posts/new")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogPost/result";
	}
}
