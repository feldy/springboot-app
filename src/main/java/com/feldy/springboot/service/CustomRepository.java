/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feldy.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author feldy
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class CustomRepository {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private EntityManager em;
    
    public List<Map<String, Object>> findAllByKode(final String kode) {
        logger.debug(">>>> masuk custom query");
        
        Map<String, Object> result = new HashMap<>();
        final List<String> filters = new ArrayList<>();
        final Map<String, Object> parameterMaps = new HashMap<>();
        
        if (!StringUtils.isEmpty(kode)) {
            parameterMaps.put("prmKode", "%" + kode + "%");
            filters.add(" obj.kode like :prmKode ");
        }
        
        final StringBuilder strFilters = new StringBuilder();
        int cnt = 0;
        for (String str : filters) {
            if (cnt == 0) {
                strFilters.append("where ").append(str);
            } else {
                strFilters.append("and ").append(str);
            }
            cnt += 1;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT  new map(obj.id as id, obj.kode as kode) ");
        sb.append("FROM    Product obj  ");
        sb.append(strFilters.toString());

        Query qry = em.createQuery(sb.toString());
        for (Parameter<?> str : qry.getParameters()) {
            qry.setParameter(str.getName(), parameterMaps.get(str.getName()));
        }
        
        return qry.getResultList(); 
    }
}
