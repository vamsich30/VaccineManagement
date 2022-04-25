package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AdminDB")
@Getter
@Setter
public class AdminEntity {
	
	@Id
	@Column(name="admin_name")
	private String adminName;
	@Column(name="admin_password")
	private String adminPassword;
}
