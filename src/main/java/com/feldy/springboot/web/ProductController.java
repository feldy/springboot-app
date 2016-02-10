/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feldy.springboot.web;

import com.feldy.springboot.domain.Product;
import com.feldy.springboot.serializable.ErrorObject;
import com.feldy.springboot.service.CustomRepository;
import com.feldy.springboot.service.ProductRepository;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author feldy
 */
@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired private ProductRepository productRepository;
    @Autowired private CustomRepository cr;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/halo")
    public String halo() {
        return "pa kabar coyy";
    }
    
    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public Iterable<Product> allProduct() {
        return productRepository.findAll();
    }
    
    @RequestMapping(value = "/product/custom", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> allProductByKode(
            @RequestParam(value = "kode", required = false) String kode,
            HttpServletResponse response) throws Exception {
        return cr.findAllByKode(kode);
    }
    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveProduct(@RequestBody Product p,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        cr.saveDataProduct(p);
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorObject handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        ErrorObject obj = new ErrorObject();
        obj.setMsg(ex.getMessage());

        return obj;
    }
}
