--CREATE DATABASE db_comercial_heredia;

/*
DROP TABLE IF EXISTS test;
CREATE TABLE test(
	id serial primary key,
	name text not null,
	monto float default 0 check (monto >= 0.00) not null
);
insert into test (name, monto) values('alf', 0.0);
select * from test;
*/


CREATE TABLE tipo_personal(
	id serial primary key, -- int
	descripcion varchar(30)
);


CREATE TABLE personal(
	ci varchar(12) primary key,
	nombre_completo varchar(150) not null,
	genero char(1) not null,
	direccion varchar(150),
	telefono int,
	id_tipo_personal int,
	
	foreign key (id_tipo_personal) 
	references tipo_personal(id)
);

CREATE TABLE usuario(
	id serial primary key,
	nombre_usuario varchar(30),
	contrasena varchar(30),
	estado boolean default true,
	fecha_creacion timestamp default now(),
	ci_personal varchar(12), 
	
	foreign key (ci_personal)
	references personal(ci)
);

CREATE TABLE proveedor(
	id serial primary key,
	nombre varchar(30) not null,
	direccion varchar(30),
	telefono varchar(12)
);

CREATE TABLE compra(
	id serial primary key,
	total float default 0.00,
	fecha_hora timestamp default now(),
	id_proveedor int,
	id_personal varchar(12),
	foreign key (id_proveedor)
	references proveedor (id),
	foreign key (id_personal)
	references personal (ci)
);

CREATE TABLE producto(
	id serial primary key,
	nombre varchar(30),
	stock int default 0,
	precio float default 0.00
);

CREATE TABLE detalle_compra(
	id_compra int,
	id_producto int,
	precio_unid float,
	cantidad int,
	primary key (id_compra, id_producto),

	foreign key (id_compra)
	references compra (id),

	foreign key (id_producto)
	references producto (id)
);

CREATE TABLE cliente(
	ci varchar(12) primary key,
	nombre_completo varchar(30) not null,
	fecha_nac date not null,
	genero char(1) check (genero='M' or genero='F'),
	direccion varchar(30)
);

CREATE TABLE venta(
	id serial primary key,
	total float default 0.00,
	fecha date default now(),
	hora time default now(),
	ci_cliente varchar(12),
	ci_personal varchar(12),
	foreign key (ci_cliente)
	references cliente (ci),
	foreign key (ci_personal)
	references personal (ci)
);

CREATE TABLE detalle_venta(
	id_venta int,
	id_producto int,
	precio_unid float,
	cantidad int,
	primary key (id_venta, id_producto),
	foreign key (id_venta)
	references venta (id),
	foreign key (id_producto)
	references producto (id)
);

