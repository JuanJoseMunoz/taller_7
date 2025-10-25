package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.input.controllerGestionarFranjasHorarias.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class FormatoHoraMilitarValidator implements ConstraintValidator<FormatoHoraMilitar, String> {

    private static final Pattern FORMATO_MILITAR = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return false;
        }
        return FORMATO_MILITAR.matcher(value.trim()).matches();
    }
}
