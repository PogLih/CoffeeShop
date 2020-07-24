create database Cafe_DuAn1
go
use Cafe_DuAn1
go
--OrderNumber
create table OrderNumber
(
	id int identity primary key,
	[status] bit not null default 0 -- trống || có người
)
go
--Account
create table Account
(
	Username nvarchar(100) primary key,
	DisplayName nvarchar(100)NOT NULL default N'Nhân Viên',
	[PassWord] nvarchar(100)NOT NULL default 0,
	[Type] bit NOT NULL  default 0--1:chủ && 0:NV
)
go
--Category
create table Category
(
	id int identity primary key,
	name nvarchar(100)NOT NULL default N'chưa đặt tên',
)
go
--Drinks&somethingelse
create table Drinks
(
	id int identity primary key,
	name nvarchar(100)NOT NULL default N'Chưa đặt tên',
	idcategory int NOT NULL foreign key references Category(id),
	price float NOT NULL default 0
)
go
--Customer
create table Customer
(
	phone nvarchar(12) primary key,
	name nvarchar(50) not null,
	point int default 0
)
go
--Bill
create table Bill
(
	id int identity primary key,
	DateCheckIn date NOT NULL default getdate(),
	OrderNumber int foreign key references OrderNumber(id),
	Staffname nvarchar(50) not null,
	CustomerPhoneNumber nvarchar(12) foreign key references Customer(phone),
	TotalPrice float default 0
)
go
--BillInfo
create table BillInfo
(
	idBill int NOT NULL foreign key references Bill(id),
	idDrinks int NOT NULL foreign key references Drinks(id),
	Quantity int NOT NULL default 0,
	Price float not null,
	constraint pk_billinfo primary key (idBill,idDrinks)
)
go
--Storage
create table Storage
(
	iddrink int foreign key references Drinks(id),
	quantity int
)
go
------------------thêm customer
go
insert dbo.Customer(phone,name) values ('012345678','phong')
insert dbo.Customer(phone,name) values ('012123141','thinh')
insert dbo.Customer(phone,name) values ('035647412','minh')
insert dbo.Customer(phone,name) values ('085645212','chau')
insert dbo.Customer(phone,name) values ('012312311','hoang')
go
------------------thêm account
go
insert into Account values (N'Thinh',N'Thịnh',N'Thinh',0)
insert into Account values (N'Minh',N'Minh',N'Minh',0)
insert into Account values (N'Hoang',N'Hoàng',N'Hoang',0)
insert into Account values (N'Chau',N'Châu',N'Chau',0)
insert into Account values (N'Phong',N'Phong',N'Phong',1)
go
------------------Thêm category
go
insert dbo.Category values ('Coffe')
insert dbo.Category values ('Soda')
insert dbo.Category values ('Ice Blended')
insert dbo.Category values ('Yaourt')
insert dbo.Category values ('Smoothies')
insert dbo.Category values ('Milk Shake')
insert dbo.Category values ('Virgin')
insert dbo.Category values ('Fruit Tea')
insert dbo.Category values ('Smoothies Fruit')
insert dbo.Category values ('Milk Tea')
insert dbo.Category values ('Juice')
insert dbo.Category values ('Flower Tea')
insert dbo.Category values ('Mix Drinks')
insert dbo.Category values ('Different')
------------------Thêm nước
go
insert drinks(name,idcategory,price) values (N'Black Coffee',1,14)
insert drinks(name,idcategory,price) values (N'Milk coffee',1,18)
insert drinks(name,idcategory,price) values (N'Coffe sữa lắc',1,22)
insert drinks(name,idcategory,price) values (N'Ca cao sữa',1,25)
insert drinks(name,idcategory,price) values (N'Bạc xỉu 3 tầng',1,23)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Blue Curacao',2,33)
insert drinks(name,idcategory,price) values (N'Berry',2,33)
insert drinks(name,idcategory,price) values (N'Passion',2,33)
insert drinks(name,idcategory,price) values (N'Mint',2,33)
insert drinks(name,idcategory,price) values (N'Lavender',2,33)
insert drinks(name,idcategory,price) values (N'Blue+Passion',2,33)
insert drinks(name,idcategory,price) values (N'Rose+Rasberry',2,33)
insert drinks(name,idcategory,price) values (N'Grape+Cinnamon',2,33)
insert drinks(name,idcategory,price) values (N'Berry+Apple',2,33)
insert drinks(name,idcategory,price) values (N'Berry+Coconut',2,33)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Chocolate Coffee',3,40)
insert drinks(name,idcategory,price) values (N'Caramel Coffee',3,40)
insert drinks(name,idcategory,price) values (N'Green Tea Coffee',3,40)
insert drinks(name,idcategory,price) values (N'Cookie Chocolate',3,40)
insert drinks(name,idcategory,price) values (N'Cookie Berry',3,40)
insert drinks(name,idcategory,price) values (N'Cookie Mint',3,40)
insert drinks(name,idcategory,price) values (N'Apple Ice',3,40)
insert drinks(name,idcategory,price) values (N'Tiramisu Ice',3,40)
insert drinks(name,idcategory,price) values (N'Matcha Ice',3,40)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Chanh dây',4,30)
insert drinks(name,idcategory,price) values (N'Đào',4,30)
insert drinks(name,idcategory,price) values (N'Xoài',4,30)
insert drinks(name,idcategory,price) values (N'Vãi',4,30)
insert drinks(name,idcategory,price) values (N'Dâu',4,30)
insert drinks(name,idcategory,price) values (N'Phúc bồn tử',4,30)
--------------------------------------------------
insert drinks(name,idcategory,price) values (N'Bơ',5,35)
insert drinks(name,idcategory,price) values (N'Dừa',5,35)
insert drinks(name,idcategory,price) values (N'Mãng cầu',5,35)
insert drinks(name,idcategory,price) values (N'Dâu',5,35)
insert drinks(name,idcategory,price) values (N'Việt quất',5,35)
insert drinks(name,idcategory,price) values (N'Chanh tuyết',5,35)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Chanh dây',6,30)
insert drinks(name,idcategory,price) values (N'Đào',6,30)
insert drinks(name,idcategory,price) values (N'Xoài',6,30)
insert drinks(name,idcategory,price) values (N'Vãi',6,30)
insert drinks(name,idcategory,price) values (N'Dâu',6,30)
insert drinks(name,idcategory,price) values (N'Phúc bồn tử',6,30)
--------------------------------------------------
insert drinks(name,idcategory,price) values (N'Dừa',7,35)
insert drinks(name,idcategory,price) values (N'Matcha',7,35)
insert drinks(name,idcategory,price) values (N'Bạc hà',7,35)
insert drinks(name,idcategory,price) values (N'Dâu',7,35)
--------------------------------------------------
insert drinks(name,idcategory,price) values (N'Bơ',8,35)
insert drinks(name,idcategory,price) values (N'Dừa',8,35)
insert drinks(name,idcategory,price) values (N'Mãng cầu',8,35)
insert drinks(name,idcategory,price) values (N'Dâu',8,35)
insert drinks(name,idcategory,price) values (N'Việt quất',8,35)
insert drinks(name,idcategory,price) values (N'Chanh tuyết',8,35)
------------------------------------------------
insert drinks(name,idcategory,price) values (N'Chanh dây',9,30)
insert drinks(name,idcategory,price) values (N'Đào',9,30)
insert drinks(name,idcategory,price) values (N'Xoài',9,30)
insert drinks(name,idcategory,price) values (N'Vãi',9,30)
insert drinks(name,idcategory,price) values (N'Dâu',9,30)
insert drinks(name,idcategory,price) values (N'Phúc bồn tử',9,30)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Matcha',10,25)
insert drinks(name,idcategory,price) values (N'Tiramisu',10,25)
insert drinks(name,idcategory,price) values (N'Đào',10,25)
insert drinks(name,idcategory,price) values (N'chanh dây',10,25)
insert drinks(name,idcategory,price) values (N'dưa lưới',10,25)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Chanh dây',11,30)
insert drinks(name,idcategory,price) values (N'Đào',11,30)
insert drinks(name,idcategory,price) values (N'Xoài',11,30)
insert drinks(name,idcategory,price) values (N'vãi',11,30)
insert drinks(name,idcategory,price) values (N'Dâu',11,30)
insert drinks(name,idcategory,price) values (N'Phúc bồn tử',11,30)
-------------------------------------------------
insert drinks(name,idcategory,price) values (N'Hoa hồng',12,30)
insert drinks(name,idcategory,price) values (N'Hoa cúc',12,30)
insert drinks(name,idcategory,price) values (N'Hoa Quế',12,30)
insert drinks(name,idcategory,price) values (N'Hoa bách hợp',12,30)
insert drinks(name,idcategory,price) values (N'Hoa đào',12,30)
insert drinks(name,idcategory,price) values (N'Hoa Cam',12,30)
--------------------------------------------------
insert drinks(name,idcategory,price) values (N'Chanh dây',13,30)
insert drinks(name,idcategory,price) values (N'Đào',13,30)
insert drinks(name,idcategory,price) values (N'Xoài',13,30)
insert drinks(name,idcategory,price) values (N'Vãi',13,30)
insert drinks(name,idcategory,price) values (N'Dâu',13,30)
insert drinks(name,idcategory,price) values (N'Phúc bồn tử',13,30)
------------------------------------------------
insert drinks(name,idcategory,price) values (N'Thuốc mèo',14,2)
insert drinks(name,idcategory,price) values (N'Thuốc 3 số',14,2)
insert drinks(name,idcategory,price) values (N'Gói mèo',14,20)
insert drinks(name,idcategory,price) values (N'Gói 3 số',14,25)
insert drinks(name,idcategory,price) values (N'Khăn lạnh',14,2)
go
-------------------------------Thêm OrderNumber
declare @i int = 1
while @i <= 100
begin
	insert dbo.OrderNumber(status) values(0)
	set @i=@i+1
end
go
-------------------------------Thêm bill
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-12-1',1,'Quản lý: Phong','012345678',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-12-30',2,'Quản lý: Phong','012345678',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-11-1',3,'Quản lý: Phong','012123141',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-11-30',4,'Quản lý: Phong','012123141',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-10-1',5,'Quản lý: Phong','035647412',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-10-30',6,'Quản lý: Phong','035647412',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-9-1',7,'Quản lý: Phong','012312311',100)
insert into Bill(DateCheckIn,OrderNumber,Staffname,CustomerPhoneNumber,TotalPrice) values ('2019-9-30',8,'Quản lý: Phong','012312311',100)