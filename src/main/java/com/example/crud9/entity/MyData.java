package com.example.crud9.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class MyData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonProperty("phone_number")
    @Column(length = 20)
    private Integer phonenumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "you_id")
    private YouData youData;
}
