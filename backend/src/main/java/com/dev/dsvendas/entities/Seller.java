package com.dev.dsvendas.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_sellers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        @OneToMany(mappedBy = "seller")
        private List<Sale> sales = new ArrayList<>();
}
