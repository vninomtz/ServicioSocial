CREATE VIEW estudiante_detalles AS select * from estudiante e inner join inscripcion  i using (idestudiante)
inner join serviciosocial using (idserviciosocial)
inner join seguimiento using (idseguimiento)
inner join iniciosesion using (idiniciosesion);