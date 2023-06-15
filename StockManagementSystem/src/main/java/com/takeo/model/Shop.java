package com.takeo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHOP")
public class Shop {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

private String ownerName;
private long shopNo;
private String shopType;
private String address;
private String country;
	
	
}
