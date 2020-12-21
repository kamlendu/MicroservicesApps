/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.checking.acct.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ACCT_HOLDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcctHolder.findAll", query = "SELECT a FROM AcctHolder a"),
    @NamedQuery(name = "AcctHolder.findById", query = "SELECT a FROM AcctHolder a WHERE a.id = :id"),
    @NamedQuery(name = "AcctHolder.findByFirstName", query = "SELECT a FROM AcctHolder a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "AcctHolder.findByLastName", query = "SELECT a FROM AcctHolder a WHERE a.lastName = :lastName")})
public class AcctHolder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 1000)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 1000)
    @Column(name = "LAST_NAME")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acctholderId")
    private Collection<CheckingAcct> checkingAcctCollection;

    public AcctHolder() {
    }

    public AcctHolder(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<CheckingAcct> getCheckingAcctCollection() {
        return checkingAcctCollection;
    }

    public void setCheckingAcctCollection(Collection<CheckingAcct> checkingAcctCollection) {
        this.checkingAcctCollection = checkingAcctCollection;
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
        if (!(object instanceof AcctHolder)) {
            return false;
        }
        AcctHolder other = (AcctHolder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "event.microservices.checking.acct.entity.AcctHolder[ id=" + id + " ]";
    }
    
}
