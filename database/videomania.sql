USE Videomania;

CREATE TABLE Categoria (
    Categoria VARCHAR(50) PRIMARY KEY
);

CREATE TABLE Genero (
    Genero VARCHAR(50) PRIMARY KEY
);

CREATE TABLE Producto (
    Nombre_producto VARCHAR(100) PRIMARY KEY,
    Categoria VARCHAR(50),
    Genero VARCHAR(50),
    PEGI INT,
    Precio DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (Categoria) REFERENCES Categoria(Categoria),
    FOREIGN KEY (Genero) REFERENCES Genero(Genero)
);

CREATE TABLE Gestor (
    Nombre VARCHAR(50) PRIMARY KEY,
    Contrasena VARCHAR(50) NOT NULL
);

CREATE TABLE Cliente (
    Nombre VARCHAR(50) PRIMARY KEY,
    Contrasena VARCHAR(50) NOT NULL,
    Edad INT NOT NULL
);

CREATE TABLE Alquiler (
    ID_alquiler INT PRIMARY KEY IDENTITY(1,1),
    Nombre_cliente VARCHAR(50),
    Fecha_alquiler DATE NOT NULL,
    FOREIGN KEY (Nombre_cliente) REFERENCES Cliente(Nombre)
);

CREATE TABLE Multa (
    ID_multa INT PRIMARY KEY IDENTITY(1,1),
    ID_alquiler INT,
    FOREIGN KEY (ID_alquiler) REFERENCES Alquiler(ID_alquiler)
);

CREATE TABLE Unidad_Producto (
    ID_unidad_producto INT PRIMARY KEY IDENTITY(1,1),
    Nombre_producto VARCHAR(100),
    ID_alquiler INT,
    Estado VARCHAR(20) NOT NULL,
    FOREIGN KEY (Nombre_producto) REFERENCES Producto(Nombre_producto),
    FOREIGN KEY (ID_alquiler) REFERENCES Alquiler(ID_alquiler)
);

CREATE TABLE Devolucion (
    ID_devolucion INT PRIMARY KEY IDENTITY(1,1),
    ID_alquiler INT,
    Fecha_devolucion DATE NOT NULL,
    FOREIGN KEY (ID_alquiler) REFERENCES Alquiler(ID_alquiler)
);


