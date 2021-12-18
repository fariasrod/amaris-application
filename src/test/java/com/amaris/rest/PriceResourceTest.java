package com.amaris.rest;

import com.amaris.AmarisTestApplication;
import com.amaris.model.response.PriceResponse;
import com.amaris.service.PriceService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.amaris.util.Convert.toLocalDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = AmarisTestApplication.class)
@AutoConfigureMockMvc
public class PriceResourceTest {

    private static final Long BRAND_ID = 1L;
    private static final Long PRODUCT_ID = 1L;
    private static final BigDecimal PRICE = BigDecimal.TEN;
    private static final String STR_DATE = "2028-01-01 12:00";
    private static final String API = "/api/v1/prices";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PriceService service;

    @Test
    @DisplayName("Trying to get a Price and the return should be 200")
    public void findShouldReturn200() throws Exception {
        var localDateTime = toLocalDateTime(STR_DATE);
        var response = priceResponse(localDateTime);

        given(service.find(localDateTime, BRAND_ID, PRODUCT_ID)).willReturn(response);
        mvc.perform(get(API)
                        .param("date", STR_DATE)
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.productId", is(1)));
    }

    @Test
    @DisplayName("Trying to get a Price and the return should be 204")
    public void findShouldReturn204() throws Exception {
        var localDateTime = toLocalDateTime(STR_DATE);

        given(service.find(localDateTime, BRAND_ID, PRODUCT_ID)).willReturn(null);
        mvc.perform(get(API)
                        .param("date", STR_DATE)
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    private PriceResponse priceResponse(LocalDateTime localDateTime) {
        return PriceResponse.builder()
                .startDate(localDateTime)
                .endDate(localDateTime.plusDays(10))
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .price(PRICE)
                .build();
    }
}
