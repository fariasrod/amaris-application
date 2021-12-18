package com.amaris.rest;

import com.amaris.model.response.PriceResponse;
import com.amaris.service.PriceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Api(value = "Price Resource", tags = "Price Resource")
@RestController
@RequestMapping(value = "/api/v1/prices", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceResource {

    private final PriceService service;

    @Autowired
    public PriceResource(PriceService service) {
        this.service = service;
    }

    @ApiOperation("Find Price")
    @GetMapping
    public ResponseEntity<PriceResponse> find(@ApiParam("2020-06-17 20:00") @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime date,
                                              @ApiParam @RequestParam("brandId") Long brandId,
                                              @ApiParam @RequestParam("productId") Long productId) {

        var response = service.find(date, brandId, productId);

        if (response == null)
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(service.find(date, brandId, productId), HttpStatus.OK);
    }
}
