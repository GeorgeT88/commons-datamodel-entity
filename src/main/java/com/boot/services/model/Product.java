package com.boot.services.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.boot.services.enums.ProductStatus;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5714267227877816930L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	@Size(min = 3, max = 30)
	private String productName;

	@Column
	@Size(min = 3, max = 600)
	private String productDescription;

	@Column
	private long productPrice;

	@Column
	private String productPhotoLink;

	@Column
	@Size(min = 3, max = 30)
	private String productCategory;

	@Column
	private int productStock;

	@Enumerated(EnumType.STRING)
	@Column
	private ProductStatus status;

}