package com.dev.dsvendas.service;

import com.dev.dsvendas.dto.SaleDTO;
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

        
        
}