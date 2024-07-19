package com.jarvis.mds;

import com.jarvis.mds.dto.Student;
import com.jarvis.mds.entity.orders.Order;
import com.jarvis.mds.entity.products.Product;
import com.jarvis.mds.repository.orders.OrderRepository;
import com.jarvis.mds.repository.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class SpringBootMdsApplication implements CommandLineRunner {
  @Autowired
  private Student student;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrderRepository orderRepository;

  @Value("#{'${names}'.split(',')}")
  private List<String> names;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMdsApplication.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println(student);
    System.out.println(names);
    System.out.println("=====Started saving Order=======");
    Order order = new Order(101, "Ashutosh", "Satapathy");
    orderRepository.save(order);
    System.out.println("=====Successfully saved Order=======");

    Product product = new Product();
    product.setId(2);
    product.setProductName("Cow Milk");
    product.setPrice(new BigDecimal("5.5"));
    productRepository.save(product);
    System.out.println("=====Successfully saved Product=======");

  }
}
