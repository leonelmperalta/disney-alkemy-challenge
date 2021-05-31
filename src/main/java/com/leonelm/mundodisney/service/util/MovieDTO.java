package com.leonelm.mundodisney.service.util;

import java.time.LocalDate;

public class MovieDTO {
    private Long id;
    private String title;
    private String url;
    private LocalDate creationDate;

    public MovieDTO(Long id, String title, String url, LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
