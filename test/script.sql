create sequence sqlook;
create sequence sqtype;
create sequence sqdimension;
create sequence squnite;
create sequence sqmatiere_premiere;
create sequence sqmatiere_look;

create table look(
    idlook varchar(15) primary key,
    libelle varchar(15)
);

create table type(
    idtype varchar(15) primary key,
    libelle varchar(20)
);

create table dimension(
    iddimension varchar(20) primary key,
    libelle varchar(10)
);

create table unite(
    idunite varchar(15) primary key,
    libelle varchar(10)
);

create table matiere_premiere(
    idmatiere_premiere varchar(25) primary key,
    idunite varchar(15),
    libelle varchar(20),
    foreign key (idunite) references unite(idunite)
);

create table matiere_look(
    idmatiere_look varchar(20) primary key,
    idmatiere_premiere varchar(25),
    idlook varchar(15),
    foreign key (idmatiere_premiere) references matiere_premiere(idmatiere_premiere),
    foreign key (idlook) references look(idlook)
);

create table model(
    idmodel varchar(15) primary key,
    iddimension varchar(20),
    idlook varchar(15),
    idtype varchar(15),
    libelle varchar(50),
    foreign key (idlook) references look(idlook),
    foreign key (idtype) references type(idtype),
    foreign key (iddimension) references dimension(iddimension)
);

create sequence sqmodel;
create sequence sqquantite_model;

create table quantite_model(
    idquantite_model varchar(25) primary key,
    idmodel varchar(15),
    idmatiere_premiere varchar(25),
    quantite double precision,
    foreign key (idmodel) references model(idmodel),
    foreign key (idmatiere_premiere) references matiere_premiere(idmatiere_premiere)
);

create table prix_matiere(
    idprix_matiere varchar(25) primary key,
    idmatiere_premiere varchar(25), 
    prix double precision,
    foreign key (idmatiere_premiere) references matiere_premiere(idmatiere_premiere)
);
create sequence sqprix_matiere;

create view v_prix as (
    select m.idmodel,m.libelle,sum(quantite*prix) as prix 
    from quantite_model as qm 
    join prix_matiere as pm on qm.idmatiere_premiere=pm.idmatiere_premiere 
    join model as m on m.idmodel=qm.idmodel
    group by m.idmodel,m.libelle
);

 alter table prix_matiere add date timestamp;

create table fournisseur(
    idfournisseur varchar(25) primary key,
    libelle varchar(20)
);

create table achat_matiere(
    idachat_matiere varchar(25) primary key,
    idmatiere_premiere varchar(25),
    quantite double precision,
    dateheure timestamp,
    foreign key (idmatiere_premiere) references matiere_premiere(idmatiere_premiere)
);

create table fabrication(
    idfabrication varchar(25) primary key,
    idmodel varchar(20),
    quantite double precision,
    foreign key (idmodel) references model(idmodel)
);
create sequence sqfournisseur;
create sequence sqachat_matiere;
create sequence sqfabrication;


create or replace view niasa as (
 select idquantite_model,qm.idmodel,mp.idmatiere_premiere,libelle, sum(qm.quantite*f.quantite)as niasa
from quantite_model qm 
join fabrication f 
on qm.idmodel=f.idmodel 
join matiere_premiere mp 
on qm.idmatiere_premiere=mp.idmatiere_premiere
group by mp.idmatiere_premiere,idquantite_model,qm.idmodel);


create or replace view reste as (
    select am.idmatiere_premiere,libelle,(entree-niasa)as reste 
from mouvement am join niasa n 
on am.idmatiere_premiere=n.idmatiere_premiere 
group by am.idmatiere_premiere,libelle,reste
);

create or replace view reste as (
select am.idmatiere_premiere,libelle,(sum(entree)-sum(sortie))as reste from mouvement am join matiere_premiere n on am.idmatiere_premiere=n.idmatiere_premiere group by am.idmatiere_premiere,libelle
);


create view verify as(
    select idmodel,libelle,reste,quantite from quantite_model qm join reste r on r.idmatiere_premiere=qm.idmatiere_premiere
);


