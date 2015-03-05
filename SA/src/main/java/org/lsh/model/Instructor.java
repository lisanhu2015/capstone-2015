package org.lsh.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lsh on 15/3/3.
 */
@Entity
public class Instructor {
    private String instructorId;
    private String userId;

    @Id
    @Column(name = "instructor_id", nullable = false, insertable = true, updatable = true, length = 45)
    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Instructor that = (Instructor) object;

        if (instructorId != null ? !instructorId.equals(that.instructorId) : that.instructorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return instructorId != null ? instructorId.hashCode() : 0;
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
