package com.example.assessment.Telecombination.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Responses {
    private List<Combination> combinations;
    private Integer size;
}
