-- Generaciónd e la base de datos
CREATE DATABASE IF NOT EXISTS WebBiblioteca;
USE WebBiblioteca;

-- Generación de la tabla "Libros" para almacenar la información
CREATE TABLE IF NOT EXISTS Libro(
	id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(120) NOT NULL,
    publicacion DATE,
    autor VARCHAR(120),
    cantidad_disponible INT DEFAULT 3,
    precio_alquiler FLOAT,
    precio_compra FLOAT,
    genero VARCHAR(120),
    url_imagen VARCHAR(255)
    );
    
-- Generación de la tabla "Usuarios" 
CREATE TABLE IF NOT EXISTS Usuarios (
	id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE, -- Es útil para evitar repeticiones de correos electrónicos
    pass VARCHAR(240) NOT NULL
);
-- Generación de la tabla "Alquiler" para almacenar y consultar los alquileres de libros por parte de los usuarios
CREATE TABLE IF NOT EXISTS Alquiler (
	id_alquiler INT AUTO_INCREMENT PRIMARY KEY,
    precio_alquiler FLOAT NOT NULL,
    id_usuario INT,
    id_libro INT,
    fecha_alquiler DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
);
CREATE TABLE IF NOT EXISTS Compra (
	id_compra INT AUTO_INCREMENT PRIMARY KEY,
    precio_compra FLOAT NOT NULL,
	id_usuario INT,
    id_libro INT,
    fecha_compra DATE,
    FOREIGN KEY (id_usuario)  REFERENCES Usuarios(id_usuario),
    FOREIGN KEY (id_libro) REFERENCES Libro(id_libro)
);

-- Contenido total de libros de la WEB
INSERT INTO Libro (titulo, publicacion, autor, cantidad_disponible, precio_alquiler, precio_compra, genero, url_imagen)
VALUES
('Cien años de soledad', '1967-05-30', 'Gabriel García Márquez', 5, 2.99, 15.99, 'Realismo mágico', NULL),
('1984', '1949-06-08', 'George Orwell', 4, 2.50, 12.99, 'Distopía', NULL),
('Don Quijote de la Mancha', '1605-01-16', 'Miguel de Cervantes', 6, 3.00, 18.99, 'Clásico', NULL),
('El Hobbit', '1937-09-21', 'J.R.R. Tolkien', 3, 2.75, 14.99, 'Fantasía', NULL),
('Orgullo y prejuicio', '1813-01-28', 'Jane Austen', 4, 2.80, 13.50, 'Romance', NULL),
('Crimen y castigo', '1866-01-01', 'Fiódor Dostoyevski', 5, 3.10, 16.00, 'Novela psicológica', NULL),
('Ulises', '1922-02-02', 'James Joyce', 2, 3.50, 20.00, 'Modernismo', NULL),
('Madame Bovary', '1856-01-01', 'Gustave Flaubert', 3, 2.60, 14.00, 'Realismo', NULL),
('El retrato de Dorian Gray', '1890-07-01', 'Oscar Wilde', 4, 2.70, 13.99, 'Ficción gótica', NULL),
('La metamorfosis', '1915-10-01', 'Franz Kafka', 5, 2.40, 12.50, 'Existencialismo', NULL),
('El guardián entre el centeno', '1951-07-16', 'J.D. Salinger', 3, 2.90, 14.99, 'Ficción', NULL),
('Fahrenheit 451', '1953-10-19', 'Ray Bradbury', 4, 2.85, 13.75, 'Ciencia ficción', NULL),
('Matar a un ruiseñor', '1960-07-11', 'Harper Lee', 5, 3.00, 15.50, 'Drama', NULL),
('La Odisea', '800-01-01', 'Homero', 2, 3.20, 17.00, 'Épica', NULL),
('El señor de los anillos', '1954-07-29', 'J.R.R. Tolkien', 6, 3.50, 22.99, 'Fantasía épica', NULL),
('Un mundo feliz', '1932-01-01', 'Aldous Huxley', 4, 2.95, 14.25, 'Distopía', NULL),
('La casa de los espíritus', '1982-01-01', 'Isabel Allende', 5, 3.10, 16.50, 'Realismo mágico', NULL),
('Los miserables', '1862-01-01', 'Victor Hugo', 3, 3.25, 18.00, 'Histórica', NULL),
('Drácula', '1897-05-26', 'Bram Stoker', 4, 2.70, 13.99, 'Terror', NULL),
('Frankenstein', '1818-01-01', 'Mary Shelley', 5, 2.80, 14.50, 'Ciencia ficción', NULL),
('El Principito', '1943-04-06', 'Antoine de Saint-Exupéry', 6, 2.50, 12.00, 'Fábula', NULL),
('La Divina Comedia', '1320-01-01', 'Dante Alighieri', 2, 3.60, 19.99, 'Poesía épica', NULL),
('Hamlet', '1603-01-01', 'William Shakespeare', 3, 3.00, 15.00, 'Tragedia', NULL),
('La Iliada', '750-01-01', 'Homero', 2, 3.20, 17.00, 'Épica', NULL),
('El amor en los tiempos del cólera', '1985-01-01', 'Gabriel García Márquez', 4, 3.10, 16.50, 'Romance', NULL),
('Rayuela', '1963-01-01', 'Julio Cortázar', 3, 3.00, 15.99, 'Vanguardismo', NULL),
('Pedro Páramo', '1955-01-01', 'Juan Rulfo', 4, 2.70, 13.50, 'Realismo mágico', NULL),
('Ensayo sobre la ceguera', '1995-01-01', 'José Saramago', 5, 3.20, 17.00, 'Ficción filosófica', NULL),
('La sombra del viento', '2001-01-01', 'Carlos Ruiz Zafón', 6, 3.10, 16.99, 'Misterio', NULL),
('El nombre de la rosa', '1980-01-01', 'Umberto Eco', 4, 3.25, 18.50, 'Misterio histórico', NULL),
('El código Da Vinci', '2003-03-18', 'Dan Brown', 5, 3.00, 15.99, 'Thriller', NULL),
('Los pilares de la Tierra', '1989-01-01', 'Ken Follett', 4, 3.50, 19.99, 'Histórica', NULL),
('La ladrona de libros', '2005-01-01', 'Markus Zusak', 3, 2.90, 14.50, 'Drama', NULL),
('El alquimista', '1988-01-01', 'Paulo Coelho', 5, 2.80, 13.99, 'Ficción', NULL),
('Cometas en el cielo', '2003-01-01', 'Khaled Hosseini', 4, 3.00, 15.99, 'Drama', NULL);



  


 



