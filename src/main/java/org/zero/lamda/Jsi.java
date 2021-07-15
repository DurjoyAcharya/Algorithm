package org.zero.lamda;


import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Jsi {
    public static final String url="http://bfis.bforest.gov.bd/library/tree-and-forest-resources-of-bangladesh/";
    public static void main(String[] args) {
        getWholeHTML(url);
    }
    private static void getCSSStyle(String url)
    {
        var connect=Jsoup.connect(url);
        try {
            var document=connect.get();
            Document name=Jsoup.parse(String.valueOf(document.select("style")));
            System.out.println("Please Wait......");
            Files.writeString(Path.of("doc.txt"),name.toString());
            System.out.println("Done....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getWholeHTML(String url)
    {
        var connect=Jsoup.connect(url);
        try {
            var document=connect.get();
            Document name=Jsoup.parse(document.html());
            System.out.println("Please Wait.....");
            Files.writeString(Path.of("doc.txt"),name.toString());
            System.out.println("Done.....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
