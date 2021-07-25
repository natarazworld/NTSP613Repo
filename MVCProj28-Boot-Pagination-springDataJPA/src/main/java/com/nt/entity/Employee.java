package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {
	@Id
	@GeneratedValue
	private  Integer empno;
	private String ename;
	private  String job;
	private  Float  sal;
	private Integer deptno;
}
