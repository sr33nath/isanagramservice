package com.sr33nath.isanagram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ServiceRequest (
    @JsonProperty(required = true) String firstString,
    @JsonProperty(required = true) String secondString
){
}
