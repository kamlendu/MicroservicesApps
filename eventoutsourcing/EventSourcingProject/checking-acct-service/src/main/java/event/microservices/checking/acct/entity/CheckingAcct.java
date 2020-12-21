/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.checking.acct.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CHECKING_ACCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CheckingAcct.findAll", query = "SELECT c FROM CheckingAcct c"),
    @NamedQuery(name = "CheckingAcct.findById", query = "SELECT c FROM CheckingAcct c WHERE c.id = :id"),
    @NamedQuery(name = "CheckingAcct.findByAcctBalance", query = "SELECT c FROM CheckingAcct c WHERE c.acctBalance = :acctBalance"),
    @NamedQuery(name = "CheckingAcct.findByAcctNbr", query = "SELECT c FROM CheckingAcct c WHERE c.acctNbr = :acctNbr"),
    @NamedQuery(name = "CheckingAcct.findBySavingsAcctNbr", query = "SELECT c FROM CheckingAcct c WHERE c.savingsAcctNbr = :savingsAcctNbr")})
public class CheckingAcct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ACCT_BALANCE")
    private Double acctBalance;
    @Column(name = "ACCT_NBR")
    private BigInteger acctNbr;
    @Column(name = "SAVINGS_ACCT_NBR")
    private BigInteger savingsAcctNbr;
    @JoinColumn(name = "ACCTHOLDER_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AcctHolder acctholderId;

    public CheckingAcct() {
    }

    public CheckingAcct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(Double acctBalance) {
        this.acctBalance = acctBalance;
    }

    public BigInteger getAcctNbr() {
        return acctNbr;
    }

    public void setAcctNbr(BigInteger acctNbr) {
        this.acctNbr = acctNbr;
    }

    public BigInteger getSavingsAcctNbr() {
        return savingsAcctNbr;
    }

    public void setSavingsAcctNbr(BigInteger savingsAcctNbr) {
        this.savingsAcctNbr = savingsAcctNbr;
    }

    public AcctHolder getAcctholderId() {
        return acctholderId;
    }

    public void setAcctholderId(AcctHolder acctholderId) {
        this.acctholderId = acctholderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CheckingAcct)) {
            return false;
        }
        CheckingAcct other = (CheckingAcct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "event.microservices.checking.acct.entity.CheckingAcct[ id=" + id + " ]";
    }
    
}
