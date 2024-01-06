/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vidhi
 */
@Entity
@Table(name = "groupmaster")
@NamedQueries({
    @NamedQuery(name = "Groupmaster.findAll", query = "SELECT g FROM Groupmaster g"),
    @NamedQuery(name = "Groupmaster.findByGroupId", query = "SELECT g FROM Groupmaster g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groupmaster.findByGroupName", query = "SELECT g FROM Groupmaster g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "Groupmaster.findByCreatedAt", query = "SELECT g FROM Groupmaster g WHERE g.createdAt = :createdAt"),
    @NamedQuery(name = "Groupmaster.findByUpdatedAt", query = "SELECT g FROM Groupmaster g WHERE g.updatedAt = :updatedAt")})
public class Groupmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "groupId")
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "groupName")
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<Usermaster> usermasterCollection;

    public Groupmaster() {
    }

    public Groupmaster(Integer groupId) {
        this.groupId = groupId;
    }

    public Groupmaster(Integer groupId, String groupName, Date createdAt) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.createdAt = createdAt;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Collection<Usermaster> getUsermasterCollection() {
        return usermasterCollection;
    }

    public void setUsermasterCollection(Collection<Usermaster> usermasterCollection) {
        this.usermasterCollection = usermasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupmaster)) {
            return false;
        }
        Groupmaster other = (Groupmaster) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Groupmaster[ groupId=" + groupId + " ]";
    }
    
}
