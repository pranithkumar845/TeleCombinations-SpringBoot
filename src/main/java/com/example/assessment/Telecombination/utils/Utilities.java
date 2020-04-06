package com.example.assessment.Telecombination.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utilities {
    public static int[] sanitizePhoneNumber(String phoneNumber) {
        int[] numbers = new int[phoneNumber.length()];
        for (int index = 0; index < phoneNumber.length(); index++) {
            numbers[index] = phoneNumber.charAt(index) - '0';
        }
        return numbers;
    }

    /*public static List<String> getPreservedIndices(int[] numbers) {
        List<String> indices = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            log.info("preserving indices {} ", index);
            indices.add(String.valueOf(index));
            for (int index2 = index + 1; index2 < numbers.length; index2++) {
                log.info("preserving indices {} , {} ", index, index2);
                indices.add(index + ":" + index2);
            }
        }
        log.info("Indices finally preserved {}", indices.toString());
        return indices;
    }*/

    public static boolean isValidQueryParams(Integer pageSize) throws Exception {
        if (pageSize == null)
            throw new NullPointerException("page offset cannot be null");
        if (pageSize < 0)
            throw new Exception("page offset cannot be less than 0");
        return true;
    }
}