create table mouvement(
    idmouvement varchar(25) primary key,
    idmatiere_premiere varchar(25),
    entree double precision,
    sortie double precision,
    dateheure timestamp,
    foreign key (idmatiere_premiere) references matiere_premiere(idmatiere_premiere)
);
create sequence sqmouvement;


create table metier(
    idmetier varchar(20) primary key,
    libelle varchar(20)
);

create table salaire_metier(
    idsalaire_metier varchar(25) primary key,
    idmetier varchar(20),
    taux_horaire double precision,
    foreign key (idmetier) references metier(idmetier)
);

create table nombre_taille(
    idnombre_taille varchar(25) primary key,
    idtaille varchar(15),
    nombre int,
    foreign key (idtaille) references dimension(iddimension)
);

create table taux_look(
    idtaux_look varchar(25) primary key,
    idlook varchar(15),
    taux double precision,
    foreign key (idlook) references look(idlook)
);


create table metier_model(
    idmetier_model varchar(25) primary key,
    idmodel varchar(15),
    idmetier varchar(20),
    nombre int,
    foreign key (idmetier) references metier(idmetier),
    foreign key (idmodel) references model(idmodel)
);

create table prix_vente(
    idprix_vente varchar(25) primary key,
    idmodel varchar(20),
    prix_vente double precision,
    foreign key (idmodel) references model(idmodel)
);

create sequence sqprix_vente;
create sequence sqmetier;
create sequence sqsalaire_metier;
create sequence sqnombre_taille;
create sequence sqtaux_look;
create sequence sqnombre_model;
create sequence sqmetier_model;

create or replace view prix_ouvrier as(
select mm.idmodel,m.libelle ,sum(taux*taux_horaire) as prix_olona 
from metier_model mm 
join model m on mm.idmodel=m.idmodel 
join taux_look tl on m.idlook=tl.idlook 
join salaire_metier sm on sm.idmetier=mm.idmetier 
group by mm.idmodel,m.libelle 
);

create view prix_premiere as ( 
    select idmodel,sum(prix*quantite) 
    from quantite_model as qm 
    join prix_matiere as pm on qm.idmatiere_premiere=pm.idmatiere_premiere 
    group by idmodel
);

create view prix_revient as(
    select po.libelle,pp.idmodel,(pp.sum+po.sum) as somme 
    from prix_ouvrier po 
    join prix_premiere pp 
    on po.idmodel=pp.idmodel 
    group by po.libelle,pp.idmodel,somme
);

create view benefice as (
    select pr.libelle,somme as prix_revient,prix_vente,(prix_vente-somme) as benefice from prix_revient pr join prix_vente pv 
    on pr.idmodel=pv.idmodel
    group by pr.libelle, pr.idmodel,prix_revient,prix_vente,benefice
);

select vu.*,nomb.nombre 
from nombre_taille as nomb 
join
(select m.idmodel,m.iddimension,sum(mm.nombre)
from metier_model as mm 
join model as m on m.idmodel=mm.idmodel 
join nombre_taille as nt on nt.idtaille=m.iddimension 
group by m.idmodel,iddimension
) as vu
on nomb.idtaille=vu.iddimension;


create or replace view v_exceptionPersonnel as (
select vu.idmodel,vu.nombre,nomb.nombre as nombre_limite
from nombre_taille as nomb
join
(select m.idmodel,iddimension,sum(mm.nombre) as nombre
from metier_model as mm 
join model as m on m.idmodel=mm.idmodel 
join nombre_taille as nt on nt.idtaille=iddimension
group by m.idmodel,iddimension) as vu
on nomb.idtaille=vu.iddimension);


create table personne(
    idpersonne varchar(20) primary key,
    nompersonne varchar(25),
    dtn timestamp,
    adresse varchar(25),
    sexe varchar(10)
);


create table profil(
    idprofil varchar(20)primary key,
    libelle varchar(20)
);


