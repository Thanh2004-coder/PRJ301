CREATE TABLE Category (
    categoryID INT PRIMARY KEY,
    categoryName VARCHAR(255) NOT NULL
);

CREATE TABLE CafeItem (
    id INT PRIMARY KEY NOT NULL,
    categoryID INT,
    name VARCHAR(100) NOT NULL,
    quantity INT,
    price DECIMAL(10, 2),
    image VARCHAR(255),
    FOREIGN KEY (categoryID) REFERENCES Category(categoryID)
);
CREATE TABLE Account (
    id INT PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(50) NULL,
    email VARCHAR(100) NULL,
    phone_number VARCHAR(15) NULL
);
INSERT INTO Category (categoryID, categoryName) VALUES (1, N'Monka');
INSERT INTO Category (categoryID, categoryName) VALUES (2, N'Mchose');
INSERT INTO Category (categoryID, categoryName) VALUES (3, N'Xinmeng');
INSERT INTO Category (categoryID, categoryName) VALUES (4, N'Yunzii');
INSERT INTO CafeItem (id, categoryID, name, quantity, price, image) VALUES 
(1, 1, 'Cà phê s?a dá', 10, 25.00, 'image1.jpg'),
(2, 1, 'Cà phê den', 15, 20.00, 'image2.jpg'),
(3, 2, 'Trà s?a', 20, 30.00, 'image3.jpg'),
(4, 2, 'Trà dào', 12, 28.00, 'image4.jpg'),
(5, 3, 'Sinh t? bo', 8, 35.00, 'image5.jpg'),
(6, 3, 'Sinh t? xoài', 14, 32.00, 'image6.jpg'),
(7, 4, 'Nu?c ép cam', 18, 22.00, 'image7.jpg'),
(8, 4, 'Nu?c ép táo', 10, 21.00, 'image8.jpg'),
(9, 1, 'Cà phê mocha', 5, 40.00, 'image9.jpg');
INSERT INTO Account (id, username, password, role, email, phone_number) VALUES 
(1, 'user1', 'password1', 'user', 'user1@example.com', '1234567890'),
(2, 'user2', 'password2', 'admin', 'user2@example.com', '0987654321'),
(3, 'user3', 'password3', 'user', 'user3@example.com', '1122334455'),
(4, 'user4', 'password4', 'user', 'user4@example.com', '2233445566'),
(5, 'user5', 'password5', 'admin', 'user5@example.com', '3344556677'),
(6, 'user6', 'password6', 'user', 'user6@example.com', '4455667788'),
(7, 'user7', 'password7', 'user', 'user7@example.com', '5566778899'),
(8, 'user8', 'password8', 'admin', 'user8@example.com', '6677889900'),
(9, 'user9', 'password9', 'user', 'user9@example.com', '7788990011'),
(10, 'thanh', '123', 'admin', 'user9@example.com', '7788990011'),
(11, 'tha', '1', 'user', 'user9@example.com', '7788990011');
select * from Account
select * from account where id = 4
CREATE TABLE Cart (
    cartID INT PRIMARY KEY NOT NULL,  
    accountID INT NOT NULL,                  
    itemID INT NOT NULL,                     
    quantity INT NOT NULL ,       
    FOREIGN KEY (accountID) REFERENCES Account(id),  
    FOREIGN KEY (itemID) REFERENCES CafeItem(id)     
);
