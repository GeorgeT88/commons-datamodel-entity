
package com.boot.services.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
	@JoinTable(name = "list_of_products_in_cart", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
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
