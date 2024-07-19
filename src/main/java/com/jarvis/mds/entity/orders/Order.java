package com.jarvis.mds.entity.orders;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cus_order")
public class Order {
  @Id
  @Column(name = "order_id")
  private Integer orderId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
}
