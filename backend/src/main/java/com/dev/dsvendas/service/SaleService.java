package com.dev.dsvendas.service;

import java.util.List;

import com.dev.dsvendas.dto.SaleDTO;
import com.dev.dsvendas.dto.SaleSuccessDTO;
import com.dev.dsvendas.dto.SaleSumDTO;
import com.dev.dsvendas.entities.Sale;
import com.dev.dsvendas.repositories.SaleRepository;
import com.dev.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

        @Autowired
        private SaleRepository repository;

        @Autowired
        private SellerRepository sellerRepository;

        @Transactional(readOnly = true)
        public Page<SaleDTO> findAll(Pageable pageable) {
                sellerRepository.findAll();
                Page<Sale> result  = repository.findAll(pageable);
                return result.map( x -> new SaleDTO(x));
        }

        @Transactional(readOnly = true)
        public List<SaleSumDTO> amountGroupedBySeller() {
                return repository.amountGroupedBySeller();
        }

        public List<SaleSuccessDTO> successGroupedBySeller() {
                return repository.successGroupedBySeller();
        }
        
}
