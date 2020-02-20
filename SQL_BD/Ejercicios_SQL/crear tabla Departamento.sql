DROP TABLE IF EXISTS Departamento CASCADE;
CREATE TABLE Departamento (
codDepto varchar (4) PRIMARY KEY,
nombreDpto varchar (20) NOT NULL,
ciudad varchar (15),
codDirector varchar (12)
);
