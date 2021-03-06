CREATE OR REPLACE PROCEDURE SP_LISTAR_APODERADOS(
    CUR_APODERADOS OUT SYS_REFCURSOR
) 
AS
BEGIN
    OPEN CUR_APODERADOS FOR
    SELECT
        COD_APODERADO,
        NOMBRE_AP,
        APATERNO_AP,
        AMATERNO_AP,
        DNI_AP,
        EMAIL_AP,
        TELEFONO_AP,
        OCUPACIN
    FROM APODERADO;
END;

CREATE OR REPLACE PROCEDURE SP_REGISTRAR_APODERADO(
    P_NOMBRE_AP VARCHAR2,
    P_APATERNO_AP VARCHAR2,
    P_AMATERNO_AP VARCHAR2,
    P_DNI_AP CHAR,
    P_EMAIL_AP VARCHAR2,
    P_TELEFONO_AP VARCHAR2,
    P_OCUPACIN VARCHAR2
) AS
BEGIN
    INSERT INTO APODERADO
    VALUES(
        SEQ_APODERADO_COD_APODERADO_1.NEXTVAL,
        P_NOMBRE_AP,
        P_APATERNO_AP,
        P_AMATERNO_AP,
        P_DNI_AP,
        P_EMAIL_AP,
        P_TELEFONO_AP,
        P_OCUPACIN
    );
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICAR_APODERADO(
    P_COD_APODERADO NUMBER,
    P_EMAIL_AP VARCHAR2,
    P_TELEFONO_AP VARCHAR2,
    P_OCUPACIN VARCHAR2
)
AS
BEGIN
    UPDATE APODERADO 
    SET 
        EMAIL_AP = P_EMAIL_AP,
        TELEFONO_AP = P_TELEFONO_AP,
        OCUPACIN = P_OCUPACIN
    WHERE
        COD_APODERADO = P_COD_APODERADO;
END;

