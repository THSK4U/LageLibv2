use avis;

drop table Membres;
create table Membres(
   id_membre int not null primary key auto_increment,
   nom_mb varchar(40),
   username varchar(20),
   password varchar(30),
   ladresse varchar(50),
  contact varchar(20)
);

