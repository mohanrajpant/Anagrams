package com.mrpgh.anagrams;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.mrpgh.anagrams.processor.AnagramProcessor;
import com.mrpgh.anagrams.repository.DataReader;

/**
 * Created by mohanpant on 02/04/15.
 * This program prints anagrams list on console,
 * In case you want to print the content in file please uncomment the fileWriter code below
 */
public class Main {

    final static String ANAGRAMS_URL = "http://codekata.com/data/wordlist.txt";


    public static void main(String[] args) {

        try {
            DataReader dataReader = new DataReader(); // Can use DI and base reader on interface of Testing

            AnagramProcessor processor = new AnagramProcessor(); // Can use DI and base reader on interface of Testing

            Stream<String> dataStream = dataReader.getDataStreamFromURL(ANAGRAMS_URL);

            Map<String, List<String>> anagramsMap = processor.getAnagramsList(dataStream);

            anagramsMap.entrySet().stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> System.out.println(entry.getValue().toString()));


            /**
             * In case you want to see output in file uncomment below code. It will write to
             * anagramList.txt in project folder.

            PrintWriter writer = new PrintWriter(new File("angaramList.txt"), "UTF-8");
            anagramsMap.entrySet().stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        writer.write("\n" + entry.getValue().toString());
                        writer.flush();
                    });
             */


        } catch (Exception ex) {
            System.out.println("#Error while processing " + ex);
        }
    }

}

