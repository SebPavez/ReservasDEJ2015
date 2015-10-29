Create table cliente(rut varchar(20) primary key, nombre varchar (45) not null, direccion varchar (20) not null, telefono varchar (10) not null);

Create table reserva(codreserva int  primary key, fecha_inicio date not null, fecha_entrega date not null, litros_bencina int not null, cliente_rut varchar(20), foreign key(cliente_rut) references cliente(rut));

Create table automovil(patente varchar(8)  primary key, marca varchar (20) not null, modelo varchar (20) not null, color varchar (10) not null, num_estacionamiento int);

Create table reserva_automovil(reserva_codreserva int , automovil_patente varchar(8),  foreign key(reserva_codreserva) references reserva(codreserva), foreign key(automovil_patente) references automovil(patente), precio_automovil int);


Insert into cliente values ('10643821-6','Juan Lopez','Los paltos 123','6331220'); 
Insert into cliente values ('12493155-8','Marco Rojas','alerces 456','4182820' );
Insert into cliente values ('14643121-6','Ana Vera','Las acacias 88','3124020' );

Insert into automovil values('AN-5678','Nissan','Sentra', 'Blanco',25);
Insert into automovil values('BP-1612','Chevrolet','Corsa', 'Azul',34);
Insert into automovil values('PS-5678','Toyota','Yaris', 'rojo',15);
Insert into automovil values('AS-7044','Nissan','Primera', 'azul',14);

Insert into reserva values(2030,'2012-03-10','2012-03-15',15,'12493155-8');
Insert into reserva values(4050,'2012-03-15','2012-03-20',10,'14643121-6');
Insert into reserva values(8020,'2012-03-18','2012-03-25',12,'10643821-6');

Insert into reserva_automovil values(2030,'BP-1612',25000);
Insert into reserva_automovil values (4050,'AN-5678',27000);
Insert into reserva_automovil values(2030,'AS-7044', 23000);
Insert into reserva_automovil values (8020,'PS-5678', 19000);
