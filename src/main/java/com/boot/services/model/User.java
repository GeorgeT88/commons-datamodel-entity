package com.boot.services.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -2904101271253876784L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String password;

	@Column
	private String phoneNumber;

	@Size(min = 3, max = 25)
	@Column(unique = true)
	private String email;

	@Column
	private String deliveryAddress;

	@Column
	private LocalDate createdOn;

	@Column
	private LocalDate lastUpdatedOn;
	
	@Column
	private String role;

	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.PERSIST })
	@JoinTable(name = "favorite_product_list", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> favoriteProductList;
	
	@Column
	private boolean isActivated;

}