CREATE OR REPLACE PROCEDURE SP_ELIMINAR_APODERADO(
    P_COD_APODERADO NUMBER
)
AS
BEGIN
    DELETE FROM APODERADO WHERE COD_APODERADO = P_COD_APODERADO;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_USUARIO(
    CURSOR_USUARIO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN CURSOR_USUARIO FOR 
    SELECT 
        COD_USUARIO,
        APATERNO_USUARIO,
        NOMBRE,
        AMATERNO_USUARIO,
        DNI_USUARIO,
        TELF_USUARIO,
        USERNAME,
        ROL
    FROM USUARIO;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_APODERADO(
    P_COD_APODERADO NUMBER,
    CUR_APODERADOS OUT SYS_REFCURSOR
) 
AS
BEGIN
    OPEN CUR_APODERADOS FOR
    SELECT
        COD_APODERADO,
        NOMBRE_AP,
        APATERNO_AP,
        AMATERNO_AP,
        DNI_AP,
        EMAIL_AP,
        TELEFONO_AP,
        OCUPACIN
    FROM APODERADO
    WHERE COD_APODERADO = P_COD_APODERADO;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_APODERADO_DNI(
    P_DNI_APODERADO NUMBER,
    CUR_APODERADOS OUT SYS_REFCURSOR
) 
AS
BEGIN
    OPEN CUR_APODERADOS FOR
    SELECT
        COD_APODERADO,
        NOMBRE_AP,
        APATERNO_AP,
        AMATERNO_AP,
        DNI_AP,
        EMAIL_AP,
        TELEFONO_AP,
        OCUPACIN
    FROM APODERADO
    WHERE DNI_AP = P_DNI_APODERADO;
END;

CREATE OR REPLACE PROCEDURE SP_REGISTRAR_USUARIO(
    P_APATERNO_USUARIO VARCHAR2,
    P_NOMBRE VARCHAR2,
    P_AMATERNO_USUARIO VARCHAR2,
    P_DNI_USUARIO CHAR,
    P_TELF_USUARIO CHAR,
    P_USERNAME VARCHAR2,
    P_PASSWORD VARCHAR2,
    P_ROL VARCHAR2
)
AS
BEGIN
    INSERT INTO USUARIO
    (
        COD_USUARIO,
        APATERNO_USUARIO,
        NOMBRE,
        AMATERNO_USUARIO,
        DNI_USUARIO,
        TELF_USUARIO,
        USERNAME,
        PASSWORD,
        ROL
    ) VALUES 
    (
        USUARIO_COD_USUARIO_SEQ.NEXTVAL,
        P_APATERNO_USUARIO,
        P_NOMBRE,
        P_AMATERNO_USUARIO,
        P_DNI_USUARIO,
        P_TELF_USUARIO,
        P_USERNAME,
        P_PASSWORD,
        P_ROL
    );
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICAR_USUARIO(
    P_COD_USUARIO NUMBER,
    P_TELF_USUARIO CHAR
)
AS
BEGIN
    UPDATE USUARIO
    SET
        TELF_USUARIO = P_TELF_USUARIO
    WHERE
        COD_USUARIO = P_COD_USUARIO;
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICAR_PASSWORD(
    P_COD_USUARIO NUMBER,
    OLD_PASSWORD VARCHAR2,
    NEW_PASSWORD VARCHAR2
)
as 
    O_PASS USUARIO.PASSWORD%TYPE;
BEGIN
    SELECT PASSWORD INTO O_PASS FROM USUARIO WHERE COD_USUARIO = P_COD_USUARIO;
    IF O_PASS = OLD_PASSWORD THEN
        UPDATE USUARIO
            SET PASSWORD = NEW_PASSWORD
        WHERE
            COD_USUARIO = P_COD_USUARIO;
    ELSE
        raise_application_error( -20001, 'Contrase�a proporcionada no coincide' );
    END IF;
END;

CREATE OR REPLACE PROCEDURE SP_ELIMINAR_USUARIO(
    P_COD_USUARIO NUMBER
)
AS
BEGIN
    DELETE FROM USUARIO WHERE COD_USUARIO = P_COD_USUARIO;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_USUARIO(
    P_COD_USUARIO NUMBER,
    E_USUARIO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN E_USUARIO FOR
     SELECT 
        COD_USUARIO,
        APATERNO_USUARIO,
        NOMBRE,
        AMATERNO_USUARIO,
        DNI_USUARIO,
        TELF_USUARIO,
        USERNAME
    FROM USUARIO
    WHERE COD_USUARIO = P_COD_USUARIO;
END;

CREATE OR REPLACE FUNCTION FN_VERIFICAR_USUARIO(
    P_USERNAME VARCHAR2,
    P_PASSWORD VARCHAR2
) RETURN NUMBER
AS
    AUTH NUMBER(1) := 0;
    VAL NUMBER(1);
BEGIN
    
    SELECT 
        COUNT(*)
    INTO VAL 
    FROM USUARIO 
    WHERE USERNAME = P_USERNAME
    AND PASSWORD = P_PASSWORD;
    
    IF VAL = 1 THEN
        SELECT 
           ROL
        INTO AUTH 
        FROM USUARIO 
        WHERE USERNAME = P_USERNAME
        AND PASSWORD = P_PASSWORD;
    END IF;
    
    RETURN AUTH;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_ACTAS(
    CUR_ACTAS OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN CUR_ACTAS FOR
    SELECT 
        COD_DOCUMENTO,
        COD_ALU,
        FECHA_ENTREGA,
        COD_USUARIO,
        ESTADO
    FROM
        ACTA_COMPROMISO;
END;

CREATE OR REPLACE PROCEDURE SP_REGISTRAR_ACTAS
(
    P_COD_DOCUMENTO NUMBER,
    P_COD_ALU NUMBER,
    P_FECHA_ENTREGA VARCHAR,
    P_COD_USUARIO VARCHAR,
    P_ESTADO NUMBER
)
AS
BEGIN
    INSERT INTO ACTA_COMPROMISO 
    VALUES(
        P_COD_DOCUMENTO,
        P_COD_ALU,
        P_FECHA_ENTREGA,
        P_COD_USUARIO,
        P_ESTADO
    );
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICAR_ACTA(
    P_COD_DOCUMENTO NUMBER,
    P_COD_ALU NUMBER,
    P_ESTADO NUMBER
)
AS
BEGIN
    UPDATE ACTA_COMPROMISO
    SET 
        ESTADO = P_ESTADO
    WHERE
        COD_DOCUMENTO = P_COD_DOCUMENTO AND
        COD_ALU = P_COD_ALU;
END;

CREATE OR REPLACE PROCEDURE SP_ELIMINAR_ACTA(
    P_COD_ALU NUMBER
)
AS
BEGIN
    DELETE FROM ACTA_COMPROMISO
    WHERE
        COD_ALU = P_COD_ALU;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_ACTA(
    P_COD_ALUMNO NUMBER,
    ACTA OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN ACTA FOR
    SELECT 
        *
    FROM ACTA_COMPROMISO
    WHERE COD_ALU = P_COD_ALUMNO;
END;

CREATE OR REPLACE FUNCTION SF_NRO_VACANTES(
    P_COD_SECCION NUMBER,
    P_COD_GRADO NUMBER
)
RETURN NUMBER
AS
    VACANTES SECCION.NRO_VACANTES%TYPE;
BEGIN
    SELECT COUNT(*) INTO VACANTES
    FROM MATRICULA
    WHERE COD_SECCION = P_COD_SECCION
    AND COD_GRADO = P_COD_GRADO;
    RETURN VACANTES;
END;

CREATE OR REPLACE FUNCTION SF_EJECUTAR_MATRICULA
(
    P_COD_SECCION NUMBER,
    P_COD_GRADO NUMBER,
    P_COD_ALU NUMBER
)

RETURN CHAR
AS
    G_COD_MATRICULA CHAR(8);
    L_COD NUMBER(1);
    COMPL ALUMNOS.APATERNO_ALU%TYPE;
    VACANTES SECCION.NRO_VACANTES%TYPE;
    VACANTES_SEC SECCION.NRO_VACANTES%TYPE;
BEGIN
    SELECT NRO_VACANTES INTO VACANTES_SEC 
    FROM SECCION
    WHERE COD_SECCION = P_COD_SECCION
    AND COD_GRADO = P_COD_GRADO;
    
    VACANTES := SF_NRO_VACANTES(P_COD_SECCION,P_COD_GRADO) + 1;
    
    IF VACANTES <= VACANTES_SEC THEN
        L_COD := 8 - LENGTH(P_COD_SECCION || P_COD_GRADO || P_COD_ALU);
    
        SELECT APATERNO_ALU INTO COMPL
        FROM ALUMNOS
        WHERE COD_ALU = P_COD_ALU;
    
        G_COD_MATRICULA := P_COD_SECCION || P_COD_GRADO || P_COD_ALU || SUBSTR(COMPL,1,L_COD);
        
        INSERT INTO MATRICULA
        (
            COD_SECCION,
            COD_GRADO,
            COD_ALU,
            COD_MATRICULA,
            FECHA_EJECUCUCION,
            P_ACADEMICO
        ) VALUES
        (
            P_COD_SECCION,
            P_COD_GRADO,
            P_COD_ALU,
            G_COD_MATRICULA,
            CURRENT_TIMESTAMP,
            extract(year from sysdate)
        );
    END IF;
    RETURN G_COD_MATRICULA;
    
EXCEPTION 
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        RETURN '0';
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_MATRICULA(
    P_COD_MATRICULA CHAR,
    OBJ_MATRICULA OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN OBJ_MATRICULA FOR
    SELECT
        *
    FROM 
        MATRICULA
    WHERE COD_MATRICULA = P_COD_MATRICULA;
END;

CREATE OR REPLACE VIEW LISTAR_ALUMNO AS
    SELECT 
        AL.COD_ALU,
        AL.APATERNO_ALU,
        AL.AMATERNO_ALU,
        AL.NOMBRE_ALU, 
        AL.TELEFONO_ALU,
        AL.EMAIL_ALU,
        AL.DIRECCION_ALU,
        AL.FECHA_NAC,
        APO.COD_APODERADO,
        DI.NOM_DISTRITO,
        AL.DNI_ALUMNO
    FROM 
        ALUMNOS AL
    INNER JOIN APODERADO APO ON
        AL.COD_APODERADO = APO.COD_APODERADO
    INNER JOIN DISTRITO DI ON
        AL.COD_DISTRITO = DI.COD_DISTRITO;

create or replace PROCEDURE SP_LISTAR_ALUMNOS(
    CURSOR_ALUMNOS OUT SYS_REFCURSOR
)AS
BEGIN
 OPEN CURSOR_ALUMNOS FOR
 SELECT
    COD_ALU,
    APATERNO_ALU,
    AMATERNO_ALU,
    NOMBRE_ALU,
    TELEFONO_ALU,
    EMAIL_ALU,
    DIRECCION_ALU,
    COD_APODERADO,
    FECHA_NAC,
    NOM_DISTRITO,
    DNI_ALUMNO
 FROM LISTAR_ALUMNO;
END;
        
create or replace PROCEDURE SP_REGISTRAR_ALUMNO(
    A_APATERNO_ALU VARCHAR2,
    A_AMATERNO_ALU VARCHAR2,
    A_NOMBRE_ALU VARCHAR2,
    A_TELEFONO_ALU NUMBER,
    A_EMAIL_ALU VARCHAR2,
    A_DIRECCION_ALU VARCHAR2,
    A_FECHA_NAC DATE,
    A_COD_APODERADO VARCHAR2,
    A_COD_DISTRITO NUMBER,
    A_DNI_ALUMNO CHAR
) AS
BEGIN
    INSERT INTO ALUMNOS
    (COD_ALU, 
    APATERNO_ALU, 
    AMATERNO_ALU, 
    NOMBRE_ALU, 
    TELEFONO_ALU, 
    EMAIL_ALU,
    DIRECCION_ALU,
    FECHA_NAC,
    COD_APODERADO,
    COD_DISTRITO,
    DNI_ALUMNO)
    VALUES(
        SEQ_CODIGO_ALUMNO.NEXTVAL,
        A_APATERNO_ALU,
        A_AMATERNO_ALU,
        A_NOMBRE_ALU,
        A_TELEFONO_ALU,
        A_EMAIL_ALU,
        A_DIRECCION_ALU,
        A_FECHA_NAC,
        A_COD_APODERADO,
        A_COD_DISTRITO,
        A_DNI_ALUMNO
    );
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICAR_ALUMNO(
    A_COD_ALU NUMBER,
    A_TELEFONO_ALU NUMBER,
    A_EMAIL_ALU VARCHAR2,
    A_DIRECCION_ALU VARCHAR2,
    A_COD_DISTRITO NUMBER
)
AS
BEGIN
    UPDATE ALUMNOS
    SET 
        EMAIL_ALU = A_EMAIL_ALU,
        TELEFONO_ALU = A_TELEFONO_ALU,
        DIRECCION_ALU = A_DIRECCION_ALU,
        COD_DISTRITO = A_COD_DISTRITO
    WHERE
        COD_ALU = A_COD_ALU;
END;

CREATE OR REPLACE PROCEDURE SP_ELIMINAR_ALUMNO(
    A_COD_ALU NUMBER
)
AS
BEGIN
    DELETE FROM ALUMNOS WHERE COD_ALU = A_COD_ALU;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_ALUMNO(
    P_DNI_ALUMNO CHAR,
    ALUMNO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN ALUMNO FOR
    SELECT 
        *
    FROM ALUMNOS
    WHERE DNI_ALUMNO = P_DNI_ALUMNO;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_ALUMNO_COD(
    P_COD_ALUMNO NUMBER,
    ALUMNO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN ALUMNO FOR
    SELECT 
        *
    FROM ALUMNOS
    WHERE COD_ALU = P_COD_ALUMNO;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCARTODOS_ALU(
    P_DNI_ALU VARCHAR,
    ALU OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN ALU FOR
     SELECT
        COD_ALU,
        APATERNO_ALU,
        AMATERNO_ALU,
        NOMBRE_ALU,
        TELEFONO_ALU,
        EMAIL_ALU,
        DIRECCION_ALU,
        COD_APODERADO,
        FECHA_NAC,
        NOM_DISTRITO,
        DNI_ALUMNO
     FROM LISTAR_ALUMNO
     WHERE DNI_ALUMNO LIKE '%' || P_DNI_ALU || '%';
END;

CREATE OR REPLACE VIEW LISTAR_COMPROBANTES AS
    SELECT 
        CO.NRO_COMPROBANTE,
        CO.MONTO,
        CO.FECHA_EMISION,
        SC.COD_SECCION, 
        GR.COD_GRADO,
        AL.COD_ALU
    FROM 
        COMPROBANTE_PAGO CO
    INNER JOIN SECCION SC ON
     SC.COD_SECCION = CO.COD_SECCION
    INNER JOIN GRADO GR ON
        GR.COD_GRADO = CO.COD_GRADO
    INNER JOIN ALUMNOS AL ON
        AL.COD_ALU = CO.COD_ALU;
        
CREATE OR REPLACE PROCEDURE SP_LISTAR_COMPROBANTES(
    CUR_COMPROBANTES OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN CUR_COMPROBANTES FOR
    SELECT 
        NRO_COMPROBANTE,
        MONTO,
        FECHA_EMISION,
        COD_SECCION,
        COD_GRADO,
        COD_ALU
    FROM
        LISTAR_COMPROBANTES;
END;

CREATE OR REPLACE FUNCTION SF_REGISTRAR_COMPROBANTE
(
    C_MONTO NUMBER,
    C_COD_SECCION NUMBER,
    C_COD_GRADO NUMBER,
    C_COD_ALU NUMBER
)
RETURN NUMBER
AS
    V_NRO_COMPROBANTE COMPROBANTE_PAGO.NRO_COMPROBANTE%TYPE;
BEGIN
    V_NRO_COMPROBANTE := SQ_NRO_COMPROBANTE.NEXTVAL;
    INSERT INTO COMPROBANTE_PAGO 
    VALUES(
        V_NRO_COMPROBANTE,
        C_MONTO,
        SYSTIMESTAMP,
        C_COD_SECCION,
        C_COD_GRADO,
        C_COD_ALU
    );
    
    RETURN V_NRO_COMPROBANTE;
END;

CREATE OR REPLACE PROCEDURE SP_ELIMINAR_COMPROBANTE(
    C_NRO_COMPROBANTE NUMBER
)
AS
BEGIN
    DELETE FROM COMPROBANTE_PAGO
    WHERE
        NRO_COMPROBANTE = C_NRO_COMPROBANTE;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_COMPROBANTE(
    C_NRO_COMPROBANTE NUMBER,
    COMPROBANTE OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN COMPROBANTE FOR
    SELECT 
        *
    FROM LISTAR_COMPROBANTES
    WHERE NRO_COMPROBANTE = C_NRO_COMPROBANTE;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_SECCIONES(
    CUR_SECCIONES OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN CUR_SECCIONES FOR
    SELECT
        SC.COD_SECCION,
        SC.COD_GRADO,
        SC.NOMBRE_SECCION,
        SC.NRO_VACANTES,
        SC.NRO_SALON,
        GR.NOMBRE_GRADO
    FROM SECCION SC
    INNER JOIN GRADO GR
    ON SC.COD_GRADO = GR.COD_GRADO;
END;

CREATE OR REPLACE PROCEDURE SP_REGISTRAR_SECCIONES
(
    SC_COD_SECCION NUMBER,
    SC_COD_GRADO NUMBER,
    SC_NOMBRE_SECCION VARCHAR2,
    SC_NRO_VACANTES NUMBER,
    SC_NRO_SALON NUMBER
)
AS 
BEGIN
    INSERT INTO SECCION
    VALUES(
        SC_COD_SECCION,
        SC_COD_GRADO,
        SC_NOMBRE_SECCION,
        SC_NRO_VACANTES,
        SC_NRO_SALON
    );
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICAR_SECCION(
    SC_COD_SECCION NUMBER,
    SC_COD_GRADO NUMBER,
    SC_NRO_SALON NUMBER
)
AS
BEGIN
    UPDATE SECCION 
    SET 
        NRO_SALON = SC_NRO_SALON
    WHERE
        COD_SECCION = SC_COD_SECCION 
    AND 
        COD_GRADO = SC_COD_GRADO;
END;


CREATE OR REPLACE PROCEDURE SP_AMPLIAR_VACANTE(
    SC_COD_SECCION NUMBER,
    SC_COD_GRADO NUMBER,
    SC_NRO_VACANTES NUMBER
)
AS
BEGIN

    UPDATE SECCION 
    SET 
        NRO_VACANTES = NRO_VACANTES + SC_NRO_VACANTES
    WHERE
        COD_SECCION = SC_COD_SECCION 
    AND 
        COD_GRADO = SC_COD_GRADO;
    
END;

CREATE OR REPLACE PROCEDURE SP_ELIMINAR_SECCION(
    SC_COD_SECCION NUMBER,
    SC_COD_GRADO NUMBER
)
AS
BEGIN
    DELETE FROM SECCION
    WHERE
    COD_SECCION = SC_COD_SECCION 
    AND 
    COD_GRADO = SC_COD_GRADO;
END;

CREATE OR REPLACE PROCEDURE SP_BUSCAR_SECCION(
    SC_COD_SECCION NUMBER,
    SC_COD_GRADO NUMBER,
    SECCION OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN SECCION FOR
    SELECT
        SC.COD_SECCION,
        SC.COD_GRADO,
        SC.NOMBRE_SECCION,
        SC.NRO_VACANTES,
        SC.NRO_SALON,
        GR.NOMBRE_GRADO
    FROM SECCION SC
    INNER JOIN GRADO GR
    ON SC.COD_GRADO = GR.COD_GRADO
    WHERE
       SC.COD_SECCION = SC_COD_SECCION 
    AND 
       SC.COD_GRADO = SC_COD_GRADO;
END;

CREATE OR REPLACE FUNCTION SF_VERIFICAR_MATRICULA(
    P_DNI_ALU CHAR
)
RETURN NUMBER
AS
    V_VERIF NUMBER(3);
BEGIN

    SELECT COUNT(*) INTO V_VERIF
    FROM MATRICULA MAT
    INNER JOIN ALUMNOS ALU
    ON MAT.COD_ALU = ALU.COD_ALU
    WHERE DNI_ALUMNO = P_DNI_ALU
    AND P_ACADEMICO = EXTRACT(YEAR FROM SYSDATE);
    
    IF V_VERIF = 1 THEN
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
END;

CREATE OR REPLACE PROCEDURE SP_LISTAR_GRADO(
    P_CURSOR OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_CURSOR FOR 
    SELECT
        COD_GRADO,
        NOMBRE_GRADO,
        NIVEL
    FROM GRADO;
END;


CREATE OR REPLACE PROCEDURE SP_LISTAR_DOCUMENTOS(
    CUR_DOCS OUT SYS_REFCURSOR
) 
AS
BEGIN
    OPEN CUR_DOCS FOR
    SELECT
       *
    FROM DOCUMENTOS;
END;