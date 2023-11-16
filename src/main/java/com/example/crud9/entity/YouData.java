package com.example.crud9.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class YouData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonProperty("phone_number")
    private Integer phonenumber;

    @OneToMany(mappedBy = "youData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MyData> myDataList;
}
