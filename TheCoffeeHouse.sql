drop  DATABASE TheCoffeeHouse;
CREATE DATABASE TheCoffeeHouse;
use TheCoffeeHouse;
 
CREATE TABLE Accounts(
	Username nvarchar(50) primary key,
	Password nvarchar(50),
	Fullname nvarchar(50),
	Email nvarchar(50),
	Photo nvarchar(50)
);

CREATE TABLE Roles(
	Id nvarchar(10) primary key,
	Name nvarchar(50)
);

CREATE TABLE Authorities(
	Id int primary key AUTO_INCREMENT,
	Username nvarchar(20),
	RoleId nvarchar(10),
    FOREIGN KEY (Username) REFERENCES Accounts (Username),
    FOREIGN KEY (RoleId) REFERENCES Roles (Id)
);

CREATE TABLE Orders(
	Id bigint primary key AUTO_INCREMENT,
	Username nvarchar(50),
	CreateDate datetime,
	Address nvarchar(100),
    FOREIGN KEY (Username) REFERENCES Accounts (Username)
    );

CREATE TABLE Categories(
	Id char(4) primary key,
	Name nvarchar(50)
);
CREATE TABLE Products(
	Id int primary key AUTO_INCREMENT,
	Name nvarchar(50),
	Image nvarchar(50),
	Price float,
	CreateDate date,
	Available bit,
	CategoryId char(4),
    FOREIGN KEY (CategoryId) REFERENCES Categories (Id)
);

    CREATE TABLE OrderDetails(
	Id bigint primary key AUTO_INCREMENT,
	OrderId bigint,
	ProductId int,
	Price float,
	Quantity int,
    Size char(4),
    Note nvarchar(50),
    FOREIGN KEY (OrderId) REFERENCES Orders (Id),
    FOREIGN KEY (ProductId) REFERENCES Products (Id)
);

INSERT INTO Categories
VALUES
('Cafe','Coffee'),
('Cake','Cakes & Snacks'),
('Tea','Tea');

INSERT INTO Products (Name, Image, Price, CreateDate, Available, CategoryId)
VALUES
('1','Black Sugar and Iced Milk','Black Sugar and Iced Milk.jpg','2.9','2023-10-10','1','Cafe'),
('2','The Coffee House Sua Da','The Coffee House Sua Da.jpg','2.5','2023-10-07','1','Cafe'),
('3','Milk ice coffe','Milk ice coffe.jpg','2','2023-10-07','0','Cafe'),
('4','Hot milk coffee','Hot milk coffee.jpg','4','2023-10-07','1','Cafe'),
('5','Silver Siu','Silver Siu.jpg','2.9','2023-12-12','1','Cafe'),
('6','Hot Silver','Hot Silver.jpg','4','2023-12-12',NULL,'Cafe'),
('7','Black coffee with ice','Black coffee with ice.jpg','2','2023-12-12',NULL,'Cafe'),
('8','Hot black coffee','Hot black coffee.jpg','3','2023-12-12',NULL,'Cafe'),
('9','Chai Fresh Iced Milk Coffee 250ML','Chai Fresh Iced Milk Coffee 250ML.jpg','4.6','2023-12-12',NULL,'Cafe'),
('10','Kumquat Chicken Stick Bread','Kumquat Chicken Stick Bread.jpg','2','2023-12-12',NULL,'Cake'),
('11','Tuna Mayo Sticks','Tuna Mayo Sticks.jpg','2','2023-12-12',NULL,'Cake'),
('12','Pate Bread Sticks','Pate Bread Sticks.jpg','1.5','2023-12-12',NULL,'Cake'),
('13','Spicy Pate Breadsticks','Spicy Pate Breadsticks.jpg','1.5','2023-12-12',NULL,'Cake'),
('14','Vietnamese Bread with Cold Meat','Vietnamese Bread with Cold Meat.jpg','2.5','2023-12-12',NULL,'Cake'),
('15','Salted egg croissant ','Salted egg croissant.jpg','2.5','2023-12-12',NULL,'Cake'),
('17','Cheese Floss','Cheese Floss.jpg','3','2023-12-12',NULL,'Cake'),
('18','Raspberry Ice Cream Mochi','Raspberry Ice Cream Mochi.jpg','1.8','2023-12-12',NULL,'Cake'),
('19','Blueberry Ice Cream Mochi','Blueberry Ice Cream Mochi.jpg','1.8','2023-12-12',NULL,'Cake'),
('20','Coconut Pineapple Ice Cream Mochi','Coconut Pineapple Ice Cream Mochi.jpg','1.8','2023-12-12',NULL,'Cake'),
('21','Chocolate Ice Cream Mochi','Chocolate Ice Cream Mochi.jpg','1.8','2023-12-12',NULL,'Cake'),
('22','Matcha Ice Cream Mochi','Matcha Ice Cream Mochi.jpg','1.8','2023-12-12',NULL,'Cake'),
('23','Mango Ice Cream Mochi','Mango Ice Cream Mochi.jpg','1.8','2023-12-12',NULL,'Cake'),
('24','Mousse Red Velvet','Mousse Red Velvet.jpg','3','2023-12-12',NULL,'Cake'),
('25','Mousse Tiramisu','Mousse Tiramisu.jpg','3','2023-12-12',NULL,'Cake'),
('26','Chocolate Bear Mousse','Chocolate Bear Mousse.jpg','3','2023-12-12',NULL,'Cake'),
('27','Dried Jackfruit','Dried Jackfruit.jpg','2','2023-12-12',NULL,'Cake'),
('28','Chicken Shredded with Lemon Leaves','Chicken Shredded with Lemon Leaves.jpg','2','2023-12-12',NULL,'Cake'),
('29','Lotus Seed Longan Tea','Lotus Seed Longan Tea.jpg','3','2023-12-12',NULL,'Tea'),
('30','Peach Orange Lemongrass Tea - Iced','Peach Orange Lemongrass Tea - Iced.jpg','3','2023-12-12',NULL,'Tea'),
('31','Peach Orange Lemongrass Tea - Hot','Peach Orange Lemongrass Tea - Hot.jpg','3','2023-12-12',NULL,'Tea'),
('32','Lotus Seed Tea - Iced','Lotus Seed Tea - Iced.jpg','3','2023-12-12',NULL,'Tea'),
('33','Lotus Seed Tea - Hot','Lotus Seed Tea - Hot.jpg','3','2023-12-12',NULL,'Tea'),
('34','Peach Orange Lemongrass Tea Chai Fresh 500ML','Peach Orange Lemongrass Tea Chai Fresh 500ML.jpg','3.4','2023-12-12',NULL,'Tea'),
('36','Black Pearl Milk Tea','Black Pearl Milk Tea.jpg','4','2023-12-12',NULL,'Tea'),
('37','Hot Black Milk Tea','Hot Black Milk Tea.jpg','4','2023-12-12',NULL,'Tea'),
('38','Oolong Roasted Pearl Milk Tea','Oolong Roasted Pearl Milk Tea.jpg','4','2023-12-12',NULL,'Tea'),
('39','Roasted Oolong Milk Tea (Hot)','Roasted Oolong Milk Tea (Hot).jpg','4','2023-12-12',NULL,'Tea'),
('40','Macadamia Pearl Milk Tea','Macadamia Pearl Milk Tea.jpg','4','2023-12-12',NULL,'Tea'),
('41','Oolong Roasted Pearl Milk Tea Chai Fresh 500ML','Oolong Roasted Pearl Milk Tea Chai Fresh 500ML.jpg','5','2023-12-12',NULL,'Tea');