create table embauche(
    idembauche varchar(25)primary key,
    idpersonne varchar(20),
    idprofil varchar(20),
    dateembauche timestamp,
    foreign key(idprofil) references profil(idprofil),
    foreign key(idpersonne) references personne(idpersonne)
);

create table experience(
    idexperience varchar(25) primary key,
    idprofil varchar(20),
    annee1 int,
    annee2 int,
    foreign key(idprofil) references profil(idprofil)
);
create table standard(
    idstandard varchar(25) primary key,
    idprofil varchar(20),
    taux_horaire double precision,
    foreign key(idprofil) references profil(idprofil)
);

create table non_standard(
    idnon_standard varchar(30) primary key,
    idprofil varchar(20),
    coefficient double precision,
    foreign key(idprofil) references profil(idprofil)
);

create sequence sqpersonne;
create sequence sqprofil;
create sequence sqembauche;
create sequence sqexperience;
create sequence sqstandard;
create sequence sqnon_standard;


create or replace view v_niasana as (
SELECT e.idpersonne, 
       FLOOR(EXTRACT(EPOCH FROM age(current_date, e.dateembauche))/60/60/24/30.44/12) + ex.annee1 as annee
FROM embauche e
JOIN experience ex ON e.idprofil = ex.idprofil);


create or replace view v_profil_personne as (
select * from v_niasana as v
join experience as e 
on v.annee>=annee1 and v.annee<annee2 );


create view v_standard as (
select s.idprofil,s.taux_horaire from standard s
join (
select max(idStandard) as idStandard from standard s
) vu on s.idStandard = vu.idStandard 
);

create view v_profil as (
select per.nompersonne as nom,pr.idprofil ,pr.libelle as profil,(v.taux_horaire * c.coefficient) as taux from v_profil_personne p
cross join v_standard v
join non_standard c on c.idprofil = p.idprofil
join profil pr on pr.idprofil = c.idprofil
join personne per on per.idpersonne = p.idpersonne
);

create table vente(
    idvente varchar(15) primary key,
    idpersonne varchar(25),
    idmodel varchar(20),
    nombre int,
    date timestamp,
    foreign key(idpersonne) references personne(idpersonne),
    foreign key(idmodel) references model(idmodel)
);
create sequence sqvente;

create table genre(
    idgenre varchar(20) primary key,
    valeur varchar(10),
    libelle varchar(15)
);

insert into genre values('Genre000001','m','masculin');
insert into genre values('Genre000002','f','feminin');


create view v_profil as (
select per.nompersonne as nom,pr.idprofil ,pr.libelle as profil,(v.taux_horaire * c.coefficient) as taux from v_profil_personne p
cross join v_standard v
join non_standard c on c.idprofil = p.idprofil
join profil pr on pr.idprofil = c.idprofil
join personne per on per.idpersonne = p.idpersonne
);



create view v_vente as (
select vu.idmodel,vu.sexe,sum(vu.nombre) as nombre from 
(
select r.idmodel,g.valeur as sexe ,case when p.sexe is null then 0 else r.nombre end as nombre from vente r
cross join genre g
left join personne p on r.idpersonne = p.idpersonne and g.valeur = p.sexe
) vu
 group by vu.idmodel,vu.sexe
);


create view vcross as (
select v.idmodel,g.valeur from model v
cross join genre g
);

create or replace view statistique as (
select v.idmodel,g.libelle as sexe,case when r.idmodel is null then 0 else r.nombre end as nombre  from vcross v
left join v_vente r 
on r.idmodel = v.idmodel and v.valeur = r.sexe
join genre g on g.valeur = v.valeur
);

create view tous as (
    select sexe,sum(nombre) as nombre from statistique
    group by sexe
);

create view v_matiere_look as (
    select idlook,mp.idmatiere_premiere,libelle 
    from matiere_look ml 
    join matiere_premiere mp 
    on ml.idmatiere_premiere=mp.idmatiere_premiere
);

create view v_matiere_model as (
    select qm.idmatiere_premiere,qm.idModel,libelle,quantite 
    from quantite_model qm 
    join model m 
    on qm.idmodel=m.idmodel
);