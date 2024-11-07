package com.curtisrcooley.interview;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiv1")
public class Controller {
    private final ObjectMapper objectMapper;

    public Controller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("person")
    public void person(@RequestBody String json) {
        try {
            Person p = objectMapper.readValue(json, Person.class);
            System.out.println(p.name() + " " + p.phone() + " " + p.age());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
