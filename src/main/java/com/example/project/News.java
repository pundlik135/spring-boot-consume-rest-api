package com.example.project;

import java.util.List;
public class News {
	public News() {}
    private String title;
    private String section;
    private List<Sections> results;
    
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    public String getSection() {
    	return section;
    }
    public void setSection(String section) {
    	this.section = section;
    }
    
    public List<Sections> getResults() {
    	return results;
    }
    public void setResults(List<Sections> results) {
    	this.results = results;
    }
}
