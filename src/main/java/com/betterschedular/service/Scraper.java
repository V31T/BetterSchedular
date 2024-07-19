package com.betterschedular.service;

//could just import org.jsoup.* but we only need these 5 libraries
import com.betterschedular.model.Course;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scraper {

    public static List<Course> getFall2024Courses(){
        Scraper fall2024Scraper = new Scraper("https://www.sjsu.edu/classes/schedules/fall-2024.php");
        return fall2024Scraper.getCourses();
    }

    private String url;
    String semesterName;
    List<Course> courses = new ArrayList<>();

    private Scraper(String url) {
        //set url name
        this.url = url;
        //set semester name based on url provided
        //TODO make this decide based of provided URL
        if (url.contains("fall")) {
            semesterName = "Fall 2024";
        }
        if (url.contains("spring")) {
            semesterName = "Spring 2025";
        }
    }

    private List<Course> getCourses() {
        Document doc;
        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                    //comment and uncomment out as needed. commented = only 1/8th of html file downloaded. change to config later on
                    .maxBodySize(0)
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements rows = doc.select("tbody > tr");

        for (Element row : rows) {
            ArrayList<String> td = new ArrayList<String>();
            for (Element cell : row.select("td")) {
                td.add(cell.text().trim());
            }
//            System.out.println(td.toString());
            courses.add(parseCourse(td));
        }
        return courses;
    }

    private Course parseCourse(ArrayList<String> td) {
        //semesterName = global var semesterName
        //adds 1 -4 (depending on the Unique set) and then converts it to Integer
        String[] codeAndSection = splitCodeAndSection(td.get(0));
        String code = codeAndSection[0];
        String section = codeAndSection[1];
        Integer classNumber = Integer.valueOf(td.get(1));
        String modality = td.get(2);
        String title = td.get(3);
        String ge = td.get(4);
        Float units = Float.valueOf(td.get(5));
        String type = td.get(6);
        String days = td.get(7);
        String times = td.get(8);
        String Instructor = td.get(9);
        String location = td.get(10);
        String dates = td.get(11);
        Integer seats = Integer.valueOf(td.get(12));

        return new Course(semesterName, code, section, classNumber, modality, title, ge,
                units, type, days, times, Instructor, location, dates, seats);
    }

    //Helper method
    private String[] splitCodeAndSection (String codeAndSection) {
        String split = codeAndSection.replace(" (Section", "").replace(")", "");
        int index = split.lastIndexOf(" ");
        String code = split.substring(0, index);
        String section = split.substring(index + 1);
        return new String[] { code, section };
    }

}
