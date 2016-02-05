/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feldy.springboot.service;

import com.feldy.springboot.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author feldy
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
