drop table userPermissions CASCADE;
drop table GAB_Functionalities CASCADE;
drop table Users CASCADE;


Create table Users (
    uid serial primary key,
    UserName varchar(200) unique,
    FullName varchar(200),
    email  varchar(100),
    phone  varchar(20),
    pwd varchar(500)
);

create table GAB_Functionalities(
    fid serial primary key,
    fName   varchar(200) unique ,
    description varchar(1000)
);

Create table userPermissions(
	uid int references Users(uid) not null,
	fid int references GAB_Functionalities(fid)
);

insert into users (UserName,FullName,email,phone,pwd) values ('Venu','Venugopal Durshetty','vdurshety@gmail.com','23809723089','test');
insert into users (UserName,FullName,email,phone,pwd) values ('Gopal','Gopal Durshetty','Gopal@gmail.com','23232323232239','testing');
