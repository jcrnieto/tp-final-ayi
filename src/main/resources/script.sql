--SQLScript

--Details
INSERT INTO `tp_final_ayi`.`detail_client`(`id_client_detail`, `points`, `vip`) VALUES
    (1, 45800, 0 ),
    (2, 20155, 1 ),
    (3, 844, 1 ),
    (4, 10090, 0 ),
    (5, 900, 1 ),
    (6, 49060, 0 ),
    (7, 154000, 1 ),
    (8, 45110, 0 ),
    (9, 14600, 0 ),
    (10, 37000, 0 );



--Clients
INSERT INTO`tp_final_ayi`.`client`(`id_client`,`dni`,`name`,`last_name`, details_fk)VALUES--is_activeattributeis"true"bydefault
(1,'39076703','Germán','Furfori',1),
(2,'40521326','JuanCruz','Nieto',2),
(3,'25457965','Silvia','Otaka',3),
(4,'36222154','JuanIgnacio','Caballero',4),
(5,'35216548','Gimena','Binaghi',5),
(6,'34521258','Fernanda','Balduzzi',6),
(7,'39658547','Leonel','Altamirano',7),
(8,'38546921','Nicolas','Clemente',8),
(9,'39456182','Rodrigo','Egea',9),
(10,'34251888','Josias','Pazzelli',10);

--Invoices
INSERT INTO`tp_final_ayi`.`invoice`VALUES
(1,"CubiertasMAXXISCrossmarkrod29X2",17500,1),
(2,"CajaShimanoHollowtech",22500,1),
(3,"PlatopalancaShimanoDeoreM4100",19890,1),
(4,"CascoBernLenox",4500,2),
(5,"HorquillaCannondaleLefty",32500,2),
(6,"BicicletaZenithRivaEliterod291x12",287489,3),
(7,"PuñosMTBRaleigh",860,4),
(8,"Cámara29x190",1300,4),
(9,"InfladorBulitserie600",7665,5),
(10,"DescarriladorShimanoTourney",2139,5),
(11,"ShiftersShimanoTourney3x8",8685,5),
(12,"InfladorBulitserie600",7665,6),
(13,"BicicletaCannondaleTrail5",402777,7),
(14,"ManubrioMTBZoom",5490,8),
(15,"AsientoVeloRaceMTB",8490,10),
(16,"Cadenacementadac/candadoBULIT",6590,10);

--Addresses
INSERT INTO`tp_final_ayi`.`directions`(`id_direction`,`city`,`country`,`flat`,`number`,`location`,`street`,`postal_code`,`client_fk`)VALUES
(1,"Castelar","Argentina",NULL,"938","BuenosAires","BuenosAires","B1712",1),
(2,"Castelar","Argentina",NULL,"3095","BuenosAires","DiegoAraoz","B1712",1),
(3,"Ciudadela","Argentina",8,"121","BuenosAires","PadreElizalde","B1701",2),
(4,"Rosario","Argentina",NULL,"125","SantaFé","Zapiola","S2000",3),
(5,"Rosario","Argentina",NULL,"8845","SantaFé","ManuelPrudan","S2001",3),
(6,"SanRafael","Argentina",NULL,"2548","Mendoza","SanMartín","M5600",4),
(7,"Mendoza","Argentina",NULL,"548","Mendoza","Ocampo","M5500",4),
(8,"LasToscas","Argentina",NULL,"22","SantaFé","Belgrano","15200",5),
(9,"CórdobaCapital","Argentina",NULL,"8541","Córdoba","Av.Libertador","B5000",6),
(10,"CórdobaCapital","Argentina",NULL,"552","Córdoba","Etchegaray","B5002",6),
(11,"AltaGracia","Argentina",NULL,"369","Córdoba","Olazabal","X5186",7),
(12,"Paraná","Argentina",5,"226","EntreRíos","Juncal","E3100",8),
(13,"Calafate","Argentina",NULL,"5961","SantaCruz","MartínFierro","Z9405",9),
(14,"PuertoPirámides","Argentina",NULL,"778","Chubut","1006","U9121",10);
