/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feldy.springboot.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author feldy
 */
@Entity 
@Table(name = "m_product")
public class Product extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false, unique = true)
    private String kode;
    
    @Column(nullable = false, unique = true)
    private String nama;
    
    @Column(nullable = false)
    private String price;
    
    @OneToMany(mappedBy = "productSID", fetch = FetchType.LAZY)
    private List<Sales> productSIDSales = new ArrayList<>();

    public List<Sales> getProductSIDSales() {
        return productSIDSales;
    }

    public void setProductSIDSales(List<Sales> productSIDSales) {
        this.productSIDSales = productSIDSales;
    }
    
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
