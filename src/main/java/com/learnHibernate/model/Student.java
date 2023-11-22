package com.learnHibernate.model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.UniqueConstraint;
import jakarta.transaction.Transactional;

@Entity
@TableGenerator(name = "student_tbl_generator",
        allocationSize = 1,
        table = "student_tbl",
        pkColumnName = "id",
        uniqueConstraints = {@UniqueConstraint(name = "id", columnNames = "id")})
@PersistenceUnit(unitName = "student-pu")
@Cacheable(value = false)
@Transactional(value = Transactional.TxType.REQUIRED)
public class Student {

    @Id
    @GeneratedValue(generator = "student_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_sequence", allocationSize = 1,initialValue = 1, sequenceName = "student_sequence")
    private Long id;
    private String name;
    private String email;

    public Student() {
    }

    public Student(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
