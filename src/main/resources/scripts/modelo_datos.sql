/*CREACCION DE USUARIO*/
CREATE USER SISTEMA_MATRICULA IDENTIFIED BY PRUEBA$1;

GRANT CONNECT,RESOURCE TO SISTEMA_MATRICULA;

GRANT
    UNLIMITED TABLESPACE
TO SISTEMA_MATRICULA;

GRANT
    CREATE VIEW,
    CREATE MATERIALIZED VIEW
TO SISTEMA_MATRICULA;

CREATE TABLESPACE TS_SISTEMA_MATRICULA DATAFILE
    'c:\app\tablespaces\ts_sistema_matricula_data.ora' SIZE 200 M
EXTENT MANAGEMENT LOCAL AUTOALLOCATE;

CREATE TABLE DISTRITO(
    COD_DISTRITO NUMBER(2) NOT NULL,
    NOM_DISTRITO VARCHAR(25) NOT NULL,
    CONSTRAINT PK_DISTRITO
        PRIMARY KEY(COD_DISTRITO)
);

CREATE SEQUENCE SEQ_APODERADO_COD_APODERADO_1;

CREATE TABLE APODERADO (
    COD_APODERADO   NUMBER(3) NOT NULL,
    NOMBRE_AP       VARCHAR2(30) NOT NULL,
    APATERNO_AP     VARCHAR2(30) NOT NULL,
    AMATERNO_AP     VARCHAR2(30) NOT NULL,
    DNI_AP          CHAR(8) NOT NULL,
    EMAIL_AP        VARCHAR2(50) NOT NULL,
    TELEFONO_AP     VARCHAR2(9) NOT NULL,
    OCUPACIN        VARCHAR2(30) NOT NULL,
    COD_DISTRITO NUMBER(2) NOT NULL,
    CONSTRAINT PK_APODERADO PRIMARY KEY ( COD_APODERADO )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE INDEX IDX_DNI_APODERADO ON
    APODERADO ( DNI_AP );

CREATE SEQUENCE GRADO_COD_GRADO_SEQ;

CREATE TABLE GRADO (
    COD_GRADO      NUMBER(3) NOT NULL,
    NOMBRE_GRADO   VARCHAR2(10) NOT NULL,
    NIVEL          NUMBER(1) NOT NULL,
    CONSTRAINT PK_GRADO PRIMARY KEY ( COD_GRADO )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE SEQUENCE SEQ_SECCION_COD_SECCION;

CREATE TABLE SECCION (
    COD_SECCION      NUMBER(1) NOT NULL,
    COD_GRADO        NUMBER(3) NOT NULL,
    NOMBRE_SECCION   VARCHAR2(10) NOT NULL,
    NRO_VACANTES     NUMBER(2) NOT NULL,
    NRO_SALON        NUMBER(30) NOT NULL,
    CONSTRAINT PK_SECCION PRIMARY KEY ( COD_SECCION,COD_GRADO )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE SEQUENCE USUARIO_COD_USUARIO_SEQ;

CREATE TABLE USUARIO (
    COD_USUARIO        NUMBER(2) NOT NULL,
    APATERNO_USUARIO   VARCHAR2(30) NOT NULL,
    NOMBRE             VARCHAR2(30) NOT NULL,
    AMATERNO_USUARIO   VARCHAR2(30) NOT NULL,
    DNI_USUARIO        CHAR(8) NOT NULL,
    TELF_USUARIO       CHAR(9) NOT NULL,
    USERNAME           VARCHAR2(15) NOT NULL,
    PASSWORD           VARCHAR2(15) NOT NULL,
    CONSTRAINT PK_USUARIO PRIMARY KEY ( COD_USUARIO )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE UNIQUE INDEX IDX_DNI_USUARIO ON
    USUARIO ( DNI_USUARIO );

CREATE UNIQUE INDEX IDX_TELF_USUARIO ON
    USUARIO ( TELF_USUARIO );

CREATE UNIQUE INDEX IDX_USERNAME ON
    USUARIO ( USERNAME );

CREATE UNIQUE INDEX IDX_PASSWORD ON
    USUARIO ( PASSWORD );

CREATE TABLE DOCUMENTOS (
    COD_DOCUMENTO       NUMBER(2) NOT NULL,
    DESCRIPCION_DOC     VARCHAR2(50) NOT NULL,
    GRADO_IMPORTANCIA   NUMBER(2) NOT NULL,
    CONSTRAINT PK_DOCUMENTOS PRIMARY KEY ( COD_DOCUMENTO )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE SEQUENCE SEQ_CODIGO_ALUMNO;

CREATE TABLE ALUMNOS (
    COD_ALU         NUMBER(4) NOT NULL,
    APATERNO_ALU    VARCHAR2(30) NOT NULL,
    NOMBRE_ALU      VARCHAR2(30) NOT NULL,
    AMATERNO_ALU    VARCHAR2(30) NOT NULL,
    TELEFONO_ALU    VARCHAR2(9) NOT NULL,
    EMAIL_ALU       VARCHAR2(50),
    DIRECCION_ALU   VARCHAR2(100) NOT NULL,
    COD_APODERADO   NUMBER(3),
    CONSTRAINT PK_ALUMNOS PRIMARY KEY ( COD_ALU )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE TABLE MATRICULA (
    COD_SECCION         NUMBER(1) NOT NULL,
    COD_GRADO           NUMBER(3) NOT NULL,
    COD_ALU             NUMBER(4) NOT NULL,
    COD_MATRICULA       CHAR(8) NOT NULL,
    FECHA_EJECUCUCION   TIMESTAMP NOT NULL,
    CONSTRAINT PK_MATRICULA PRIMARY KEY ( COD_SECCION,COD_GRADO,COD_ALU )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE TABLE COMPROBANTE_PAGO (
    NRO_COMPROBANTE   CHAR(7) NOT NULL,
    MONTO             NUMBER(4,2) NOT NULL,
    FECHA_EMISION     TIMESTAMP NOT NULL,
    COD_SECCION       NUMBER(1) NOT NULL,
    COD_GRADO         NUMBER(3) NOT NULL,
    COD_ALU           NUMBER(4) NOT NULL,
    CONSTRAINT PK_COMPROBANTE_PAGO PRIMARY KEY ( NRO_COMPROBANTE )
) TABLESPACE TS_SISTEMA_MATRICULA;

CREATE TABLE ACTA_COMPROMISO (
    COD_DOCUMENTO   NUMBER(2) NOT NULL,
    COD_ALU         NUMBER(4) NOT NULL,
    FECHA_ENTREGA   DATE NOT NULL,
    COD_USUARIO     NUMBER(2),
    ESTADO          NUMBER(1) NOT NULL,
    CONSTRAINT PK_ACTA_COMPROMISO PRIMARY KEY ( COD_DOCUMENTO,COD_ALU )
) TABLESPACE TS_SISTEMA_MATRICULA;

ALTER TABLE ALUMNOS ADD CONSTRAINT APODERADO_ALUMNOS_FK FOREIGN KEY ( COD_APODERADO )
    REFERENCES APODERADO ( COD_APODERADO )
        ON DELETE SET NULL
NOT DEFERRABLE;

ALTER TABLE SECCION ADD CONSTRAINT GRADO_SECCION_FK FOREIGN KEY ( COD_GRADO )
    REFERENCES GRADO ( COD_GRADO )
        ON DELETE CASCADE
NOT DEFERRABLE;

ALTER TABLE MATRICULA ADD CONSTRAINT SECCION_MATRICULA_FK FOREIGN KEY ( COD_GRADO,COD_SECCION )
    REFERENCES SECCION ( COD_GRADO,COD_SECCION )
        ON DELETE CASCADE
NOT DEFERRABLE;

ALTER TABLE ACTA_COMPROMISO ADD CONSTRAINT FK_USUARIO_ACTA_COMPROMISO FOREIGN KEY ( COD_USUARIO )
    REFERENCES USUARIO ( COD_USUARIO )
        ON DELETE SET NULL
NOT DEFERRABLE;

ALTER TABLE ACTA_COMPROMISO ADD CONSTRAINT DOCUMENTOS_ACTA_COMPROMISO_FK FOREIGN KEY ( COD_DOCUMENTO )
    REFERENCES DOCUMENTOS ( COD_DOCUMENTO )
        ON DELETE CASCADE
NOT DEFERRABLE;

ALTER TABLE ACTA_COMPROMISO ADD CONSTRAINT ALUMNOS_ACTA_COMPROMISO_FK FOREIGN KEY ( COD_ALU )
    REFERENCES ALUMNOS ( COD_ALU )
        ON DELETE CASCADE
NOT DEFERRABLE;

ALTER TABLE MATRICULA ADD CONSTRAINT ALUMNOS_MATRICULA_FK FOREIGN KEY ( COD_ALU )
    REFERENCES ALUMNOS ( COD_ALU )
NOT DEFERRABLE;

ALTER TABLE COMPROBANTE_PAGO ADD CONSTRAINT MATRICULA_COMPROBANTE_PAGO_FK FOREIGN KEY ( COD_SECCION,COD_GRADO,COD_ALU )
    REFERENCES MATRICULA ( COD_SECCION,COD_GRADO,COD_ALU )
NOT DEFERRABLE;

ALTER TABLE ALUMNOS
    ADD CONSTRAINT FK_ALUMNOS_DISTRITO
    FOREIGN KEY(COD_DISTRITO)
    REFERENCES DISTRITO
        ON DELETE CASCADE;
-- Secuencia de DROP

DROP TABLE COMPROBANTE_PAGO;
DROP TABLE ACTA_COMPROMISO;
DROP TABLE MATRICULA;
DROP TABLE ALUMNOS;
DROP TABLE SECCION;
DROP TABLE GRADO;
DROP TABLE APODERADO;
DROP TABLE DOCUMENTOS;
DROP TABLE USUARIO;
DROP TABLE DISTRITO;



INSERT INTO distrito VALUES(1,'Cercado de Lima');
INSERT INTO distrito VALUES(2,'Ate');
INSERT INTO distrito VALUES(3,'Barranco');
INSERT INTO distrito VALUES(4,'Bre�a');
INSERT INTO distrito VALUES(5,'Comas');
INSERT INTO distrito VALUES(6,'Chorrillos');
INSERT INTO distrito VALUES(7,'El Agustino');
INSERT INTO distrito VALUES(8,'Jes�s Mar�a');
INSERT INTO distrito VALUES(9,'La Molina');
INSERT INTO distrito VALUES(10,'La Victoria');
INSERT INTO distrito VALUES(11,'Lince');
INSERT INTO distrito VALUES(12,'Magdalena del Mar');
INSERT INTO distrito VALUES(13,'Miraflores');
INSERT INTO distrito VALUES(14,'Pueblo Libre');
INSERT INTO distrito VALUES(15,'Puente Piedra');
INSERT INTO distrito VALUES(16,'Rimac');
INSERT INTO distrito VALUES(17,'San Isidro');
INSERT INTO distrito VALUES(18,'Independencia');
INSERT INTO distrito VALUES(19,'San Juan de Miraflores');
INSERT INTO distrito VALUES(20,'San Luis');
INSERT INTO distrito VALUES(21,'San Martin de Porres');
INSERT INTO distrito VALUES(22,'San Miguel');
INSERT INTO distrito VALUES(23,'Santiago de Surco');
INSERT INTO distrito VALUES(24,'Surquillo');
INSERT INTO distrito VALUES(25,'Villa Mar�a del Triunfo');
INSERT INTO distrito VALUES(26,'San Juan de Lurigancho');
INSERT INTO distrito VALUES(27,'Santa Rosa');
INSERT INTO distrito VALUES(28,'Los Olivos');
INSERT INTO distrito VALUES(29,'San Borja');
INSERT INTO distrito VALUES(30,'Villa El Salvador');
INSERT INTO distrito VALUES(31,'Santa Anita');
INSERT INTO distrito VALUES(32,'Anc�n');
INSERT INTO distrito VALUES(33,'Carabayllo');
INSERT INTO distrito VALUES(34,'Chosica');
INSERT INTO distrito VALUES(35,'Chacaclayo');
INSERT INTO distrito VALUES(36,'Cieneguilla');
