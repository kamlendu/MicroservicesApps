/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.checking.acct.business;

import event.microservices.checking.acct.entity.CheckingAcct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */

@Stateless
public class CheckingAcctFacade {
   @PersistenceContext(unitName = "checkingpu")
    private EntityManager em;

   

    public CheckingAcctFacade() {
   //     super(CheckingAcct.class);
    }

    public void edit(CheckingAcct cacct)
    {
        CheckingAcct acct = em.find(CheckingAcct.class, cacct.getId());
        System.out.println("Edit Balance "+cacct.getAcctBalance());
        acct.setAcctBalance(cacct.getAcctBalance());
        em.merge(acct);
         System.out.println("Balance Saved- New Balance "+acct.getAcctBalance());
       
    }
    public CheckingAcct findByAcctNbr(Long acctNbr) {
        TypedQuery<CheckingAcct> typedQuery = em.createNamedQuery("CheckingAcct.findByAcctNbr", CheckingAcct.class);
        typedQuery.setParameter("acctNbr", acctNbr);

        return typedQuery.getSingleResult();
    }  
}
