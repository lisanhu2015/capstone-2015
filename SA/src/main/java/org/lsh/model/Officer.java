package org.lsh.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lsh on 15/3/3.
 */
@Entity
public class Officer {
    private String officerId;
    private String userId;

    @Id
    @Column(name = "officer_id", nullable = false, insertable = true, updatable = true, length = 45)
    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Officer officer = (Officer) object;

        if (officerId != null ? !officerId.equals(officer.officerId) : officer.officerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return officerId != null ? officerId.hashCode() : 0;
    }

    @Basic
    @Column(name = "user_id", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
