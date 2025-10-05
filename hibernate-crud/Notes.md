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
	 
### Query Objects with JPA

	- JPA has a JPA Query Language (JPQL)
	- It is query language for retrieving objects. similar in concept to SQL with where, like, order by, join, in etc.
	- However JPQL is based on entity name and entity fields
	- e.g. Retrieving all the students using JPQL
	
	  TypedQuery<Student> theQuery=entityManager.createQuery("from Student", Student.class);
	  List<Student> students=theQuery.getResultList();
	  
	  Here, "from Student" - Student is not database name
	  All JPQL syntax are based on entity name and entity fields
	  
	- e.g. Retrieving Students with lastName="shinde"
	
	  TypedQuery<Student> theQuery=entityManager.createQuery("from Student where lastName='shinde'",Student.class);
	  List<Student> students = theQuery.getResultList();
	  
### JPQL Named parameters

	- In our previous queries we were hard coding parameters e.g. lastName='shinde'
	- In Most of the cases we will have to read search string from form and have to use it in query
	- e.g. 
	  public List<Student> findByLastName(String theLastName){
		  TypedQuery<Student> theQuery=entityManager.createQuery("from Student where lastName=:theData",Student.class);
		  theQuery.setParameter("theData",theLastName);
		  return theQuery.getResultList();
	  }
	  
	- Here JPQL named parameters are prefixed with colon

### Updating Single Object

	- for updating object we will have to find the Object
	
		Student theStudent=entityManager.find(Student.class,Integer id);
		
	- Then call setter method to update entity
	
		theStudent.setFirstName("XYZ");
		
	- Then Update entity in DB using merge
	
		entityManager.merge(theStudent);
		

### Deleting an Object

	- for updating object we will have to find the Object
	
		Student theStudent=entityManager.find(Student.class,Integer id);
		
	- Then delete
		
		entityManager.remove(theStudent)
		
### Deleting Objects based on condition

	   int numOfRowsUpdated = entityManager.createQuery("DELETE FROM Student WHERE lastName='Patil'").executeUpdate();
	   
### Deleting All Students

	   int numOfRowsUpdated = entityManager.createQuery("DELETE FROM Student").executeUpdate();
	   
### Creating Database tables with Java Code

	- JPA/Hibernate provides an option to automatically create database tables
	- Creates tables based  on Java code with JPA/ Hibernate annotations
	- It is not recommended to use auto generation for enterprise, real time projects
	- Configuration
	
		- application.properties file
		
		   spring.jpa.hibernate.ddl-auto=create
		
		- With this property when you run your application JPA/Hibernate will drop tables then create them
		
		create-drop : if we set property value create-drop DB tables dropped followed by database table creation. On Application 						 						 shutdown  drop DB tables
		validate : validate the database table schema
		Update : Update the database tables schema. If we want to create table once and then keep data use update
		
		
	