package com.example.assessment.Telecombination.controller;

import com.example.assessment.Telecombination.commons.BaseResponse;
import com.example.assessment.Telecombination.commons.SuccessResponse;
import com.example.assessment.Telecombination.service.RecordService;
import com.example.assessment.Telecombination.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TeleController {

    @Autowired
    RecordService recordService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/api/v1/records/{phoneNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public BaseResponse getRecords(@PathVariable String phoneNumber,
                                   @RequestParam(value = "pSize") Integer pageSize) {
        try {
            if (Utilities.isValidQueryParams(pageSize)) {
                log.info("id {} , pageSize {} ", phoneNumber, pageSize);
                return new SuccessResponse(recordService.getRecords(phoneNumber, pageSize));
            }
            return new SuccessResponse(1, null, "Something went wrong");
        } catch (Exception ex) {
            log.error("Error occurred : " + ex);
            return new SuccessResponse(-1, null, "Error " + ex);
        }
    }

}
