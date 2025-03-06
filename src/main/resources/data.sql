-- Disable foreign key checks to avoid issues when truncating
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE products;
SET FOREIGN_KEY_CHECKS = 1;

-- Insert realistic product data
INSERT INTO products (id, code, name) VALUES (1, 'P101', 'Apple MacBook Pro');
INSERT INTO products (id, code, name) VALUES (2, 'P102', 'Sony 65-inch 4K OLED TV');
INSERT INTO products (id, code, name) VALUES (3, 'P103', 'Samsung Galaxy S23 Ultra');
INSERT INTO products (id, code, name) VALUES (4, 'P104', 'Bose Noise Cancelling Headphones');
INSERT INTO products (id, code, name) VALUES (5, 'P105', 'Logitech MX Master 3 Mouse');
INSERT INTO products (id, code, name) VALUES (6, 'P106', 'Dell XPS 15 Laptop');
INSERT INTO products (id, code, name) VALUES (7, 'P107', 'Apple iPad Pro 12.9-inch');
INSERT INTO products (id, code, name) VALUES (8, 'P108', 'Sony PlayStation 5');
INSERT INTO products (id, code, name) VALUES (9, 'P109', 'Microsoft Surface Laptop Studio');
INSERT INTO products (id, code, name) VALUES (10, 'P110', 'Nvidia RTX 4090 Graphics Card');
