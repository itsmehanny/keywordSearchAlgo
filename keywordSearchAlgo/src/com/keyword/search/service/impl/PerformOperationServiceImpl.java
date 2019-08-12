/**
 * 
 */
package com.keyword.search.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.keyword.pojo.RecordObject;
import com.keyword.search.service.PerformOperationService;


public class PerformOperationServiceImpl implements PerformOperationService {

   /*This method is used to perform delete comment 
    * so we passed only record id , we can identify the record using equal and hashcode method.
    */
    @Override
    public void deleteComment(int recordId) {
        //this is taken care by hashcode and equals
        CommentsManagerDao.getInstance().getRecords().remove(new RecordObject(recordId, null, null));
    }

    /* This method is used to perfrom search operation 
     * CASE_INSENSITIVE , regex search supported. 
     */
    @Override
    public List<RecordObject> search(String inputString) {

        List<RecordObject> retList = getAllComments();

        //Assuming search is CASE_INSENSITIVE
        String regEx = "(.*?)" + inputString + "(.*?)";

        Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);

        if (null != inputString && inputString.length() > 0) {

            retList = retList.stream().filter(record -> {
                String comment = record.getComment();
                Matcher matcher = pattern.matcher(comment);
                if (matcher.find()) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
        }

        return retList;
    }
    
    /* This method is used to get the all the comments that we have in record.csv
     * we can extend this method to perform a DB call 
     */
    public List<RecordObject> getAllComments() {
        
        return CommentsManagerDao.getInstance().getRecords();

    }

}
