1)Créer les comptes utilisateurs BD_Client et BD_Geographie.

create user BD_Clients identified by 123 ;
grant all privileges to BD_Clients;
create user BD_Geographie identified by 123 ;
grant all privileges to BD_Geographie;

***************************************************************************************************************
2)Créer les tables des deux BDs

connect BD_Clients/123;
select * from TAB;
drop table coordonnees_c;
create table coordonnees_c(
    id_adr integer NOT NULL,
    numero integer,
    voie varchar2(50),
    cp integer,
    ville varchar2(50),
    telephone integer,
    primary key(id_adr)
);
select TO_NUMBER('94567 cb', '9999999GC', 'NLS_NUMERIC_CHARACTERS ='', ''') n FROM dual;


SELECT TO_NUMBER('11 bis','999GL', ' NLS_CURRENCY= ''bis'' ') "Amount" FROM DUAL;




drop table paiment_c;
create table paiment_c(
    typep integer NOT NULL,
    titre varchar2(50),
    organisme varchar2(50),
    primary key(typep)
);

drop table produit_c;
create table produit_c(
    ref_prod varchar2(50) NOT NULL,
    designation varchar2(50),
    marque varchar2(50),
    prixunitht NUMBER(6,3),
    tauxtva NUMBER(6,3),
    categorie varchar2(50),
    secteur varchar2(50),
    primary key(ref_prod)
);

drop table Client_C;
create table Client_C(
    idC integer NOT NULL,
    nom varchar2(50),
    prenom varchar2(50),
    sexe varchar2(50),
    id_ADR integer NOT NULL,
    primary key(idc),
    foreign key(id_adr) references coordonnees_c(id_adr)
);

drop table facture_c;
create table facture_c(
    numero integer NOT NULL,
    date_fact date,
    date_echeance date,
    reglee integer,
    idc integer NOT NULL,
    type_paiment integer NOT NULL,
    primary key(numero),
    foreign key(type_paiment) references paiment_c(typep),
    foreign key(idc) references client_c(idc)
);

drop table referencer_c;
create table referencer_c(
    num_fact integer NOT NULL,
    ref_prod varchar2(50) NOT NULL,
    quantite integer,
    remise NUMBER(6,3),
    foreign key(num_fact)references facture_c(numero),
    foreign key(ref_prod) references produit_c(ref_prod) 
);

------------------------------------------------------------------------
connect BD_Geographie/123;
select * from TAB;

drop table region_g;
create table region_g(
    idregion integer NOT NULL,
    nomregion varchar2(50),
    primary key(idregion)
); 

drop table departement_g;
create table departement_g(
    numerodept integer NOT NULL,
    nom varchar2(50),
    numregion integer NOT NULL,
    primary key(numerodept),
	foreign key(numregion) references region_g(idregion)
);

drop table ville_g;
create table ville_g(
    idville integer NOT NULL,
    nom varchar2(50),
    iddept integer NOT NULL,
    primary key(idville),
    foreign key(iddept) references departement_g(numerodept)
);

drop table codepostal_g;
create table codepostal_g(
    cp integer NOT NULL,
    idville integer NOT NULL,
    primary key(cp),
    foreign key(idville) references ville_g(idville)
);
************************************************************************************************************
3)Alimenter les deux BDs sources à partir des fichiers de données.
sqlldr BD_Clients/123 control=c_coordonnees.ctl
sqlldr BD_Clients/123 control=c_paiment.ctl
sqlldr BD_Clients/123 control=c_produit.ctl
sqlldr BD_Clients/123 control=c_Client1.ctl  sqlldr BD_Clients/123 control=c_Client2.ctl
sqlldr BD_Clients/123 control=c_facture.ctl
sqlldr BD_Clients/123 control=c_referencer.ctl

sqlldr BD_Geographie/123 control=g_region.ctl
sqlldr BD_Geographie/123 control=g_departement.ctl
sqlldr BD_Geographie/123 control=g_ville.ctl
sqlldr BD_Geographie/123 control=g_codepostal.ctl

***********************************************************************************************************
4)Vérifier que les deux BDs sources ont été bien alimentées.
BD_Clients:
select * from coordonnees_c;
select * from paiment_c;
select * from produit_c;
select * from Client_C;
select * from facture_c;
select * from referencer_c;

BD_Geographie:
select * from region_g;
select * from departement_g;
select * from ville_g;
select * from codepostal_g;