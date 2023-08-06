package com.sr33nath.isanagram.controller;

import com.sr33nath.isanagram.model.ServiceRequest;
import com.sr33nath.isanagram.service.IsAnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {
    @Autowired
    private IsAnagramService isAnagramService;
    @RequestMapping(value = "/isAnagram",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String isAnagram(@RequestBody ServiceRequest request){
        return Boolean.toString(
                isAnagramService.check(request.firstString(),
                        request.secondString()));
    }
}
