/**
 * 
 */
package com.keyword.search.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.keyword.pojo.RecordObject;


public class CommentsManagerDao {
    private static CommentsManagerDao INSTANCE = null;
    private List<RecordObject> records = new ArrayList<RecordObject>();
    private final String COMMA = ",";

    private CommentsManagerDao() {

      
        
       //  Approach -1 to read the data from File
        // For the below solution you have to set the class
              try {
                List<String> lines = Files.lines(Paths.get("/Users/hdesraj/keywordSearchAlgo/src/record.csv")).collect(Collectors.toList());
                for (String line : lines) {
                    String[] splitRecord = line.split(COMMA);
                    records.add(new RecordObject(Integer.parseInt(splitRecord[0]), splitRecord[1], splitRecord[2]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        /* try with Sample data
            for (String line : prepareSampleData()) {
                String[] splitRecord = line.split(COMMA);
                records.add(new RecordObject(Integer.parseInt(splitRecord[0]), splitRecord[1], splitRecord[2]));
            }

        */
    }

    public static CommentsManagerDao getInstance() {

        if (null == INSTANCE) {
            INSTANCE = new CommentsManagerDao();
        }
        return INSTANCE;
    }

    public List<RecordObject> getRecords() {
        return records;
    }
    
    //this method is used 
    /*
    private List<String> prepareSampleData(){
        List<String> inputDataList = new ArrayList<String>();
        inputDataList.add("This is a very good movie");
        inputDataList.add("awesome movie in bollywood");
        inputDataList.add("loved this cartoon series");
        inputDataList.add("It was quite hilarious and A true comedy");
        inputDataList.add("a big fan of this film since childhood");
        inputDataList.add(",awesome movie");
        inputDataList.add("worth to watch great movie");
        inputDataList.add("best move i have seen so far");
        inputDataList.add("awesome superhero film");
        inputDataList.add("Black panther , great action movie");
        
        return inputDataList;
    } */

}
