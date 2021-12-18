package com.amaris.repository;

import com.amaris.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findAllByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long brandId, Long productId, LocalDateTime date1, LocalDateTime date2);
}
