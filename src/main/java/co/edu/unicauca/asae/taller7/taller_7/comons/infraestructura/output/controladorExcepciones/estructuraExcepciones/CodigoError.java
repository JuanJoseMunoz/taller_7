package co.edu.unicauca.asae.taller7.taller_7.comons.infraestructura.output.controladorExcepciones.estructuraExcepciones;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Getter
public enum CodigoError {
    ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
    ENTIDAD_YA_EXISTE("GC-0002", "ERROR ENTIDAD YA EXISTE"),
    ENTIDAD_NO_ENCONTRADA("GC-0003", "Entidad no encontrada"),
    VIOLACION_REGLA_DE_NEGOCIO("GC-0004", "Regla de negocio violada"),
    ESPACIO_FISICO_OCUPADO("GH-0005", "El espacio físico ya está ocupado en ese horario"),
    DOCENTE_OCUPADO("GH-0006", "El docente ya está ocupado en ese horario"),
    CORREO_DUPLICADO("GH-0007", "Ya existe un docente con ese correo electrónico"),
    CAPACIDAD_INSUFICIENTE("GH-0008", "La capacidad del espacio físico es insuficiente para el curso"),
    VALIDACION_FALLIDA("GH-0009", "Error de validación en los datos de entrada");
    
    private final String codigo;
    private final String llaveMensaje;

}
