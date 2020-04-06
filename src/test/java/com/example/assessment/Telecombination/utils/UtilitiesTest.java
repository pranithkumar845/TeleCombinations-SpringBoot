package com.example.assessment.Telecombination.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void sanitizePhoneNumber() {
        int[] expectedPhoneNumber = {2, 4, 1, 0, 1, 8, 9};
        int[] sanitizedPhoneNumber = Utilities.sanitizePhoneNumber("2410189");
        Assert.assertTrue(Arrays.equals(expectedPhoneNumber, sanitizedPhoneNumber));
    }

    @Test
    void sanitizePhoneNumberNegativeCase() {
        int[] expectedPhoneNumber = {2, 4, 1, 0, 1, 8};
        int[] sanitizedPhoneNumber = Utilities.sanitizePhoneNumber("2410189");
        Assert.assertFalse(Arrays.equals(expectedPhoneNumber, sanitizedPhoneNumber));
    }


    @Test
    void validQueryParamsTest() {
        try {
            boolean isValid = Utilities.isValidQueryParams(200);
            Assert.assertTrue(isValid);
        } catch (Exception ex) {
            Assert.fail();
        }
    }

    @Test
    void validNullQueryParamsTest() {
        try {
            boolean isValid = Utilities.isValidQueryParams(null);
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof NullPointerException);

        }

    }

    @Test
    void validLessThanZeroQueryParamsTest() {
        boolean isValid = false;
        try {
            isValid = Utilities.isValidQueryParams(-1);
        } catch (Exception ex) {
            Assert.assertFalse(isValid);
        }

    }
}