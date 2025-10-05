### Install MySQL Database server
	https://dev.mysql.com/downloads/mysql

### Install MySQL Workbench
	https://dev.mysql.com/downloads/workbench

### Automatic Data Source configuration
	- In Spring Boot Hibernate is the default implementation of JPA.
	- EntityManager is the main component for creating queries etc.
	- EntityManager is from JPA
	- Based on config, spring boot will automatically create the beans Datasource, EntityManager etc.

### JPA Entity Manager
	- Our JPA EntityManager needs data source, The Data source defines database connection info
	- JPA EntityManager and data source are automatically created by spring boot, based on the file application.properties
	- We can autowire or inject the JPA EntityManager into our DAO classes
	
	-  What about JpaRepository ?
	
	 - Spring Data JPA has a JpaRepository interface
	 - This provides JPA database access with minimal coding
	 - Why we are using EntityManager instead of JpaRepository ?
	 - Knowing both EntityManager and JpaRepository will be helpful, If you need low level control and flexibility use 		EntityManager,If you want high level abstraction use JpaRepository.