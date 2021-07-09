-- INSERTAR DATOS

INSERT INTO tipo_personal (descripcion) VALUES ('Administrador del sistema');
INSERT INTO tipo_personal (descripcion) VALUES ('Secretaria');

INSERT INTO personal VALUES ('9823548', 'Alfredo Gonzales', 'F', 'Camiri ...#', '9780985', '1');

INSERT INTO usuario (nombre_usuario, contrasena, ci_personal) VALUES ('alfreding0', md5('1234'), '9823548');

SELECT * FROM PERSONAL;

SELECT * FROM USUARIO;

SELECT md5('1234');