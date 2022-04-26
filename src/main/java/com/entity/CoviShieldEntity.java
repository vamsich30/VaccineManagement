package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "covishield")
@Getter
@Setter
public class CoviShieldEntity {
	@Id
	@Column(name = "vaccinelocation", columnDefinition = "VARCHAR(64)")
	private String location;

	@Column(name = "vaccinecount")
	private int vaccineCount;

}
