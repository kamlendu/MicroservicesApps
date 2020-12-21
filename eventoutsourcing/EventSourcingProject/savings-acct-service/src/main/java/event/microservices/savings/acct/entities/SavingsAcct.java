/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.savings.acct.entities;

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
@Table(name = "SAVINGS_ACCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SavingsAcct.findAll", query = "SELECT s FROM SavingsAcct s"),
    @NamedQuery(name = "SavingsAcct.findById", query = "SELECT s FROM SavingsAcct s WHERE s.id = :id"),
    @NamedQuery(name = "SavingsAcct.findByAcctNbr", query = "SELECT s FROM SavingsAcct s WHERE s.acctNbr = :acctNbr"),
    @NamedQuery(name = "SavingsAcct.findByAcctBalance", query = "SELECT s FROM SavingsAcct s WHERE s.acctBalance = :acctBalance"),
    @NamedQuery(name = "SavingsAcct.findByCheckingAcctNbr", query = "SELECT s FROM SavingsAcct s WHERE s.checkingAcctNbr = :checkingAcctNbr")})
public class SavingsAcct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "ACCT_NBR")
    private BigInteger acctNbr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ACCT_BALANCE")
    private Double acctBalance;
    @Column(name = "CHECKING_ACCT_NBR")
    private BigInteger checkingAcctNbr;
    @JoinColumn(name = "ACCTHOLDER_ID", referencedColumnName = "id")
    @ManyToOne
    private AcctHolder acctholderId;

    public SavingsAcct() {
    }

    public SavingsAcct(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getAcctNbr() {
        return acctNbr;
    }

    public void setAcctNbr(BigInteger acctNbr) {
        this.acctNbr = acctNbr;
    }

    public Double getAcctBalance() {
        return acctBalance;
    }

    public void setAcctBalance(Double acctBalance) {
        this.acctBalance = acctBalance;
    }

    public BigInteger getCheckingAcctNbr() {
        return checkingAcctNbr;
    }

    public void setCheckingAcctNbr(BigInteger checkingAcctNbr) {
        this.checkingAcctNbr = checkingAcctNbr;
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
        if (!(object instanceof SavingsAcct)) {
            return false;
        }
        SavingsAcct other = (SavingsAcct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "event.microservices.savings.acct.entities.SavingsAcct[ id=" + id + " ]";
    }
    
}
