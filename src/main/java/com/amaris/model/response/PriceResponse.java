package com.amaris.model.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private Long brandId;
    private Long productId;
}
