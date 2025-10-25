package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalTime;

public class FormatoHoraMilitarValidator implements ConstraintValidator<FormatoHoraMilitar, LocalTime> {

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return !value.isBefore(LocalTime.MIDNIGHT) &&
               !value.isAfter(LocalTime.of(23, 59));
    }
}
