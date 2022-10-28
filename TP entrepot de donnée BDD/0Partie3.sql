1)
select max(quantite), VENTE_ED.REF_PROD,TEMPS_ED.MOIS
from VENTE_ED , PRODUIT_ED,TEMPS_ED
where VENTE_ED.REF_PROD=PRODUIT_ED.REF_PROD and TEMPS_ED.DATEFACTURE=VENTE_ED.DATTFACT
group by produit_ed.REF_PROD,temps_ed.MOIS ;

select min(quantite), VENTE_ED.REF_PROD,TEMPS_ED.MOIS
from VENTE_ED , PRODUIT_ED,TEMPS_ED
where VENTE_ED.REF_PROD=PRODUIT_ED.REF_PROD and TEMPS_ED.DATEFACTURE=VENTE_ED.DATTFACT
group by produit_ed.REF_PROD,temps_ed.MOIS ;

2)

select  Client_ED.departement,PRODUIT_ED.CATEGORIES,sum(quantite)
from    Client_ED,VENTE_ED,PRODUIT_ED
where   Client_ED.IdC=VENTE_ED.IdC
and     VENTE_ED.ref_prod=PRODUIT_ED.ref_prod
group by Client_ED.departement,PRODUIT_ED.CATEGORIES;

3)
select t1.IDC ,t1.NOM,t1.PRENOM,t1.montant 
from 
(select  Client_ED.IDC as idc,Client_ED.NOM as nom,Client_ED.PRENOM as PRENOM,sum(montant) as montant
from    Client_ED,VENTE_ED
where   Client_ED.IdC=VENTE_ED.IdC
group by Client_ED.IDC,Client_ED.NOM,Client_ED.PRENOM)  t1, 
(select  max(sum(montant)) as  montant
from    Client_ED,VENTE_ED
where   Client_ED.IdC=VENTE_ED.IdC
group by Client_ED.IDC) t2 
where t1.montant=t2.montant;

4)
select  Client_ED.IDC as idc,Client_ED.NOM as nom,Client_ED.PRENOM as PRENOM,count(distinct(PRODUIT_ED.marque)) as nbr_marque
from    Client_ED,VENTE_ED ,PRODUIT_ED
where   Client_ED.IdC=VENTE_ED.IdC 
and PRODUIT_ED.Ref_Prod=VENTE_ED.Ref_Prod
group by Client_ED.IDC,Client_ED.NOM,Client_ED.PRENOM;

5)
select Client_ED.idc,Client_ED.NOM,Client_ED.PRENOM from Client_ED where Client_ED.idc in (
select distinct x.IdC 
from VENTE_ED x 
where  not exists (
	    select y.IdC,z.Ref_Prod from VENTE_ED y,Produit_ED z where y.Ref_prod=z.Ref_prod and not exists(
		select a.IdC,b.Ref_Prod from VENTE_ED a,Produit_ED b where (a.IdC=x.IdC) and (b.Ref_Prod=z.Ref_Prod) and(a.Ref_prod=b.Ref_prod)
	)
)
)
;


