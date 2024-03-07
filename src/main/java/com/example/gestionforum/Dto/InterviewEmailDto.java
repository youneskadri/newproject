package com.example.gestionforum.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InterviewEmailDto {
    private String firstName;
    private String lastName;
    private String email;
    private String type;
    private String link;
    private LocalDateTime date;
}
