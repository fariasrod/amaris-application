package com.amaris.service;

import com.amaris.model.Price;
import com.amaris.model.response.PriceResponse;
import com.amaris.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Slf4j
@Service
public class PriceService {

    private final PriceRepository repository;

    @Autowired
    public PriceService(PriceRepository repository) {
        this.repository = repository;
    }

    public PriceResponse find(LocalDateTime date, Long brandId, Long productId) {
        log.info(String.format("Trying to find a Price by brandId { %s } and productId { %s } and date { %s }.", brandId, productId, date));

        var result = repository
                .findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(brandId, productId, date, date);

        var price = result
                .stream()
                .max(Comparator.comparing(Price::getPriority));

        return price.map(this::toResponse).orElse(null);
    }

    private PriceResponse toResponse(Price price) {
        return PriceResponse.builder()
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .price(price.getPrice())
                .build();
    }
}
