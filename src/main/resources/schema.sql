CREATE TABLE Emploee (
      id varchar(36) NOT NULL,
      user_ident int not null,
      full_name varchar(150),
      department int,
      salary int,
      CONSTRAINT emploees_PK PRIMARY KEY (id)
);