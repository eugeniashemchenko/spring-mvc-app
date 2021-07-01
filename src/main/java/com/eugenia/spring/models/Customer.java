package com.eugenia.spring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//our model of customer will contain id and name
public class Customer {
    private int id;
    private String name;
//if creating new one
    public Customer() {

    }
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
