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
    precio_alquiler DECIMAL(6,2),
    precio_compra DECIMAL(6,2),
    genero VARCHAR(120),
    url_imagen VARCHAR(255),
	oferta BOOLEAN DEFAULT FALSE,
    descuento INT DEFAULT 0,
    bestseller BOOLEAN DEFAULT FALSE
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

-- Contenido total de libros de la WEB sin oferta
INSERT INTO Libro (titulo, publicacion, autor, cantidad_disponible, precio_alquiler, precio_compra, genero, url_imagen)
VALUES
('Cien años de soledad', '1967-05-30', 'Gabriel García Márquez', 5, 2.99, 15.99, 'Realismo mágico', 'img/libros/cien_anos_de_soledad.jpg'),
('1984', '1949-06-08', 'George Orwell', 4, 2.50, 12.99, 'Distopía', 'img/libros/1984.jpg'),
('El Hobbit', '1937-09-21', 'J.R.R. Tolkien', 3, 2.75, 14.99, 'Fantasía', 'img/libros/el_hobbit.jpg'),
('Orgullo y prejuicio', '1813-01-28', 'Jane Austen', 4, 2.80, 13.50, 'Romance', 'img/libros/orgullo_y_prejuicio.jpg'),
('Crimen y castigo', '1866-01-01', 'Fiódor Dostoyevski', 5, 3.10, 16.00, 'Novela psicológica', 'img/libros/crimen_y_castigo.jpg'),
('El retrato de Dorian Gray', '1890-07-01', 'Oscar Wilde', 4, 2.70, 13.99, 'Ficción gótica', 'img/libros/dorian_gray.jpg'),
('La metamorfosis', '1915-10-01', 'Franz Kafka', 5, 2.40, 12.50, 'Existencialismo', 'img/libros/la_metamorfosis.jpg'),
('Fahrenheit 451', '1953-10-19', 'Ray Bradbury', 4, 2.85, 13.75, 'Ciencia ficción', 'img/libros/fahrenheit_451.jpg'),
('Matar a un ruiseñor', '1960-07-11', 'Harper Lee', 5, 3.00, 15.50, 'Drama', 'img/libros/matar_a_un_ruiseñor.jpg'),
('La Odisea', '800-01-01', 'Homero', 2, 3.20, 17.00, 'Épica', 'img/libros/la_odisea.jpg'),
('El señor de los anillos', '1954-07-29', 'J.R.R. Tolkien', 6, 3.50, 22.99, 'Fantasía épica', 'img/libros/senor_de_los_anillos.jpg'),
('Un mundo feliz', '1932-01-01', 'Aldous Huxley', 4, 2.95, 14.25, 'Distopía', 'img/libros/un_mundo_feliz.jpg'),
('La casa de los espíritus', '1982-01-01', 'Isabel Allende', 5, 3.10, 16.50, 'Realismo mágico', 'img/libros/casa_de_los_espiritus.jpg'),
('Frankenstein', '1818-01-01', 'Mary Shelley', 5, 2.80, 14.50, 'Ciencia ficción', 'img/libros/frankenstein.jpg'),
('El Principito', '1943-04-06', 'Antoine de Saint-Exupéry', 6, 2.50, 12.00, 'Fábula', 'img/libros/el_principito.jpg'),
('La Divina Comedia', '1320-01-01', 'Dante Alighieri', 2, 3.60, 19.99, 'Poesía épica', 'img/libros/divina_comedia.jpg'),
('La Iliada', '750-01-01', 'Homero', 2, 3.20, 17.00, 'Épica', 'img/libros/la_iliada.jpg'),
('El amor en los tiempos del cólera', '1985-01-01', 'Gabriel García Márquez', 4, 3.10, 16.50, 'Romance', 'img/libros/amor_en_los_tiempos_del_colera.jpg'),
('Ensayo sobre la ceguera', '1995-01-01', 'José Saramago', 5, 3.20, 17.00, 'Ficción filosófica', 'img/libros/ensayo_sobre_la_ceguera.jpg'),
('La sombra del viento', '2001-01-01', 'Carlos Ruiz Zafón', 6, 3.10, 16.99, 'Misterio', 'img/libros/sombra_del_viento.jpg'),
('El código Da Vinci', '2003-03-18', 'Dan Brown', 5, 3.00, 15.99, 'Thriller', 'img/libros/codigo_da_vinci.jpg'),
('Los pilares de la Tierra', '1989-01-01', 'Ken Follett', 4, 3.50, 19.99, 'Histórica', 'img/libros/pilares_de_la_tierra.jpg'),
('La ladrona de libros', '2005-01-01', 'Markus Zusak', 3, 2.90, 14.50, 'Drama', 'img/libros/ladrona_de_libros.jpg'),
('Cometas en el cielo', '2003-01-01', 'Khaled Hosseini', 4, 3.00, 15.99, 'Drama', 'img/libros/cometas_en_el_cielo.jpg');

