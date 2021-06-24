package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import com.example.project.Sections;
@Service
public class NewsService {
	


	  static RestTemplate restTemplate;

	

	public NewsService(){
		restTemplate = new RestTemplate();
	}

	
	public News getTopStories() throws Exception {
		JSONObject newsList = getNews();
	    JSONObject item;
	    News n = new News();
		String mainsection = newsList.getString("section");
		n.setSection(mainsection);
		List<Sections> newsResults= new ArrayList<Sections>();
		JSONArray results = newsList.getJSONArray("results");
		for (int i = 0; i < results.length(); i++) {
		    Sections s = new Sections();
			item = results.getJSONObject(i);
			String title = item.getString("title");
			String section = item.getString("section");
            s.setTitle(title);
            s.setSection(section);
            newsResults.add(s);
         }
         n.setResults(newsResults);
         return n;
	}
	
	public static JSONObject getNews() throws Exception {
		JSONObject newsList = new JSONObject();
		//String getUrl = "http://api.nytimes.com/svc/topstories/v2/home.json?api-key=e00e2139413d4c73a753e25540413e07";
	
		String getUrl = "https://api.nytimes.com/svc/topstories/v2/home.json?api-key=39p9QXNIR2po9Gl9QffqyluE8nTyyJLV";
		//String getUrl = "https://api.nytimes.com/svc/topstories/v2/science.json?api-key=e00e2139413d4c73a753e25540413e07";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Map> topList = restTemplate.exchange(getUrl, HttpMethod.GET, entity, Map.class);
		if (topList.getStatusCode() == HttpStatus.OK) {
			newsList = new JSONObject(topList.getBody());
		}
		 
        return newsList;
	}
}
