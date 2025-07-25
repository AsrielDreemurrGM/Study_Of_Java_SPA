package br.com.eaugusto.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity representing an accessory that can be associated with cars.
 * 
 * <p>
 * Each Accessory has a unique code, a name, a price, and stock quantity. It
 * maintains a bidirectional many-to-many relationship with {@link Car}.
 * </p>
 * 
 * @author Eduardo Augusto (github.com/AsrielDreemurrGM/)
 * @since July 19, 2025
 */
@Entity
@Table(name = "tb_accessory")
public class Accessory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accessory_seq")
	@SequenceGenerator(name = "accessory_seq", sequenceName = "sq_accessory", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "code", length = 10, nullable = false, unique = true)
	private String code;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "price", nullable = false)
	private Double price;

	@Column(name = "stock_quantity", nullable = false)
	private Integer stockQuantity;

	@ManyToMany(mappedBy = "accessories")
	private List<Car> cars;

	public Accessory() {
		this.cars = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
