package com.betterschedular.scraper;

import com.betterschedular.model.Course;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RMPScraper {
    String url;

    public RMPScraper(String url) {
        this.url = url;
    }

    public static void main(String[] args) {
        String url = "https://www.ratemyprofessors.com/search/professors/881?q=*";
        Document doc;
        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                    //comment and uncomment out as needed. commented = only 1/8th of html file downloaded. change to config later on
//                    .maxBodySize(0)
                    .get();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements rows = doc.select("#root");
        for (Element row : rows) {
            System.out.println(row);
        }
    }

}
