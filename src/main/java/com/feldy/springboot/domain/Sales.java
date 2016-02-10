/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feldy.springboot.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author feldy
 */
@Entity 
@Table(name = "m_sales")
public class Sales extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "product_sid", nullable = false)
    private Product productSID;
    
    @Column(nullable = false)
    private Integer qty;
    
    @Column(nullable = false)
    private BigDecimal discount;

    public Product getProductSID() {
        return productSID;
    }

    public void setProductSID(Product productSID) {
        this.productSID = productSID;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    
    
}
