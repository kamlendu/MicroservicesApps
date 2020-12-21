/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.savings.acct.business;

import event.microservices.savings.acct.entities.SavingsAcct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class SavingsAcctFacade {
    @PersistenceContext(unitName = "savingspu")
     EntityManager em;
    

    public SavingsAcct findByAcctNbr(Long acctNbr)
    {
        SavingsAcct sacct =null;
        try{
       sacct= (SavingsAcct) em.createNamedQuery("SavingsAcct.findByAcctNbr").setParameter("acctNbr", acctNbr).getSingleResult();  
        }
        catch(Exception e)
        {
            
        }
        return  sacct;
    }
    
    public void edit(SavingsAcct sa)
    {
        SavingsAcct sacct = (SavingsAcct)em.find(SavingsAcct.class, sa.getId());
        sacct.setAcctBalance(sa.getAcctBalance());
        em.merge(sacct);
    }
}
