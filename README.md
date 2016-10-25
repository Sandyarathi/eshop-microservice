# eshop-microservice
Microservice Project

Project Report
E-Shop
-Micro-services architecture pattern based web app hosted on Cloud


Submitted By
Team 3(Individual)
Sandyarathi Das - 009994036
CMPE 282 (SPRING 2016)

Submitted to
Prof. Kong Li




Task to tackle:

To design and develop a cloud native application that is implemented using the Micro-services architecture pattern and leverages on features of Amazon Web Services and Docker container technology.

Functional Features:
An e-commerce platform where
•	Users can register with an email-id & password – implemented
•	Users receive a registration email - implemented
•	Users can login with the email-id & password - implemented
•	Users can view the products catalog on home page - implemented
•	Users can click on a particular product and view the product & inventory and review details – implemented
•	Users can place an order – implemented not integrated
•	Users can review products – not implemented not integrated

Solution Design:
Planned: To implement the micro-service architecture, each service module will be deployed on different Docker containers. Each of the micro-services will have their own database components and will interact with each other only via rest api calls. The web-tier will interact only with a gateway service. The gateway service will then integrate data from the individual micro services and respond to the client call.

Implemented: To implement the micro-service architecture, each service module is deployed on different Docker containers. The databases and messaging queues server are also deployed as Docker containers. I have also implemented an API gateway for the web-app to interact with backend application as a whole instead of having direct Client‑to‑Micro-service communication. All the micro-services, api- gateway and the web app are hosted on AWS EC2 instances.

Domain Understanding:
In contrast with a traditional monolithic application where the main thread communicates with a single system/engine, the micro-services approach scales out the engine across a distributed topology to increase availability. The trade-off here is that the business services are implemented in a way to balance performance by reduced consistency or eventual consistency. The key difference here by splitting the system into components is that, each component shares some portion of the information, but have their own distinct parts that they own. Such an application may have latency issues, but this could be addressed using Caching techniques. The microservices applications typically are a decomposition of a layered or a hexagonal architecture. Docker containers make it possible to have services multi-hosting on single cloud instances.

Existing works:
“Most large scale web sites including Netflix, Amazon and eBay have evolved from a monolithic architecture to a microservices architecture” quoted by you by Chris Richardson in Microservices.io


Project Architecture Diagram:




Database Tier: 
Hosted as Docker containers on AWS EC2 instances
• NoSQL 
•	Used Apache Cassandra for Customer data
•	Used MongoDB for Product & Inventory data

Middle Tier:
All services and messaging queues are hosted as Docker container on AWS
•	api-gateway-microservice: Spring boot Java application that receives requests from the Web-app and then initiates the necessary individual service rest calls and then aggregates data and sends a single response to the client. Hosted as Docker container on AWS. The gateway service acts as the entry point to the application.
•	customer-microservice: Spring boot Java application that exposes rest api’s, to the gateway service, to receive and respond to any customer related requests like
o	CREATE customer details
o	AUTHENTICATE customer login
o	SEND Email Task to messaging queue
This micro-service interacts with Cassandra database server to store and retrieve all customer related information. This microservice also sends email tasks to a RabbitMQ messaging queue server, upon successful customer registration.
•	email-microservice: Spring boot java application that acts as a Rabbit MQ message queue task listener and sends registration email to the customers registered email id.
o	RECEIVE Email Task from messaging queue
o	SEND EMAIL using Java messaging service(JMS)
•	product-microservice: Spring boot java application that exposes rest api’s to the gateway service to receive and respond to any request about product basic information like
o	GET basic product info
o	GET list of all products
o	CREATE product data
This microservice interacts with the Mongo database server to store and retrieve the product basic information.
•	Inventory-microservice: Spring boot java application that exposes rest api’s to the gateway and product microservice to receive and respond to any request about product inventory information like available stock.
o	GET available stock
o	CREATE inventory data

Web-Tier: Spring boot java application that invokes rest calls to the api gateway service and interprets the JSON response data and displays it on a Web browser using AJAX, jQuery, HTML & CSS.

Architecture design patterns:
•	Micro-services architecture pattern 
•	API Gateway pattern
•	Messaging and Remote Procedure Invocation patterns

