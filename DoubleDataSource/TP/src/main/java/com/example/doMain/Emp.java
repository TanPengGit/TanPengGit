package com.example.doMain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp") 
public class Emp {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)//主键生成策略
    private Long id;
	
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private int deptno;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {	
		this.name = name;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

    
    
}
