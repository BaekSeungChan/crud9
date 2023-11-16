package com.example.crud9.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class YouDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, message = "so good")
    private String name;

    private Integer phonenumber;

    private Long myId;
}
