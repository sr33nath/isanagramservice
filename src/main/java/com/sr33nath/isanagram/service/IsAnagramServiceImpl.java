package com.sr33nath.isanagram.service;

import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.hasLength;

import java.util.Arrays;

@Service
public class IsAnagramServiceImpl implements IsAnagramService {
    public boolean check(String firstString, String secondString){

        if(!hasLength(firstString) || !hasLength(secondString))
            return false;

        if(firstString.length() != secondString.length())
            return false;

        if(firstString.equals(secondString))
            return true;

        char[] firstStringArr = firstString.toCharArray();
        char[] secondStringArr = secondString.toCharArray();

        int[] charCount = new int[65536];

        for(int i=0; i<firstStringArr.length; i++){
            charCount[firstStringArr[i]]++;
            charCount[secondStringArr[i]]--;
        }

        return Arrays
                .stream(charCount)
                .parallel()
                .allMatch(count -> count == 0);
    }
}
