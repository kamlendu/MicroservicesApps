/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject.productcatalogue.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import myproject.productcatalogue.entity.Product;
import myproject.productcatalogue.entity.Stock;

/**
 *
 * @author root
 */
@Named
@ApplicationScoped
public class ProductService {
    EntityManager em;
    Collection<Product> products;
    Collection<Product> availableProducts;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Product> getAvailableProducts(Collection<Integer> ids) {
    
    //Collection<Integer> ids = new ArrayList<Integer>();
    //ids.add(4);ids.add(5);ids.add(6);ids.add(2);
     
        //Collection<Stock> availableSavailableProductstock = em.createNamedQuery("Stock.findAll").getResultList();
       String allids = convertIntCollectionToString(ids);
       
     availableProducts =  em.createQuery("SELECT p from Product p WHERE p.productid IN ("+allids+")").getResultList();
        return availableProducts;
    }

    private String convertIntCollectionToString(Collection<Integer> ids)
            
    {
        String intString="";
        for(Integer i : ids)
        {
            intString += i.toString() +",";
        }
        return intString.substring(0, intString.length()-1);
    }
    
    
    public void setAvailableProducts(Collection<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }
    
    public ProductService() {
        em = Persistence.createEntityManagerFactory("productpu").createEntityManager();
    }

    public Collection<Product> getProducts() {
               
        return em.createNamedQuery("Product.findAll").getResultList();
    }

    public void setProducts(Collection<Product> products) {
        
        this.products= products;
    }
    
    
}
