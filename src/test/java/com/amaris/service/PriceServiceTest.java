package com.amaris.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static com.amaris.util.Convert.toLocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceTest {

    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 1L;

    @Autowired
    private PriceService service;

    @Test
    @DisplayName("Trying to get a Price by date using Scenario one")
    public void findPriceScenario1() {

        var response = service.find(toLocalDateTime("2020-06-14 10:00"), BRAND_ID, PRODUCT_ID);
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(new BigDecimal("35.50"), response.getPrice());
    }

    @Test
    @DisplayName("Trying to get a Price using Scenario two")
    public void findPriceScenario2() {

        var response = service.find(toLocalDateTime("2020-06-14 16:00"), BRAND_ID, PRODUCT_ID);
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(new BigDecimal("25.45"), response.getPrice());
    }

    @Test
    @DisplayName("Trying to get a Price using Scenario three")
    public void findPriceScenario3() {

        var response = service.find(toLocalDateTime("2020-06-14 21:00"), BRAND_ID, PRODUCT_ID);
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(new BigDecimal("35.50"), response.getPrice());
    }

    @Test
    @DisplayName("Trying to get a Price using Scenario four")
    public void findPriceScenario4() {

        var response = service.find(toLocalDateTime("2020-06-15 10:00"), BRAND_ID, PRODUCT_ID);
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(new BigDecimal("30.50"), response.getPrice());
    }

    @Test
    @DisplayName("Trying to get a Price using Scenario five")
    public void findPriceScenario5() {

        var response = service.find(toLocalDateTime("2020-06-16 21:00"), BRAND_ID, PRODUCT_ID);
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(BRAND_ID, response.getBrandId());
        assertEquals(new BigDecimal("38.95"), response.getPrice());
    }

    @Test
    @DisplayName("Trying to get a Price and the return should be null")
    public void findPriceShouldReturnNull() {

        var response = service.find(toLocalDateTime("2028-01-01 12:00"), BRAND_ID, PRODUCT_ID);
        assertNull(response);
    }
}
