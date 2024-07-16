package com.betterschedular;

//could just import org.jsoup.* but we only need these 5 libraries
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Scraper {

    private String url;
    String semesterName;
    String semesterUnique;
    ArrayList<Course> courses = new ArrayList<>();

    public Scraper(String url) {
        //set url name
        this.url = url;
        //set semester name based on url provided
        //TODO make this decide based of provided URL
        if (url.contains("fall")) {
            semesterName = "Fall 2024";
            semesterUnique = "1";
        }
        if (url.contains("spring")) {
            semesterName = "Spring 2025";
            semesterUnique = "3";
        }
    }

    public ArrayList<Course> parseRows() {

        Document doc;

        try {
            doc = Jsoup
                    .connect("https://www.sjsu.edu/classes/schedules/fall-2024.php")
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
            System.out.println(td.toString());
            courses.add(parseCourse(td));
        }
        return courses;
    }

    public Course parseCourse(ArrayList<String> td) {
        //semesterName = global var semesterName
        //adds 1 -4 (depending on the Unique set) and then converts it to Integer
        Integer uuid = Integer.valueOf(semesterUnique + td.get(1));
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

        return new Course(semesterName, uuid, code, section, classNumber, modality, title, ge,
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

    public static void main(String[] args) {
        Scraper scrape = new Scraper("https://www.sjsu.edu/classes/schedules/fall-2024.php");
        ArrayList<Course> courses = scrape.parseRows();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

//    static Elements rows;
//    static ArrayList<Course> courses = new ArrayList<>();
//
//    static void setRows (String url) {
//        try {
//            Document doc = Jsoup
//                    .connect("https://www.sjsu.edu/classes/schedules/fall-2024.php")
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
//                    //comment and uncomment out as needed. commented = only 1/8th of html file downloaded. change to config later on
//    //                    .maxBodySize(0)
//                    .get();
//
//            rows = doc.select("tbody > tr");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    static ArrayList<Course> HtmlToCourse(){
//
//
//
//        for (Element row : rows) {
//            ArrayList<String> td = new ArrayList<String>();
//            for (Element cell : row.select("td")) {
//                td.add(cell.text().trim());
//            }
//            courses.add(parseCourse(td));
//        }
//
//        return courses;
//    }
//
//    static Course parseCourse (ArrayList<String> td) {
//
//        int uuid = td.get(1) + makeUnique()
//
//        Course course = new Course(
//
//        )
//
//        return course;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Scraper starting");
//        getHtmlInfo();
//        System.out.println("Scraper Finished");
//
//    }
//
//    static void getHtmlInfo() {
//        Document doc;
////        ArrayList<String> courseValues = new ArrayList<String>();
//
//        try {
//            // fetching the target website
//            doc = Jsoup
//                    .connect("https://www.sjsu.edu/classes/schedules/fall-2024.php")
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
////                    .maxBodySize(0)
//                    .get();
//        }
//        catch(IOException e) {throw new RuntimeException(e);}
//
//        Elements rows = doc.select("tbody > tr");
//
//        for (Element row : rows) {
//            ArrayList<String> courseValues = new ArrayList<String>();
//            for (Element td : row.select("td")) {
//                courseValues.add(td.text().trim());
//            }
//            System.out.println(courseValues);
//        }
//
//    }

}
