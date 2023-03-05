package com.example.spring01.model;


import java.time.LocalDate;
import java.time.LocalDateTime;

public  record Content(Integer id, String title, String desc,
                       Status status, Type contentType,
                       LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
}
