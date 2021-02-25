package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Country;
import com.example.demo.model.Language;
import com.example.demo.model.Source;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NewAPITest {

    private NewsAPI newsAPI;

    @BeforeEach
    void setup(){
        newsAPI = new NewsAPI();
    }

    @Test
    void testApi() {
        final String bitcoin = "bitcoin";
        System.out.println(newsAPI.topHeadLines(Country.US,Category.Business,Source.BBC, bitcoin));
    }

    @Test
    void testSearchApi() {
        final String query = "bitcoin";
        System.out.println(newsAPI.searchNews(query));
    }

    @Test
    void sourceApi() {
        System.out.println(newsAPI.searchSources(Country.US, Category.Business, Source.BBC, Language.EN));
    }
}
