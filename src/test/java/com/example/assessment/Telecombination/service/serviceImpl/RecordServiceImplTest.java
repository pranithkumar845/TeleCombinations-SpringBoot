package com.example.assessment.Telecombination.service.serviceImpl;

import com.example.assessment.Telecombination.pojo.Combination;
import com.example.assessment.Telecombination.pojo.Responses;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Objects;


@RunWith(SpringJUnit4ClassRunner.class)
class RecordServiceImplTest {

    @Autowired
    CombinationsServiceImpl combinationsService = new CombinationsServiceImpl();
    @Autowired
    RecordServiceImpl recordService = new RecordServiceImpl(combinationsService);

    @Test
    void getRecordsSizeTest() {

        Combination combination = new Combination();
        combination.setCombination("11");
        combination.setId(1);
        Responses expectedResponses = new Responses();
        expectedResponses.setCombinations(Arrays.asList());
        Responses responses = recordService.getRecords("12", 2);
        Assert.assertTrue("get size failed", responses.getSize()==3);

    }

    @Test
    void getRecordsTest() {
        Combination combination = new Combination();
        combination.setCombination("11");
        combination.setId(1);
        Responses expectedResponses = new Responses();
        expectedResponses.setCombinations(Arrays.asList());
        Responses responses = recordService.getRecords("12", 2);
        Assert.assertTrue("get size failed", responses.getCombinations().size()==2);
        Assert.assertFalse("empty combination ", responses.getCombinations().get(0).getCombination().isEmpty());
        Assert.assertTrue("null id ", Objects.nonNull(responses.getCombinations().get(0).getId()));

    }

}