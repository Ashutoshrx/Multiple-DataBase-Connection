# Connection of Multiple databases from a single Microservice.

In this example, I have used two databases 'mds' and 'mda' for connection into a single microsevice.
Mda handles the transactions for the Order table and Mds handles transactions with the Product table.

# Takeaways From the Project

## To connect multiple databases, we need the following things to remember-
  1. Custom configuration properties for each database need to be created.
  2. Create a custom DataSourceProperty bean and inject the URL, username, and password.
  3. Create a custom DataSource bean and inject the above DataSourceProperty bean to help communication with the database.
  4. Once both the DataSource beans are created for each database communication, you can communicate to the database by annotating any of the DataSource beans as "@Primary".
  5. Make sure, that your requirement says that all the entities should belong to one database, then follow **Step 4**.
  6. If not, make sure package that DB-1's entities are in one package and DB-2's entities are in another, same goes for the respective repositories.

     (For example- In this project, all the entities that belong to the mds database, are there in "com.jarvis.mds.entity.orders"
     
     and all the entities that belong to the mda database, are there in the "com.jarvis.mds.entity.products" packages,

     The same goes for the repositories as well, Mds- "com.jarvis.mds.repository.orders" & mda-"com.jarvis.mds.repository.products")
  8. Once the packaging is done, we have to create two EntityManagerFactory for each database communication.
  9. Once custom EntityManagerFactory classes are created for respective database communication, we have to create custom TransactionManager - the reason we create this if any
      transaction breaks, then the entire transaction should fail, this helps data consistency like all changes are made within a single transaction.
  10. Make sure to annotate the EntityManagerFactory classes as **@EnableJpaRepositories**, or else it will fail to create a bean for the Repository layer.

# Source
 1. https://docs.spring.io/spring-boot/docs/1.1.0.M1/reference/html/howto-database-initialization.html
 2. https://youtu.be/z65J3JPbs9A?si=Xe5tZuDcVLHSMu1g
