1)

create user BD_Fournisseur identified by 123 ;
grant all privileges to BD_Fournisseur;

"TO_NUMBER(:PRIXUNITHT, '999999D999','NLS_NUMERIC_CHARACTERS=''.,''')"
DATE "DD/MM/YYYY HH24:MI:SS"

ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';
Produit_F(reference, designation, marque)
create table Produit_F(
     reference varchar2(50) NOT NULL, 
	 designation varchar2(50),
	 marque varchar2(50),
	 primary key(reference)
);

Fournisseur_F(code, raison_sociale, Numero, voie, code_postal, ville, telephone)
create table Fournisseur_F(
     code varchar2(50) NOT NULL, 
	 raison_sociale varchar2(50),
	 Numero integer,
	 voie varchar2(50),
	 code_postal integer,
	 ville varchar2(50),
	 telephone integer
	,primary key(code)
);

Fournir_F (*CodeF, *refProd, datef, quantite, prixunitHT)
drop table Fournir_F;
create table Fournir_F(
   CodeF varchar2(50) NOT NULL, 
	 refProd varchar2(50),
	 dateF date,
	 quantite integer,
	 prixunitHT NUMBER(6,3)
	,primary key(dateF)
	,foreign key(CodeF) references Fournisseur_F(code)
	,foreign key(refProd) references Produit_F(reference)
);


sqlldr BD_Fournisseur/123 control=F_Produit.ctl
sqlldr BD_Fournisseur/123 control=F_Fournisseur.ctl
sqlldr BD_Fournisseur/123 control=F_Fournir.ctl

l’axe Fournisseur_ED regroupant la raison sociale et le numéro de département.

3)
drop table Fournisseur_ED;
create table Fournisseur_ED (
     code varchar2(50) NOT NULL, 
	 raison_sociale varchar2(50),
	 Numero_departement integer,
	 primary key(code)
);
2)
Plus précisément, pour chaque achat de produit auprès d’un fournisseur, nous souhaitons disposer du critère d’analyse qui est la quantité de produits achetée. Ainsi, l’analyse s’effectuera au travers des axes Produit_ED et Temps_ED déjà présents dans l’entrepôt 

drop table Achat_ED;
create table Achat_ED(
     CodeF varchar2(50),
	 refProd varchar2(50),
	 dateF date,
	 quantite integer
	,foreign key(CodeF) references Fournisseur_ED(code)
	,foreign key(refProd) references Produit_ED(Ref_prod)
	,foreign key(dateF) references Temps_ED(DateFacture)
);


4)
insert into Temps_ED
select distinct(dateF) as DateFacture ,ltrim(TO_CHAR( dateF,'mm-yyyy'),'0') as Mois ,extract(year from dateF) as annee
from BD_Fournisseur.Fournir_F
where dateF not in( select DateFacture from Temps_ED)
;
select * from Temps_ED;


5) Alimenter les tables Fournisseur_ED et Achat_ED

insert into Fournisseur_ED select code,raison_sociale,Numero from BD_Fournisseur.Fournisseur_F;
select * from Fournisseur_ED;


insert into Achat_ED
select CodeF,refProd,dateF,quantite
from BD_Fournisseur.Fournir_F;
select * from Achat_ED;


6)  Afficher la quantité totale achetée auprès de chaque département de fournisseurs chaque année.
select sum(quantite),Numero_departement,annee
from Achat_ED ,Temps_ED,Fournisseur_ED
where Achat_ED.CodeF=Fournisseur_ED.code and Achat_ED.dateF=Temps_ED.DateFacture
group by Fournisseur_ED.Numero_departement,Temps_ED.annee;


