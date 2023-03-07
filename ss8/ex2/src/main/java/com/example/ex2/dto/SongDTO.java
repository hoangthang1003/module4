package com.example.ex2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {

    private Integer id;

    @NotEmpty
    @NotBlank
    @Size(max = 800)
    private String name;

    @NotEmpty
    @NotBlank
    @Size(max = 300)
    private String performer;

    @NotEmpty
    @NotBlank
    @Size(max = 1000)
    private String genre;

    public SongDTO() {
    }

    public SongDTO(Integer id,
                   @NotEmpty @NotBlank @Size(max = 800) String name,
                   @NotEmpty @NotBlank @Size(max = 300) String performer,
                   @NotEmpty @NotBlank @Size(max = 1000) String genre) {
        this.id = id;
        this.name = name;
        this.performer = performer;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override

    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO song = (SongDTO) target;

        String name = song.getName();
        String performer = song.getPerformer();
        String genre = song.getGenre();

        if (!name.matches("^[0-9A-Za-z ]*$")) {
            errors.rejectValue("name", "name.matches", "something something");
        }

        if (!performer.matches("^[0-9A-Za-z ]+$")) {
            errors.rejectValue("performer", "performer.matches", "something something");
        }

        if (!genre.matches("^[0-9A-Za-z, ]+$")) {
            errors.rejectValue("genre", "genre.matches", "something something");
        }
    }
}
