package com.mrpgh.anagrams.repository;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by mohanpant on 02/04/15.
 * This file read the content from the given link and pass back as dataStream
 */
public class DataReader {

    /**
     * Reads the content from link and return back Stream of String.
     * @param link
     * @return Stream<String>
     */
    public Stream<String> getDataStreamFromURL(String link) {
    	Scanner scanner = null;
        try {
            URL url = new URL(link);
            scanner = new Scanner(url.openStream(), "UTF-8");
            String content = scanner.useDelimiter("\\A").next();

            return Stream.of(content.split(System.getProperty("line.separator")));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally {
        	if(null != scanner)
        		scanner.close();
        }
    }

}
