package com.example.project;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class NewsController {


	 @Autowired
    private NewsService newsService;
	
	@RequestMapping(value = "/news/topstories", method = RequestMethod.GET)
    public @ResponseBody News getNews() throws Exception {
    		return this.newsService.getTopStories();
        }
	
}
