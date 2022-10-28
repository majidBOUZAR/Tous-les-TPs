1)
create user BD_ED identified by 123 ;
grant all privileges to BD_ED;


drop table Produit_ED;
create table Produit_ED(
     Ref_prod varchar2(50) NOT NULL, 
	 designation varchar2(50),
	 marque varchar2(50), 
	 categories varchar2(50), 
	 secteur varchar2(50), 
	 tauxTVA NUMBER(6,3),
	 primary key(Ref_prod)
)

insert into Produit_ED
select ref_prod,designation,marque,categorie as categories,secteur,tauxtva as tauxTVA
from BD_Clients.produit_c;
select * from Produit_ED;


drop table Client_ED;
create table Client_ED(
     IdC integer NOT NULL, 
	 nom varchar2(50), 
	 prenom varchar2(50), 
	 ville varchar2(50), 
	 departement varchar2(50), 
	 region varchar2(50),
	 primary key(IdC)
)
	 
insert into Client_ED
select a.idc,a.nom,a.prenom,v.nom,d.nom,r.nomregion
from BD_Clients.Client_C a,BD_Clients.coordonnees_c c,BD_Geographie.ville_g v,BD_Geographie.departement_g d,BD_Geographie.region_g r
where a.id_adr=c.id_adr 
and c.ville=v.nom
and v.iddept=d.numerodept
and d.numregion=r.idregion;
select * from Client_ED;


drop table Temps_ED;
create table Temps_ED(
    DateFacture date NOT NULL,
    Mois varchar2(50),
    annee integer,
	primary key(DateFacture)
	)
insert into Temps_ED
select distinct(date_fact),ltrim(TO_CHAR( date_fact,'mm-yyyy'),'0'),extract(year from date_fact)
from BD_Clients.facture_c;
select * from Temps_ED;


drop table Vente_ED;
create table Vente_ED(
    Ref_Prod varchar2(50) NOT NULL,
    IdC integer, 
	DattFact DATE, 
	quantite integer, 
	montant NUMBER(6,3),
	foreign key(Ref_Prod) references Produit_ED(Ref_Prod),
	foreign key(IdC) references Client_ED(IdC),
	foreign key(DattFact) references Temps_ED(DateFacture)
)

insert into VENTE_ED(
select Produit.ref_prod,Facture.idC, Facture.date_fact,  Referencer.QUANTITE,
Referencer.remise+Referencer.quantite*Produit.prixunitht*(1+Produit.tauxtva) as montant
FROM BD_Clients.produit_c Produit, BD_Clients.facture_c Facture, BD_Clients.Referencer_C Referencer
WHERE Referencer.NUM_FACT=Facture.numero and Referencer.ref_prod=Produit.ref_prod);


select * from VENTE_ED;