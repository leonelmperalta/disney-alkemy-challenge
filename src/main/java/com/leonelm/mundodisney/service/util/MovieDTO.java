package com.leonelm.mundodisney.service.util;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String url;
    private LocalDate creationDate;
}
