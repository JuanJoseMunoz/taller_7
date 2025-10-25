package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.validaciones;

import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Documented
@Constraint(validatedBy = CapacidadSuficienteValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CapacidadSuficiente {
    String message() default "La capacidad del espacio fisico no es suficiente para la matrícula estimada del curso";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}