-- Contenido total de libros de la WEB con oferta
INSERT INTO Libro (titulo, publicacion, autor, cantidad_disponible, precio_alquiler, precio_compra, genero, url_imagen, oferta, descuento)
VALUES
('Don Quijote de la Mancha', '1605-01-16', 'Miguel de Cervantes', 6, 3.00, 18.99, 'Clásico', 'img/libros/don_quijote.jpg', TRUE, 10),
('Ulises', '1922-02-02', 'James Joyce', 2, 3.50, 20.00, 'Modernismo', 'img/libros/ulises.jpg', TRUE, 20),
('Madame Bovary', '1856-01-01', 'Gustave Flaubert', 3, 2.60, 14.00, 'Realismo', 'img/libros/madame_bovary.jpg', TRUE, 50),
('El guardián entre el centeno', '1951-07-16', 'J.D. Salinger', 3, 2.90, 14.99, 'Ficción', 'img/libros/guardian_entre_el_centeno.jpg', TRUE, 10),
('Los miserables', '1862-01-01', 'Victor Hugo', 3, 3.25, 18.00, 'Histórica', 'img/libros/los_miserables.jpg', TRUE, 20),
('Drácula', '1897-05-26', 'Bram Stoker', 4, 2.70, 13.99, 'Terror', 'img/libros/dracula.jpg', TRUE, 20),
('Hamlet', '1603-01-01', 'William Shakespeare', 3, 3.00, 15.00, 'Tragedia', 'img/libros/hamlet.jpg', TRUE, 20),
('Rayuela', '1963-01-01', 'Julio Cortázar', 3, 3.00, 15.99, 'Vanguardismo', 'img/libros/rayuela.jpg', TRUE, 20),
('Pedro Páramo', '1955-01-01', 'Juan Rulfo', 4, 2.70, 13.50, 'Realismo mágico', 'img/libros/pedro_paramo.jpg', TRUE, 20),
('El nombre de la rosa', '1980-01-01', 'Umberto Eco', 4, 3.25, 18.50, 'Misterio histórico', 'img/libros/nombre_de_la_rosa.jpg', TRUE, 20),
('El alquimista', '1988-01-01', 'Paulo Coelho', 5, 2.80, 13.99, 'Ficción', 'img/libros/el_alquimista.jpg', TRUE, 20);

UPDATE Libro
SET bestseller = TRUE
WHERE id_libro IN (3, 1, 11, 15, 6, 14, 13, 24);



  
SELECT JSON_PRETTY(
    JSON_ARRAYAGG(
        JSON_OBJECT(
            'id', id_libro,
            'titulo', titulo,
            'publicacion', publicacion,
            'autor', autor,
            'cantidadDisponible', cantidad_disponible,
            'precioAlquiler', precio_alquiler,
            'precioCompra', precio_compra,
            'genero', genero,
            'urlImagen', url_imagen,
            'oferta', oferta,
            'descuento', descuento,
            'bestseller', bestseller
        )
    )
) AS libros_json
FROM Libro;




