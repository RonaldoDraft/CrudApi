package com.example.Spring.boot.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ProductRecordDtoTest {


    @Test
    void testConstructor() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        ProductRecordDto actualProductRecordDto = new ProductRecordDto("Name", valueOfResult, "Tipe", "Moeda");

        assertEquals("Moeda", actualProductRecordDto.moeda());
        BigDecimal valueResult = actualProductRecordDto.value();
        assertSame(valueOfResult, valueResult);
        assertEquals("Tipe", actualProductRecordDto.tipe());
        assertEquals("Name", actualProductRecordDto.name());
        assertEquals(1, valueResult.signum());
        assertEquals(0, valueResult.scale());
        assertEquals("42", valueResult.toString());
    }

    @Test
    void testMoeda() {
        assertEquals("Moeda", (new ProductRecordDto("Name", BigDecimal.valueOf(42L), "Tipe", "Moeda")).moeda());
    }

    @Test
    void testName() {
        assertEquals("Name", (new ProductRecordDto("Name", BigDecimal.valueOf(42L), "Tipe", "Moeda")).name());
    }

    @Test
    void testTipe() {
        assertEquals("Tipe", (new ProductRecordDto("Name", BigDecimal.valueOf(42L), "Tipe", "Moeda")).tipe());
    }

    @Test
    void testValue() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        BigDecimal actualValueResult = (new ProductRecordDto("Name", valueOfResult, "Tipe", "Moeda")).value();
        assertSame(valueOfResult, actualValueResult);
        assertEquals("42", actualValueResult.toString());
    }

}

