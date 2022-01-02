package com.dev.dsvendas.dto;

import java.time.LocalDate;

import com.dev.dsvendas.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

        private Long id;
        private Integer visited;
        private Integer deals;
        private Double amount;
        private LocalDate date;
        
        private SellerDTO seller;

        public SaleDTO(Sale entity) {
                id = entity.getId();
                visited = entity.getVisited();
                deals = entity.getDeals();
                amount = entity.getAmount();
                date = entity.getDate();
                seller = new SellerDTO(entity.getSeller());
        }
}
