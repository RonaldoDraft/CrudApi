package com.example.Spring.boot.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class ProductModelTest {

    @Test
    void testCanEqual() {
        assertFalse((new ProductModel()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        ProductModel productModel = new ProductModel();
        assertTrue(productModel.canEqual(new ProductModel()));
    }

    @Test
    void testConstructor() {
        ProductModel actualProductModel = new ProductModel();
        UUID randomUUIDResult = UUID.randomUUID();
        actualProductModel.setIdproduct(randomUUIDResult);
        actualProductModel.setMoeda("Moeda");
        actualProductModel.setName("Name");
        actualProductModel.setTipe("Tipe");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualProductModel.setValue(valueOfResult);
        actualProductModel.toString();
        assertSame(randomUUIDResult, actualProductModel.getIdproduct());
        assertEquals("Moeda", actualProductModel.getMoeda());
        assertEquals("Name", actualProductModel.getName());
        assertEquals("Tipe", actualProductModel.getTipe());
        assertSame(valueOfResult, actualProductModel.getValue());
    }


    @Test
    void testConstructor2() {
        UUID idproduct = UUID.randomUUID();
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        ProductModel actualProductModel = new ProductModel(idproduct, "Name", valueOfResult, "Moeda", "Tipe");
        UUID randomUUIDResult = UUID.randomUUID();
        actualProductModel.setIdproduct(randomUUIDResult);
        actualProductModel.setMoeda("Moeda");
        actualProductModel.setName("Name");
        actualProductModel.setTipe("Tipe");
        BigDecimal valueOfResult1 = BigDecimal.valueOf(42L);
        actualProductModel.setValue(valueOfResult1);
        actualProductModel.toString();
        assertSame(randomUUIDResult, actualProductModel.getIdproduct());
        assertEquals("Moeda", actualProductModel.getMoeda());
        assertEquals("Name", actualProductModel.getName());
        assertEquals("Tipe", actualProductModel.getTipe());
        BigDecimal value = actualProductModel.getValue();
        assertSame(valueOfResult1, value);
        assertEquals(valueOfResult, value);
    }


    @Test
    void testEquals() {
        assertNotEquals(new ProductModel(), null);
        assertNotEquals(new ProductModel(), "Different type to ProductModel");
    }


    @Test
    void testEquals2() {
        ProductModel productModel = new ProductModel();
        assertEquals(productModel, productModel);
        int expectedHashCodeResult = productModel.hashCode();
        assertEquals(expectedHashCodeResult, productModel.hashCode());
    }


    void testEquals3() {
        ProductModel productModel = new ProductModel();
        ProductModel productModel1 = new ProductModel();
        assertEquals(productModel, productModel1);
        int expectedHashCodeResult = productModel.hashCode();
        assertEquals(expectedHashCodeResult, productModel1.hashCode());
    }


    @Test
    void testEquals4() {
        UUID idproduct = UUID.randomUUID();
        ProductModel productModel = new ProductModel(idproduct, "Name", BigDecimal.valueOf(42L), "Moeda", "Tipe");
        assertNotEquals(productModel, new ProductModel());
    }


    @Test
    void testEquals5() {
        ProductModel productModel = new ProductModel();
        UUID idproduct = UUID.randomUUID();
        assertNotEquals(productModel, new ProductModel(idproduct, "Name", BigDecimal.valueOf(42L), "Moeda", "Tipe"));
    }


    @Test
    void testEquals6() {
        ProductModel productModel = new ProductModel();
        productModel.setName("Name");
        assertNotEquals(productModel, new ProductModel());
    }

    @Test
    void testEquals7() {
        ProductModel productModel = new ProductModel();
        productModel.setValue(BigDecimal.valueOf(42L));
        assertNotEquals(productModel, new ProductModel());
    }


    @Test
    void testEquals8() {
        ProductModel productModel = new ProductModel();
        productModel.setMoeda("Moeda");
        assertNotEquals(productModel, new ProductModel());
    }


    @Test
    void testEquals9() {
        ProductModel productModel = new ProductModel();
        productModel.setTipe("Tipe");
        assertNotEquals(productModel, new ProductModel());
    }

    @Test
    void testEquals10() {
        ProductModel productModel = new ProductModel();

        ProductModel productModel1 = new ProductModel();
        productModel1.setName("Name");
        assertNotEquals(productModel, productModel1);
    }

    @Test
    void testEquals11() {
        ProductModel productModel = new ProductModel();

        ProductModel productModel1 = new ProductModel();
        productModel1.setValue(BigDecimal.valueOf(42L));
        assertNotEquals(productModel, productModel1);
    }


    @Test
    void testEquals12() {
        ProductModel productModel = new ProductModel();

        ProductModel productModel1 = new ProductModel();
        productModel1.setMoeda("Moeda");
        assertNotEquals(productModel, productModel1);
    }


    @Test
    void testEquals13() {
        ProductModel productModel = new ProductModel();

        ProductModel productModel1 = new ProductModel();
        productModel1.setTipe("Tipe");
        assertNotEquals(productModel, productModel1);
    }


    @Test
    void testEquals14() {
        ProductModel productModel = new ProductModel();
        productModel.setName("Name");

        ProductModel productModel1 = new ProductModel();
        productModel1.setName("Name");
        assertEquals(productModel, productModel1);
        int expectedHashCodeResult = productModel.hashCode();
        assertEquals(expectedHashCodeResult, productModel1.hashCode());
    }


    @Test
    void testEquals15() {
        ProductModel productModel = new ProductModel();
        productModel.setValue(BigDecimal.valueOf(42L));

        ProductModel productModel1 = new ProductModel();
        productModel1.setValue(BigDecimal.valueOf(42L));
        assertEquals(productModel, productModel1);
        int expectedHashCodeResult = productModel.hashCode();
        assertEquals(expectedHashCodeResult, productModel1.hashCode());
    }


    @Test
    void testEquals16() {
        ProductModel productModel = new ProductModel();
        productModel.setMoeda("Moeda");

        ProductModel productModel1 = new ProductModel();
        productModel1.setMoeda("Moeda");
        assertEquals(productModel, productModel1);
        int expectedHashCodeResult = productModel.hashCode();
        assertEquals(expectedHashCodeResult, productModel1.hashCode());
    }


    @Test
    void testEquals17() {
        ProductModel productModel = new ProductModel();
        productModel.setTipe("Tipe");

        ProductModel productModel1 = new ProductModel();
        productModel1.setTipe("Tipe");
        assertEquals(productModel, productModel1);
        int expectedHashCodeResult = productModel.hashCode();
        assertEquals(expectedHashCodeResult, productModel1.hashCode());
    }
}

