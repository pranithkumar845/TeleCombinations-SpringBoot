package com.example.assessment.Telecombination.service.serviceImpl;

import com.example.assessment.Telecombination.service.CombinationsService;
import com.example.assessment.Telecombination.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CombinationsServiceImpl implements CombinationsService {

    private static final String[] KEYPAD_MAP = {"0", "1", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    @Override
    public List<String> getAllCombinations(String phoneNumber) {
        log.info("Phone number received {}", phoneNumber);
        return createCombinations(phoneNumber);
    }

    private List<String> createCombinations(String phoneNumber) {
        int[] numbers = Utilities.sanitizePhoneNumber(phoneNumber);
        log.info("Numbers <{}>", numbers);
        List<String> numberCombinations = letterCombinations(numbers, phoneNumber.length());
        numberCombinations = numberCombinations.stream().distinct().filter(number -> !number.equals(phoneNumber)).collect(Collectors.toList());
        log.info("returning {} combinations", numberCombinations.size());
        return numberCombinations;
    }


    private List<String> letterCombinations(int[] numberChar, int size) {
        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while (!queue.isEmpty()) {
            String str = queue.remove();
            if (str.length() == size)
                list.add(str);
            else {
                String value = KEYPAD_MAP[numberChar[str.length()]];
                for (int index = 0; index <= value.length(); index++) {
                    if (index == value.length())
                        queue.add(str + numberChar[str.length()]);
                    else
                        queue.add(str + value.charAt(index));

                }
            }
        }
        return list;
    }
}
