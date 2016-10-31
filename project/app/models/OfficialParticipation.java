/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author palma
 */
@Entity
@Table(name = "official_participation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfficialParticipation.findAll", query = "SELECT o FROM OfficialParticipation o"),
    @NamedQuery(name = "OfficialParticipation.findById", query = "SELECT o FROM OfficialParticipation o WHERE o.id = :id"),
    @NamedQuery(name = "OfficialParticipation.findByVotes", query = "SELECT o FROM OfficialParticipation o WHERE o.votes = :votes")})
public class OfficialParticipation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "votes")
    private int votes;
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne
    private Candidate candidateId;

    public OfficialParticipation() {
    }

    public OfficialParticipation(Integer id) {
        this.id = id;
    }

    public OfficialParticipation(Integer id, int votes) {
        this.id = id;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Candidate candidateId) {
        this.candidateId = candidateId;
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
        if (!(object instanceof OfficialParticipation)) {
            return false;
        }
        OfficialParticipation other = (OfficialParticipation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.OfficialParticipation[ id=" + id + " ]";
    }
    
}
