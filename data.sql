use car;
insert into buses (distance,end_location,level,start_location) values
(100,"Ha Noi",1,"Hai Phong"),
(150,"Quang Ninh",1,"Bac Ninh"),
(100,"Nam Dinh",1,"Ninh Binh"),
(90,"Thanh Hoa",1,"Nghe An"),
(170,"Hoa Binh",1,"Son La"),
(200,"Thai Binh",1,"Thanh Hoa"),
(1600,"Ha Noi",3,"Sai Gon"),
(1300,"Ha Noi",3,"Cam Ranh"),
(1900,"Ha Noi",3,"Ca Mau"),
(300,"Ha Giang",2,"Hoa Binh"),
(125,"Cao Bang",1,"Lang Son"),
(425,"Bac Ninh",2,"Ha Tinh"),
(525,"Ha Noi",2,"Quang Binh"),
(825,"Ha Noi",2,"Quang Nam"),
(1800,"Ha Noi",3,"Can Tho"),
(1915,"Ha Noi",3,"Soc Trang"),
(766,"Ha Noi",2,"Da Nang"),
(510,"Son La",2,"Nghe An");


insert into car(color,last_maintenance,license_plate,longevity,manufactured,model,seats,year_manufactured) values
("green",'2020-12-02 23:59:59',123456,15,"ex","A01",30,2010),
("red",'2020-05-02 22:30:59',234561,15,"yamaha","A02",28,2011),
("orange",'2020-07-02 18:59:59',963251,20,"honda","A03",16,2009),
("yellow",'2020-05-12 15:00:59',165894,20,"honda","A04",8,2016),
("blue",'2020-06-08 18:30:59',759621,32,"nasaki","A05",32,2001),
("navy",'2020-10-08 19:30:59',755123,20,"yasaki","B01",32,2008),
("grey",'2020-03-28 7:30:59',365294,10,"naoki","C03",32,2015),
("neon",'2020-09-08 08:00:59',695723,16,"flame","D09",32,2007),
("gradient",'2020-09-05 09:00:59',136578,18,"samsung","D05",64,2002),
("gracy",'2018-05-05 01:00:59',625412,18,"LG","G05",34,2010);
insert into employee(address,birthday,full_name,id_card,id_license,license_type,seniority) values
("Hoang Hoa Tham Ha Noi",'2020-03-09',"Nguyen Van Quan",3694,3652,"B01",10),
("Nguyen Xien Ha Noi",'2020-03-10',"Trinh Van Dai",96954,5752,"B02",15),
("Vo Quy Kien Ha Noi",'2020-04-05',"Hoang Van Giap",36625,3662,"B01",20),
("Ngoc Thuy Ha Noi",'2020-07-08',"Hoang Van Manh",69543,3652,"B02",30),
("Thuy Khue Ha Noi",'2020-04-06',"Nguyen Van Minh",78525,7669,"B02",15),
("Ly Thuong Kiet Ha Noi",'2020-04-09',"Le Van Hong",96525,4862,"B01",20),
("Tran Thai Tong Ha Noi",'2020-12-25',"Pham Van Hung",65425,7672,"C01",25),
("Le Van Luong Ha Noi",'2020-09-16',"Trinh Van Hoa",37965,9682,"B02",30),
("Van Bao Ha Noi",'2020-04-05',"Hoang Van Giap",36685,3662,"B01",20),
("Phan Boi Chau Ha Noi",'2020-04-30',"Le Hung Vy",77525,5262,"B01",30);
insert into trip (guest_number,price,buses_id,driver_id,sub_driver_id) values
(28,100,1,1,2),
(38,150,2,2,3),
(8,50,3,3,2),
(13,80,4,2,1),
(14,150,4,3,4),
(6,200,5,5,6),
(62,150,7,5,4),
(14,150,6,7,6),
(30,150,5,9,10),
(38,150,4,10,2),
(6,150,5,8,6);