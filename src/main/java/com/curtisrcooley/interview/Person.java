package com.curtisrcooley.interview;

public record Person(String name, String phone, Integer age, Address address){}
record Address(String city, String state){}