CREATE VIEW `inicioSesion_detalle` AS 
SELECT * FROM servicio_social.iniciosesion 
inner join estudiante using (idinicioSesion);