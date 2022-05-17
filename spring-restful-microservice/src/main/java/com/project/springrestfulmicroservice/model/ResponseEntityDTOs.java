package com.project.springrestfulmicroservice.model;
import lombok.Data;

import  java.util.*;
@Data
public class ResponseEntityDTOs {

    private Object obj;

    private String message;

    private List<?> dtoList;
}
