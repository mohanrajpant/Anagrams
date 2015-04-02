package com.mrpgh.anagrams.processor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mohanpant on 02/04/15.
 * This class process the dataStream recieves and return back the lists
 * of anagrams
 */
public class AnagramProcessor {

    /**
     * Process the dataStream and return back the result
     * @param dataStream
     * @return Map with anagrams list
     */

    public Map<String, List<String>> getAnagramsList(Stream<String> dataStream) {

        Map<String, List<String>> anagramsMap = dataStream.collect(
                Collectors.groupingBy(this::sortChars));
        return anagramsMap;
    }

    /**
     * Given the String, rearrange String in alphabetical order
     * @param input String
     * @return String
     */
    public String sortChars(String input) {
        char[] characters = input.toUpperCase().toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
