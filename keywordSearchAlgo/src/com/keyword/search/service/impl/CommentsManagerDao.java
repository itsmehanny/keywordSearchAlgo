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

      
        
       /*  Approach -1 to read the data from File
        * For the below solution you have to set the class
        *      List<String> lines = Files.lines(Paths.get("/Users/hdesraj/keywordSearchAlgo/src/record.csv")).collect(Collectors.toList());
        */
        
            for (String line : prepareSampleData()) {
                String[] splitRecord = line.split(COMMA);
                records.add(new RecordObject(Integer.parseInt(splitRecord[0]), splitRecord[1], splitRecord[2]));
            }

        
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
    
    private List<String> prepareSampleData(){
        List<String> inputDataList = new ArrayList<String>();
        inputDataList.add("1,Titanic,This is a very good movie");
        inputDataList.add("2,DDLJ,awesome movie in bollywood");
        inputDataList.add("3,TomAndJerry,loved this cartoon series");
        inputDataList.add("4,FastAndFurious,It was quite hilarious and A true comedy");
        inputDataList.add("5,Lion King,a big fan of this film since childhood");
        inputDataList.add("6,Avengers Endgame,awesome movie");
        inputDataList.add("7,infinity war, worth to watch great movie");
        inputDataList.add("8,Aladdin, best move i have seen so far");
        inputDataList.add("9,deadpool2 , awesome superhero film");
        inputDataList.add("10,Black panther , great action movie");
        
        return inputDataList;
    }

}
