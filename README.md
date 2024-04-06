# Technology Stack:

## Java, Maven, Spring Boot, Hibernate: 
* I chose Java as the programming language due to its robustness and widespread usage. Spring Boot simplifies the setup of Spring-based applications, while Hibernate facilitates object-relational mapping (ORM) for  streamlining database interactions and Spring Security with JWT authentication and authorization mechanisms.

## Entities:
 * Users:
   > Represents the users of shopping application.
* Products:
   > Represents the products available for purchase.
 * Orders:
   > Represents the orders placed by users, containing details such as the products ordered, quantity, total amount, and any applied discounts.

## Discounts:
 * I have implemented discount functionality using constants like "Off5" and "Off10".
 * Users can select these discounts during the order placement process, allowing them to avail of special offers and promotions.

## MySQL Database:
* Used MySQL as the database to store user information, product details, and order information.
* The database schema includes tables for users, products, and orders, with appropriate relationships established between them.

## Relationship Mapping:

 * I've established one-to-many relationships between users and products, indicating that a user can have multiple products associated with them.
 * Additionally, I've used many-to-many relationships between orders and products, allowing multiple products to be included in a single order and a product to be part of multiple orders.

## Functionality:

 * Users can register and login to the application to place orders.
 * They can browse the available products, view product details, and add products to their cart.
 * During the checkout process, users can specify the quantity of each product they want to purchase and apply discounts if applicable.
 * Once the order is placed, it is stored in the database, and users can view their order history.

## Scalability and SOLID Principles:

* SOLID Principles:
> Adhered to SOLID principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion) to design a modular, maintainable, and extensible system. Ensured scalability and future enhancements by following best practices in system design and architecture.


## CRUD Operations:
* Implemented CRUD (Create, Read, Update, Delete) operations for managing users, their orders and users transactions effectively. Ensured seamless handling of user and order for products data manipulation for enhanced user experience.


## Testing and Validation:
* Utilized Postman for comprehensive testing and validation of REST endpoints. Conducted functional testing to ensure correct behavior and adherence to specified requirements, enhancing system reliability.

