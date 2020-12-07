/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject.shopfront.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author root
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer productid;
    
    private String productname;
   
    private String description;
    
    private BigDecimal price;

    public Product() {
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
    
}
