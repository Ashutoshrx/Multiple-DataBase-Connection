package com.jarvis.mds.entity.products;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Table(name = "product")
@Entity
public class Product {
  @Id
  private Integer id;
  @Column(name = "product_name", nullable = false)
  private String productName;
  @Column(name = "price", precision = 11, nullable = false)
  private BigDecimal price;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
