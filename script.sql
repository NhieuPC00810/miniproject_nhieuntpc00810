create database J6Store_lab8_pc00810;
USE J6Store_lab8_pc00810;	
CREATE TABLE Accounts(
	Username nvarchar(50) NOT NULL primary key,
	Password nvarchar(50) NOT NULL,
	Fullname nvarchar(50) NOT NULL,
	Email nvarchar(50) NOT NULL,
	Photo nvarchar(50) NOT NULL
);

CREATE TABLE Roles(
	Id nvarchar(10) NOT NULL primary key,
	Name nvarchar(50) NOT NULL
);


CREATE TABLE Authorities(
	Id int AUTO_INCREMENT NOT NULL primary key ,
	Username nvarchar(50) NOT NULL ,
	RoleId nvarchar(10) NOT NULL
);


CREATE TABLE Categories(
	Id char(4) NOT NULL primary key,
	Name nvarchar(50) NOT NULL
 );

CREATE TABLE OrderDetails(
	Id bigint  AUTO_INCREMENT NOT NULL primary key,
	OrderId bigint NOT NULL,
	ProductId int NOT NULL,
	Price float NOT NULL,
	Quantity int NOT NULL
 );
 
 
CREATE TABLE Orders(
	Id bigint AUTO_INCREMENT NOT NULL primary key,
	Username nvarchar(50) NOT NULL,
	CreateDate datetime NOT NULL,
	Address nvarchar(100) NOT NULL
 );
 

 
CREATE TABLE Products(
	Id int AUTO_INCREMENT	 NOT NULL  primary key,
	Name nvarchar(50) NOT NULL,
	Image nvarchar(50) NOT NULL,
	Price float NOT NULL,
	CreateDate date NOT NULL,
	Available bit NOT NULL,
	CategoryId char(4) NOT NULL
);
ALTER TABLE Authorities ADD FOREIGN KEY(Username) REFERENCES Accounts(Username) ON UPDATE CASCADE
ON DELETE CASCADE;
ALTER TABLE Authorities ADD FOREIGN KEY(RoleId) REFERENCES Roles(Id) ON UPDATE CASCADE
ON DELETE CASCADE;
ALTER TABLE OrderDetails ADD FOREIGN KEY(OrderId) REFERENCES Orders(Id) ON UPDATE CASCADE
ON DELETE CASCADE;
ALTER TABLE OrderDetails ADD FOREIGN KEY(ProductId) REFERENCES Products(Id) ON UPDATE CASCADE
ON DELETE CASCADE;
ALTER TABLE Orders ADD FOREIGN KEY(Username) REFERENCES Accounts(Username) ON UPDATE CASCADE
ON DELETE CASCADE;
ALTER TABLE Products ADD FOREIGN KEY(CategoryId) REFERENCES Categories(Id) ON UPDATE CASCADE
ON DELETE CASCADE;

INSERT Categories VALUES (N'1000', N'Đồng hồ đeo tay');
INSERT Categories VALUES (N'1001', N'Máy tính xách tay');
INSERT Categories VALUES (N'1002', N'Máy ảnh');
INSERT Categories VALUES (N'1003', N'Điện thoại');
INSERT Categories VALUES (N'1004', N'Nước hoa');
INSERT Categories VALUES (N'1005', N'Nữ trang');
INSERT Categories VALUES (N'1006', N'Nón thời trang');
INSERT Categories VALUES (N'1007', N'Túi xách du lịch');
INSERT Categories VALUES (N'5000', N'Đồng hồ đeo tay');
INSERT Categories VALUES (N'5001', N'Đồng hồ đeo tay');
INSERT Categories VALUES (N'5002', N'Đồng hồ đeo tay');