Application design patterns:
♣	Decomposition – The application is divided to multiple app components(microservices) which enables the components to be scaled independently.
•	Workload – The application is expected to have different workloads and hence the individual components are deployed on multiple instances to balance the workload.
•	Data(State)
o	Customer Module -  2 Customer Docker containers access 1 Cassandra host container
♣	State-less (if only 1 instance is running)
♣	State-full (if more than 1 instance is running)
o	Products Module – All instances connect to an external mongo database hosted on mongoLab
♣	Processing component is state-less
♣	Data component is state-full
o	Inventory Module– All instances connect to an external mongo database hosted on mongoLab
♣	Processing component is state-less
♣	Data component is state-full
o	Gateway Module - Stateless
•	Data(Consistency) – The individual data components used are NoSQl database servers and thus inherently employ eventual consistency.
•	Communication — 
o	RabbitMQ is used for communication between customer and Email microservices – Asynchronous Communication
o	The rest of the modules interact via REST calls – Synchronous Communication
•	Scalability
o	All the instances are launched in auto-scaling groups deployed to more than 1 availability zone. Thus new instances are launched when the demand rises.
•	Availability
o	Environment based availability—All the instances are launched on Amazon AWS -EC2 instances which are highly available with 99.95% SLA.

Existing cloud services/features leveraged:
♣	Docker containers for hosting the individual service module
♣	Amazon Web Services- EC2 instances for deploying the Docker containers
♣	Auto-scaling scaling group
♣	Amazon CloudWatch - for monitoring various metrics of EC2 instances
♣	MongoLab for hosting the Mongo Database server

Technology Stack:

♣	Platform: Spring MVC, Docker, AWS EC2, Mongo Lab
♣	Technologies: Spring Boot, Apache Cassandra, RabbitMQ, MongoDB
♣	Frameworks: Spring MVC, REST, Maven build plugins
♣	Languages: Java, jQuery, JSP, AJAX, HTML, CSS, CQL

Design Trade-offs:

♣	Added development & deployment of a gateway service to avoid multiple api network calls from client and to handle diverse response formats.


Which component are in which containers:

EC2 instance name
Component
Container name
Customer EC2 instance
Customer Microservice
customer-microservice/customer

Email Microservice
email-microservice/email

RabbitMQ server
email-rabbit

Cassandra Server
dbCustomer
Product EC2 instance
Product Microservice
products-microservice/product
Inventory EC2 instance
Inventory Microservice
inventory-microservice/inventory
Gateway EC2 instance
Gateway Microservice
gateway-microservice/gateway


Screen shot of AWS-EC2 instances running:



Screen shot of the auto-scaling group deployed in multiple availability zones:

Screen shot of instances running in auto-scaling group:


Screen shot of MongoDB instance on cloud hosted mongoLab:




Docker container screen shots:
1.	Customer instance


2.	Product instance




3.	Inventory instance


4.	Gateway instance



5.	Web app instance
4e86f7169d89


UI Screen shots:

Welcome page:					Customer Registration:

 









Customer login:				Products catalog page




Product details page




Test Plan Execution:
Sl.no.
Test case description
Test Result
Status
1.
Registration for new customer
Customer record is created
PASS
2.
Registration email for new customer
Registration email is sent
PASS
3.
Registered customer login - Positive
Customer is successfully logged in
PASS
4.
Registered customer login - Negative
Customer re-login message is displayed
PASS
5.
View Products catalog
Post registration or login the home page displays all the available products
PASS
6.
View Product info
Customer clicks on a product link and is directed to product details page
PASS


Any major modifications from Proposal and Why
In the project proposal, my project use case was of post sharing cloud native application. I have implemented the e-shop use case so that there is no code overlap with my other team members. This project is completely an individual project from idea to deployment. The base idea of building a micro-serviced application is the same.

Any uniqueness(design/implementation) you are proud of
The architecture design is something I am very proud of. It is a very new and upcoming concept.
Also the implementation of a gateway-microservice for service routing.


Future-work & Improvements:
♣	Integrate Order Service and Review Service API
♣	Make use of an API gateway service provided by AWS for automatic routing
♣	Make use of AWS Elastic Container Service to manage and deploy all the service containers
♣	Implement service discovery
♣	Develop an automated deployment workflow using Dev-Ops methodologies like Jenkins, Docker Hub, Travis
♣	Attach load-balancers to the auto-scaling groups


References:
♣	http://martinfowler.com/articles/microservices.html
♣	http://martinfowler.com/microservices/
♣	http://microservices.io/




