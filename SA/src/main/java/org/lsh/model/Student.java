package org.lsh.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by lsh on 15/3/3.
 */
@Entity
public class Student {
    private String studentId;
    private String userId;

    @Id
    @Column(name = "student_id", nullable = false, insertable = true, updatable = true, length = 45)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Student student = (Student) object;

        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return studentId != null ? studentId.hashCode() : 0;
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
