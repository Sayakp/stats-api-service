package com.sykp.statsapiservice.controllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sykp.statsapiservice.domain.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Value("${newsApi.apikey}")
    private String API_KEY;
    private final String NEWS_API_URL = "https://newsapi.org/v2/top-headlines?language=en";
    private static final String API_KEY_PREFIX = "&apiKey=";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final RestTemplate restTemplate = new RestTemplate();

    @GetMapping()
    public NewsResponse getGeneralNews() {
        try {
            String url = NEWS_API_URL + API_KEY_PREFIX + API_KEY;
            String json = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(json, NewsResponse.class);
        }catch (JsonProcessingException e){
            //todo, custom error
            System.out.println("Error getting general news");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/query/{keyword}")
    public NewsResponse getNewsByKeyword(@PathVariable String keyword) {
        try {
            String url = NEWS_API_URL + "&q=" + keyword + API_KEY_PREFIX + API_KEY;
            String json = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(json, NewsResponse.class);
        }catch (JsonProcessingException e){
            //todo, custom error
            System.out.println("Error getting news by keyword");
            System.out.println(e.getMessage());
            return null;
        }
    }

}