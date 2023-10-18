package com.example.Spring.boot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
// record e imutavel

public record ProductRecordDto(@NotBlank String name,@NotNull BigDecimal value) {



}
