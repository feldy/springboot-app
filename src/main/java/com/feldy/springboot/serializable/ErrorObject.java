/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.feldy.springboot.serializable;

import java.io.Serializable;

/**
 *
 * @author feldy
 */
public class ErrorObject implements Serializable {
    private static final long serialVersionUID = 1L;
	
    private String msg;
    private Boolean isError = Boolean.FALSE;

    public String getMsg() {
            return msg;
    }

    public void setMsg(String msg) {
            this.msg = msg;
    }

    public Boolean getIsError() {
            return isError;
    }

    public void setIsError(Boolean isError) {
            this.isError = isError;
    }
}
