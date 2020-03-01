*****Spring Boot Project*****

1. Spring Actuator -- Monitoring our app
   http://localhost:9000/actuator/health
   
   
2. MySQL Table Scripts : 

create table address (
	id INT NOT NULL AUTO_INCREMENT,
    home_id INT,
    street_name varchar(50),
    state varchar(25),
    city varchar(25),
    zip_code INT,
    PRIMARY KEY (id)
);

create table student (
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    address_id INT,
    primary key (id),student
    constraint FK_Address_id foreign key (address_id) references address(id)
);


create table course (
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(100) not null,
    student_id INT,
    primary key(id),
    constraint FK_Student_id foreign key (student_id) references student(id)
);

insert into address values(1,100,'Mylapore','Tamil Nadu','Chennai',600004);
insert into address values(2,101,'Boat Club Road','Maharastra','Pune',411001);
insert into address values(3,102,'Luz','Tamil Nadu','Chennai',600004);


insert into student values(1, 'Preethi Rajaraman' , 3);
insert into student values(2, 'Jayanthi Rajaraman' , 1);
insert into student values(3, 'Bala' , 2);

insert into course values(1, 'Spring Boot and Microservices' ,1);
insert into course values(2, 'Docker' ,1);
insert into course values(3, 'Machine Learning' ,3);