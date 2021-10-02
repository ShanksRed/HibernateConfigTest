package com.example.HiberTest.Statistics;

import com.example.HiberTest.Algorithm.AlgorithmImpl;
import com.example.HiberTest.Printer.Printer;
import com.example.HiberTest.StatPrinter.statPrinter;
import com.example.HiberTest.Text.TextParser;
import com.example.HiberTest.statSorts.Sorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class characterStats {
    @Autowired
    private TextParser text;

    @Autowired
    private Printer printer;

    @Autowired
    private statPrinter<String,Integer> statPrinter;

    @Autowired
    private AlgorithmImpl statistics;

    @Autowired
    private Sorting<String,Integer> sorter;

    private String analyzedText;
    private Map<String,Integer> map;

    public void getTextForStatistics(){
        try {
            analyzedText= text.getParseText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getStatistics(){
        map = statistics.analysis(analyzedText);
    }

    public void printText(){
        printer.print(analyzedText);
    }

    public void printStat(){
        //System.out.println(map);
        map.entrySet().forEach( entry -> System.out.println("key : "+entry.getKey() + "  <--->  value : "+ entry.getValue() ));
    }

    public void getSorted(){
        map = sorter.sort(map);
    }

    public void printStatisticsToFile(){
        statPrinter.getStatPrinted(map);
    }


    public void printCharTest(){
        //Character[] chars = analyzedText.toUpperCase(Locale.ROOT).chars().mapToObj(i -> (char)i).toArray(Character[]::new);
        //Arrays.stream(chars).forEach(System.out::print);
        //System.out.println("text" +chars[0]+ chars[1] + chars[2] + chars[3]);
    }
}
