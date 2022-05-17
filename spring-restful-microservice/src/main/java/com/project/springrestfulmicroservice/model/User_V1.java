package com.project.springrestfulmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_V1 {

    private long id;

    private String name;

    private long age;

    private String details;

}