INSERT Products VALUES (1001, N'Aniseed Syrup', N'1001.jpg', 190, CAST(N'1980-03-29' AS Date), 0, N'1000');
INSERT Products VALUES (1002, N'Change', N'1002.jpg', 19, CAST(N'1982-12-18' AS Date), 0, N'1000');
INSERT Products VALUES (1003, N'Aniseed Syrup', N'1003.jpg', 10, CAST(N'1973-06-14' AS Date), 1, N'1001');
INSERT Products VALUES (1004, N'Chef Anton''s Cajun Seasoning', N'1004.jpg', 22, CAST(N'1976-03-10' AS Date), 0, N'1001');
INSERT Products VALUES (1005, N'Chef Anton''s Gumbo Mix', N'1005.jpg', 21.35, CAST(N'1978-12-06' AS Date), 1, N'1002');
INSERT Products VALUES (1006, N'Grandma''s Boysenberry Spread', N'1006.jpg', 25, CAST(N'1981-09-03' AS Date), 0, N'1001');
INSERT Products VALUES (1007, N'Uncle Bob''s Organic Dried Pears', N'1007.jpg', 30, CAST(N'1983-03-13' AS Date), 0, N'1006');
INSERT Products VALUES (1008, N'Northwoods Cranberry Sauce', N'1008.jpg', 40, CAST(N'1972-02-26' AS Date), 0, N'1001');
INSERT Products VALUES (1009, N'Mishi Kobe Niku', N'1009.jpg', 97, CAST(N'1985-12-10' AS Date), 0, N'1005');
INSERT Products VALUES (1010, N'Ikura', N'1010.jpg', 31, CAST(N'1994-03-23' AS Date), 0, N'1007');
INSERT Products VALUES (1011, N'Queso Cabrales', N'1011.jpg', 21, CAST(N'1985-11-28' AS Date), 0, N'1003');
INSERT Products VALUES (1012, N'Queso Manchego La Pastora', N'1012.jpg', 38, CAST(N'1988-08-27' AS Date), 1, N'1003');
INSERT Products VALUES (1013, N'Konbu', N'1013.jpg', 6, CAST(N'2002-07-01' AS Date), 0, N'1007');
INSERT Products VALUES (1014, N'Tofu', N'1014.jpg', 23.25, CAST(N'2002-06-24' AS Date), 1, N'1006');
INSERT Products VALUES (1015, N'Genen Shouyu', N'1015.jpg', 15.5, CAST(N'1991-05-04' AS Date), 0, N'1001');
INSERT Products VALUES (1016, N'Pavlova', N'1016.jpg', 17.45, CAST(N'1996-11-09' AS Date), 0, N'1002');
INSERT Products VALUES (1017, N'Alice Mutton', N'1017.jpg', 39, CAST(N'2007-12-15' AS Date), 1, N'1005');
INSERT Products VALUES (1018, N'Carnarvon Tigers', N'1018.jpg', 62.5, CAST(N'2011-04-13' AS Date), 1, N'1007');
INSERT Products VALUES (1019, N'Teatime Chocolate Biscuits', N'1019.jpg', 9.2, CAST(N'2005-02-02' AS Date), 0, N'1002');
INSERT Products VALUES (1020, N'Sir Rodney''s Marmalade', N'1020.jpg', 81, CAST(N'2007-11-01' AS Date), 0, N'1002');
INSERT Products VALUES (1021, N'Sir Rodney''s Scones', N'1021.jpg', 10, CAST(N'2010-07-29' AS Date), 0, N'1002');
INSERT Products VALUES (1022, N'Gustaf flower', N'1022.jpg', 21, CAST(N'2008-12-01' AS Date), 1, N'1004');
INSERT Products VALUES (1023, N'Tunnbr Korea', N'1023.jpg', 9, CAST(N'2011-08-31' AS Date), 1, N'1004');
INSERT Products VALUES (1024, N'Guarana¡ Fanta¡stica', N'1024.jpg', 4.5, CAST(N'2008-03-13' AS Date), 0, N'1000');
INSERT Products VALUES (1025, N'NuNuCa Nuaa-Nougat-Creme', N'1025.jpg', 14, CAST(N'2011-07-20' AS Date), 0, N'1002');
INSERT Products VALUES (1026, N'Gumbar Gummibarchen', N'1026.jpg', 31.23, CAST(N'2009-04-17' AS Date), 1, N'1002');
INSERT Products VALUES (1027, N'Schoggi Schokolade', N'1027.jpg', 43.9, CAST(N'2007-01-14' AS Date), 0, N'1002');
INSERT Products VALUES (1028, N'Russle Sauerkraut', N'1028.jpg', 45.6, CAST(N'2011-01-14' AS Date), 1, N'1006');
INSERT Products VALUES (1029, N'Tharinger Rostbratwurst', N'1029.jpg', 123.79, CAST(N'2010-12-21' AS Date), 0, N'1005');
INSERT Products VALUES (1030, N'Nord-Ost Matjeshering', N'1030.jpg', 25.89, CAST(N'2011-05-14' AS Date), 0, N'1007');
INSERT Products VALUES (1031, N'Gorgonzola Telino', N'1031.jpg', 12.5, CAST(N'2010-10-30' AS Date), 0, N'1003');
INSERT Products VALUES (1032, N'Mascarpone Fabioli', N'1032.jpg', 32, CAST(N'2011-07-30' AS Date), 0, N'1003');
INSERT Products VALUES (1033, N'Geitost', N'1033.png', 2.5, CAST(N'2010-04-29' AS Date), 0, N'1003');
INSERT Products VALUES (1034, N'Sasquatch Ale', N'1034.jpg', 14, CAST(N'2010-07-30' AS Date), 1, N'1000');
INSERT Products VALUES (1035, N'Steeleye Stout', N'1035.jpg', 18, CAST(N'2011-04-25' AS Date), 0, N'1000');
INSERT Products VALUES (1036, N'Inlagd Sill', N'1036.jpg', 19, CAST(N'1980-11-28' AS Date), 0, N'1007');
INSERT Products VALUES (1037, N'Gravad lax', N'1037.jpg', 26, CAST(N'1983-08-31' AS Date), 0, N'1007');
INSERT Products VALUES (1038, N'Cate de Blaye', N'1038.jpg', 263.5, CAST(N'1981-07-12' AS Date), 0, N'1000');
INSERT Products VALUES (1039, N'Chartreuse verte', N'1039.jpg', 18, CAST(N'1984-04-08' AS Date), 0, N'1000');
INSERT Products VALUES (1040, N'Boston Crab Meat', N'1040.jpg', 18.4, CAST(N'1976-12-08' AS Date), 0, N'1007');
INSERT Products VALUES (1041, N'Jack''s New England Clam Chowder', N'1041.jpg', 9.65, CAST(N'1979-09-10' AS Date), 0, N'1007');
INSERT Products VALUES (1042, N'Singaporean Hokkien Fried Mee', N'1042.jpg', 14, CAST(N'1973-11-21' AS Date), 0, N'1004');
INSERT Products VALUES (1043, N'Ipoh Coffee', N'1043.jpg', 46, CAST(N'1980-03-20' AS Date), 0, N'1000');
INSERT Products VALUES (1044, N'Gula Malacca', N'1044.jpg', 19.45, CAST(N'1970-10-25' AS Date), 0, N'1001');
INSERT Products VALUES (1045, N'Rogede sild', N'1045.jpg', 9.5, CAST(N'1990-09-21' AS Date), 1, N'1007');
INSERT Products VALUES (1046, N'Spegesild', N'1046.jpg', 12, CAST(N'1993-06-23' AS Date), 0, N'1007');
INSERT Products VALUES (1047, N'Zaanse koeken', N'1047.jpg', 9.5, CAST(N'1981-11-25' AS Date), 0, N'1002');
INSERT Products VALUES (1048, N'Chocolade', N'1048.jpg', 12.75, CAST(N'1984-08-24' AS Date), 0, N'1002');
INSERT Products VALUES (1049, N'Maxilaku', N'1049.jpg', 20, CAST(N'1987-05-23' AS Date), 0, N'1002');
INSERT Products VALUES (1050, N'Valkoinen suklaa', N'1050.jpg', 16.25, CAST(N'1990-02-17' AS Date), 0, N'1002');
INSERT Products VALUES (1051, N'Manjimup Dried Apples', N'1051.jpg', 53, CAST(N'2004-05-22' AS Date), 0, N'1006');
INSERT Products VALUES (1052, N'Filo Mix', N'1052.jpg', 7, CAST(N'2001-05-20' AS Date), 0, N'1004');
INSERT Products VALUES (1053, N'Perth Pasties', N'1053.jpg', 32.8, CAST(N'2007-01-06' AS Date), 0, N'1005');
INSERT Products VALUES (1054, N'Tourtiare', N'1054.jpg', 7.45, CAST(N'2009-10-07' AS Date), 1, N'1005');
INSERT Products VALUES (1055, N'Pacta chinois', N'1055.jpg', 24, CAST(N'2007-07-08' AS Date), 0, N'1005');
INSERT Products VALUES (1056, N'Gnocchi di nonna Alice', N'1056.jpg', 38, CAST(N'2007-05-18' AS Date), 0, N'1004');
INSERT Products VALUES (1057, N'Ravioli Angelo', N'1057.jpg', 19.5, CAST(N'2010-02-16' AS Date), 0, N'1004');
INSERT Products VALUES (1058, N'Escargots de Bourgogne', N'1058.jpg', 13.25, CAST(N'2011-07-26' AS Date), 0, N'1001');
INSERT Products VALUES (1059, N'Raclette Courdavault', N'1059.jpg', 55, CAST(N'2007-09-22' AS Date), 0, N'1003');
INSERT Products VALUES (1060, N'Camembert Pierrot', N'1060.jpg', 34, CAST(N'2010-06-20' AS Date), 0, N'1003');
INSERT Products VALUES (1061, N'Sirop d''aOrable', N'1061.jpg', 28.5, CAST(N'2007-05-29' AS Date), 0, N'1001');
INSERT Products VALUES (1062, N'Tarte au sucre', N'1062.jpg', 49.3, CAST(N'2008-01-21' AS Date), 0, N'1002');
INSERT Products VALUES (1063, N'Vegie-spread', N'1063.jpg', 43.9, CAST(N'2007-11-21' AS Date), 0, N'1001');
INSERT Products VALUES (1064, N'Wimmers gute Semmelknadel', N'1064.jpg', 33.25, CAST(N'2009-05-15' AS Date), 0, N'1004');
INSERT Products VALUES (1065, N'Louisiana Fiery Hot Pepper Sauce', N'1065.jpg', 21.05, CAST(N'2008-05-15' AS Date), 0, N'1001');
INSERT Products VALUES (1066, N'Louisiana Hot Spiced Okra', N'1066.jpg', 17, CAST(N'2011-02-10' AS Date), 1, N'1001');
INSERT Products VALUES (1067, N'Laughing Lumberjack Lager', N'1067.jpg', 14, CAST(N'2010-12-05' AS Date), 1, N'1000');
INSERT Products VALUES (1068, N'Scottish Longbreads', N'1068.jpg', 12.5, CAST(N'2009-07-08' AS Date), 0, N'1002');
INSERT Products VALUES (1069, N'Gudbrandsdalsost', N'1069.jpg', 36, CAST(N'2011-03-09' AS Date), 0, N'1003');
INSERT Products VALUES (1070, N'Outback Lager', N'1070.jpg', 15, CAST(N'2009-02-21' AS Date), 0, N'1000');
INSERT Products VALUES (1071, N'Flotemysost', N'1071.jpg', 21.5, CAST(N'1980-09-04' AS Date), 1, N'1003');
INSERT Products VALUES (1072, N'Mozzarella di Giovanni', N'1072.jpg', 34.8, CAST(N'1983-06-03' AS Date), 0, N'1003');
INSERT Products VALUES (1073, N'Rad Kaviar', N'1073.jpg', 15, CAST(N'1982-12-03' AS Date), 0, N'1007');
INSERT Products VALUES (1074, N'Longlife Tofu', N'1074.jpg', 10, CAST(N'1982-09-27' AS Date), 0, N'1006');
INSERT Products VALUES (1075, N'RhanbrAu Klosterbier', N'1075.jpg', 7.75, CAST(N'1982-10-31' AS Date), 0, N'1000');
INSERT Products VALUES (1076, N'Lakkalik AAri', N'1076.jpg', 18, CAST(N'1970-07-28' AS Date), 0, N'1000');
INSERT Products VALUES (1077, N'Original Frankfurter grane Soae', N'1077.gif', 13, CAST(N'1976-04-04' AS Date), 0, N'1001');
INSERT Products VALUES (1081, N'Chai', N'1081.jpg', 19, CAST(N'1984-04-04' AS Date), 0, N'1000');
INSERT Products VALUES (1083, N'Mishi Kobe Niku', N'1083.jpg', 97, CAST(N'1989-07-23' AS Date), 0, N'1005');

INSERT Roles VALUES (N'CUST', N'Customers');
INSERT Roles VALUES (N'DIRE', N'Directors');
INSERT Roles VALUES (N'STAF', N'Staffs');

INSERT Accounts VALUES (N'Staff', N'123', N'Nguyễn Văn Tèo', N'teonv@gmail.com', N'user.png');
INSERT Accounts VALUES (N'Customer', N'123', N'Phạm Thị Nở', N'nopt@gmail.com', N'user.png');
INSERT Accounts VALUES (N'Director', N'123', N'Nguyễn Thanh Nhiều', N'nhieunt@gmail.com', N'user.png');

INSERT Authorities VALUES (2, N'Staff', N'STAF');
INSERT Authorities VALUES (3, N'Customer', N'CUST');
INSERT Authorities VALUES (4, N'Director', N'DIRE');

select * from j6store_lab8_pc00810.accounts;
select * from j6store_lab8_pc00810.authorities;




