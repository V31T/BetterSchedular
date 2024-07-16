package com.betterschedular;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DownloadSite {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.sjsu.edu/classes/schedules/fall-2024.php").maxBodySize(0).get();

            String htmlContent = doc.html();

            // Call the method to save the content locally
            saveHtmlToFile(htmlContent, "output.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save HTML content to a file
    public static void saveHtmlToFile(String htmlContent, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
