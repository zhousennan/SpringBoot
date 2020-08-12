package com.zsn.pojo;


import org.springframework.transaction.annotation.Transactional;
import sun.awt.SunHints;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "d_Dep")
public class Dep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int depId;
    @Column(name = "dep_name")
    private String Depname;
    @OneToMany(mappedBy = "dep",cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<Emp> emp;
}
