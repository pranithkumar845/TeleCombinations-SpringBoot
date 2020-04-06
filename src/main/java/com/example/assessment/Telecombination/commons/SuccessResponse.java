package com.example.assessment.Telecombination.commons;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse extends BaseResponse {
    public SuccessResponse() {
        super(0, (Object) null, "successfully done");
    }

    public SuccessResponse(Object data) {
        super(0, data, "successfully done");
    }

    public SuccessResponse(int statusCode,Object data, String mainMessage) {
        super(statusCode, data, mainMessage);
    }


    public String toString() {
        return "SuccessResponse()";
    }
}