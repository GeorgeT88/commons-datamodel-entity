package com.boot.services.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String addressLine1;

	@Column
	private String addressLine2;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private long zipPostalCode;

	@Column
	private String country;

	@Column
	private String nameOnCard;

	@Column
	private long cardNumber;

	@Column
	private LocalDateTime expiryDate;

	@Column
	private int cvv;
	
	@Column(unique = true)
	private UUID uuid;
	
	@Column
	private OrderStatus status;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
	@JoinTable(name = "list_of_orders", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Product> productList;
	
	@Column
	private double total;

	@Column
	private LocalDateTime lastUpdatedOn;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@PreUpdate
	protected void lastUpdatedOnPreUpdate() {
		this.lastUpdatedOn =  LocalDateTime.now();
	}
}