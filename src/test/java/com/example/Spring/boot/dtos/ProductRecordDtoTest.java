package com.example.Spring.boot.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ProductRecordDtoTest {
    @Test
    void testConstructor() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        ProductRecordDto actualProductRecordDto = new ProductRecordDto("Name", valueOfResult);

        assertEquals("Name", actualProductRecordDto.name());
        BigDecimal valueResult = actualProductRecordDto.value();
        assertSame(valueOfResult, valueResult);
        assertEquals(0, valueResult.scale());
        assertEquals("42", valueResult.toString());
        assertEquals(1, valueResult.signum());
    }

    @Test
    void testName() {
        assertEquals("Name", (new ProductRecordDto("Name", BigDecimal.valueOf(42L))).name());
    }


    @Test
    void testValue() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        BigDecimal actualValueResult = (new ProductRecordDto("Name", valueOfResult)).value();
        assertSame(valueOfResult, actualValueResult);
        assertEquals("42", actualValueResult.toString());
    }
}

