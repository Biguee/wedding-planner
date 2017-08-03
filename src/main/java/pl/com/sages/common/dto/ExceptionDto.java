package pl.com.sages.common.dto;

import lombok.Data;

@Data
public class ExceptionDto {

    private String description;

    public ExceptionDto() {
    }

    public ExceptionDto(String description) {
        this.description = description;
    }

}
