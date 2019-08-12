package com.keyword.search.service;

import java.util.List;

import com.keyword.pojo.RecordObject;


public interface PerformOperationService {

    public void deleteComment(int recordId);
    
    public List<RecordObject> search(String inputString);
    
}
