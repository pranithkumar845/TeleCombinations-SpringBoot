package com.example.assessment.Telecombination.service;

import com.example.assessment.Telecombination.pojo.Responses;
import org.springframework.stereotype.Service;

@Service
public interface RecordService {
    public Responses getRecords(String phoneNumber, int pageSize);
}