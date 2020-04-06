package com.example.assessment.Telecombination.service.serviceImpl;

import com.example.assessment.Telecombination.pojo.Combination;
import com.example.assessment.Telecombination.pojo.Responses;
import com.example.assessment.Telecombination.service.CombinationsService;
import com.example.assessment.Telecombination.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private CombinationsService combinationsService;


    public RecordServiceImpl(CombinationsService combinationsService) {
        this.combinationsService = combinationsService;
    }

    @Override
    public Responses getRecords(String phoneNumber, int pageSize) {
        List<String> numbers = combinationsService.getAllCombinations(phoneNumber);
        log.info("Returning combinations {}", numbers);
        Responses responses = new Responses();
        responses.setSize(numbers.size());
        numbers.stream().sorted().collect(Collectors.toList());
        List<Combination> combinations = new ArrayList<>();
        for (int index = 1; index <= numbers.size(); index++) {
            Combination combination = new Combination();
            combination.setId(index);
            combination.setCombination(numbers.get(index - 1));
            combinations.add(combination);
        }
        responses.setCombinations(combinations.stream().limit(pageSize).collect(Collectors.toList()));
        return responses;
    }
}
