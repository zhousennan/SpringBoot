package com.zsn.modules.test.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "d_Emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int EmpId;

    @Column(name = "emp_name")
    private String EmpName;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id",insertable = false,updatable = false)
    @JsonIgnore
    private Dep dep;

}
