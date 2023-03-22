package com.sykp.statsapiservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsSource {
    private String id;
    private String name;

    @JsonCreator
    public NewsSource(@JsonProperty("id") String id,
                      @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}