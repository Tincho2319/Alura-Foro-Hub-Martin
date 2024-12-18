CREATE TABLE topicos
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo  VARCHAR(100) NOT NULL,
    mensaje TEXT         NOT NULL,
    fecha   DATE         NOT NULL,
    autor   VARCHAR(100) NOT NULL,
    curso   VARCHAR(100) NOT NULL
);