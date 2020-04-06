package com.example.assessment.Telecombination.controller;

import com.example.assessment.Telecombination.commons.BaseResponse;
import com.example.assessment.Telecombination.service.RecordService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(MockitoExtension.class)
@WebAppConfiguration
class TeleControllerTest {


    @InjectMocks
    TeleController teleController ;
    @Mock
    RecordService recordService;

    @Test
    void controllerTest()  {
        BaseResponse baseResponse = teleController.getRecords("12",2);
        Assert.assertEquals(Integer.valueOf(0),baseResponse.getStatusCode());
        Assert.assertEquals("successfully done",baseResponse.getMainMessage());
    }
    @Test
    void controllerNegativePsizeTest() {
        BaseResponse baseResponse = teleController.getRecords("12",-1);
        Assert.assertEquals(Integer.valueOf(-1),baseResponse.getStatusCode());
        Assert.assertEquals("Error java.lang.Exception: page offset cannot be less than 0",baseResponse.getMainMessage());
    }
}