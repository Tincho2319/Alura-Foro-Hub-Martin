CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          login VARCHAR(50) NOT NULL UNIQUE,
                          clave VARCHAR(255) NOT NULL,
                          email VARCHAR(320) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;