/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject.stockmanager.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import myproject.stockmanager.entity.Stock;

/**
 *
 * @author root
 */
@Named
@ApplicationScoped
public class StockService {

    EntityManager em;
    Collection<Integer> availablIds;

    public StockService() {
        em = Persistence.createEntityManagerFactory("stockpu").createEntityManager();

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Integer> getAvailablIds() {
        availablIds = new ArrayList<Integer>();
        Collection<Stock> stocks = em.createQuery("SELECT s from Stock s where s.quantity != 0").getResultList();
        for (Stock s : stocks) {
            availablIds.add(s.getProductid().getProductid());
        }

        return availablIds;
    }

    public void setAvailablIds(Collection<Integer> availablIds) {
        this.availablIds = availablIds;
    }

}
