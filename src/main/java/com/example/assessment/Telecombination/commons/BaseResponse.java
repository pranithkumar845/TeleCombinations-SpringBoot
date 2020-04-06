package com.example.assessment.Telecombination.commons;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    @NonNull
    private Integer statusCode;
    @NonNull
    private String mainMessage;
    private Object data;

    public BaseResponse(Integer statusCode, Object data, String mainMessage) {
        this.statusCode = statusCode;
        this.data = data;
        this.mainMessage = mainMessage;
    }

    @NonNull
    public Integer getStatusCode() {
        return this.statusCode;
    }

    @NonNull
    public String getMainMessage() {
        return this.mainMessage;
    }


    public String toString() {
        return "BaseResponse(internalStatusCode=" + this.getStatusCode() + ", mainMessage=" + this.getMainMessage() + ", data=" + this.getData() + ")";
    }
}
