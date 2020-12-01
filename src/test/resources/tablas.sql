CREATE TABLE public.Usuario (
	id int NOT NULL,
	nombre varchar(50) NOT NULL,
	email varchar(100) NOT NULL,
	tipo int NOT NULL,
	password varchar(70) NOT NULL,
	numCompras int NOT NULL,
	CONSTRAINT email UNIQUE (email),
	CONSTRAINT usuario_pk PRIMARY KEY (id)
);

CREATE TABLE public.Servicio (
   id int  NOT NULL,
   idUsuario int  NOT NULL,
   descripcion varchar(150)  NOT NULL,
   creationdate date  NOT NULL,
   CONSTRAINT Servicio_pk PRIMARY KEY (id,idUsuario)
);

create table public.palabra(
	id int not null,
	idServicio int not null,
	Palabra varchar(50) not null,
	constraint palabra_pk primary key (id)
);

DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Servicio;
DROP TABLE IF EXISTS Palabra;