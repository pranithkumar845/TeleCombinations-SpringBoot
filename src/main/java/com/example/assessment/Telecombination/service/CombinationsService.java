package com.example.assessment.Telecombination.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CombinationsService {

    public List<String> getAllCombinations(String phoneNumber);

}
