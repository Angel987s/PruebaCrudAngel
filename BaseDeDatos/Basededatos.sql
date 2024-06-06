Create database CrudAngel

go

create table Departamentos (
DepartamentoID int primary key identity(1,1),
Nombre varchar (100) not null,
Descripcion varchar (500)
);

go

Create table Empleados (
EmpleadoID INT Primary key identity (1,1),
Nombre varchar (100) not null,
Apellido varchar (100) not null,
Cargo varchar (100) not null,
Salario Decimal (10,2) not null,
DepartamentoID int not null,

Foreign key (DepartamentoID) references Departamentos(DepartamentoID)
);