/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author palma
 */
@Entity
@Table(name = "election")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Election.findAll", query = "SELECT e FROM Election e"),
    @NamedQuery(name = "Election.findById", query = "SELECT e FROM Election e WHERE e.id = :id"),
    @NamedQuery(name = "Election.findByName", query = "SELECT e FROM Election e WHERE e.name = :name"),
    @NamedQuery(name = "Election.findByDescription", query = "SELECT e FROM Election e WHERE e.description = :description"),
    @NamedQuery(name = "Election.findByAssignedDate", query = "SELECT e FROM Election e WHERE e.assignedDate = :assignedDate")})
public class Election implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assigned_date")
    @Temporal(TemporalType.DATE)
    private Date assignedDate;
    @JoinColumn(name = "electiontype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ElectionType electiontypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "electionId")
    private List<ElectionLog> electionLogList;

    public Election() {
    }

    public Election(Integer id) {
        this.id = id;
    }

    public Election(Integer id, String name, String description, Date assignedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignedDate = assignedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public ElectionType getElectiontypeId() {
        return electiontypeId;
    }

    public void setElectiontypeId(ElectionType electiontypeId) {
        this.electiontypeId = electiontypeId;
    }

    @XmlTransient
    public List<ElectionLog> getElectionLogList() {
        return electionLogList;
    }

    public void setElectionLogList(List<ElectionLog> electionLogList) {
        this.electionLogList = electionLogList;
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
        if (!(object instanceof Election)) {
            return false;
        }
        Election other = (Election) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Election[ id=" + id + " ]";
    }
    
}
