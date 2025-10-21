INSERT INTO `asignaturas` (`id`, `nombre`, `codigo`) VALUES (NULL, 'Programacion orientada a objetos', 'POO');
INSERT INTO `asignaturas` (`id`, `nombre`, `codigo`) VALUES (NULL, 'Bases de datos I', 'BDI');
INSERT INTO `asignaturas` (`id`, `nombre`, `codigo`) VALUES (NULL, 'Teoria de la computacion', 'TC');

INSERT INTO `oficinas` (`id`, `nombre`, `ubicacion`) VALUES (NULL, 'Oficina 329', 'FIET');
INSERT INTO `oficinas` (`id`, `nombre`, `ubicacion`) VALUES (NULL, 'Oficina 450', 'FIET');
INSERT INTO `oficinas` (`id`, `nombre`, `ubicacion`) VALUES (NULL, 'Oficina 444', 'FIET');
 
INSERT INTO `personas` (`id`, `nombre`, `apellido`, `correo`) VALUES (NULL, 'Nestor', 'Diaz', 'nestor@unicauca.edu.co');
INSERT INTO `personas` (`id`, `nombre`, `apellido`, `correo`) VALUES (NULL, 'Martha', 'Mendoza', 'martha@unicauca.edu.co');
INSERT INTO `personas` (`id`, `nombre`, `apellido`, `correo`) VALUES (NULL, 'Ricardo', 'Zambrano', 'ricardo@unicauca.edu.co');

INSERT INTO `docentes` (`IdDocente`, `oficina_id`) VALUES (1, 1);
INSERT INTO `docentes` (`IdDocente`, `oficina_id`) VALUES (2, 2);
INSERT INTO `docentes` (`IdDocente`, `oficina_id`) VALUES (3, 3);

INSERT INTO `cursos` (`idCurso`, `nombre`, `matriculaEstimada`, `asignatura_id`) VALUES (NULL, 'Programacion orientada a objetos A', 30, 1);
INSERT INTO `cursos` (`idCurso`, `nombre`, `matriculaEstimada`, `asignatura_id`) VALUES (NULL, 'Programacion orientada a objetos B', 35, 1);
INSERT INTO `cursos` (`idCurso`, `nombre`, `matriculaEstimada`, `asignatura_id`) VALUES (NULL, 'Bases de datos A',38, 2);

INSERT INTO `cursosdocente` (`idCurso`, `idDocente`) VALUES (1, 1);
INSERT INTO `cursosdocente` (`idCurso`, `idDocente`) VALUES (2, 1);
INSERT INTO `cursosdocente` (`idCurso`, `idDocente`) VALUES (3, 2), (3, 3);

INSERT INTO `espacios_fisicos` (`nombre`, `capacidad`,`estado`) VALUES ('Sala 4', 18, "activo");
INSERT INTO `espacios_fisicos` (`nombre`, `capacidad`,`estado`) VALUES ('Salon 225', 35, "inactivo");
INSERT INTO `espacios_fisicos` (`nombre`, `capacidad`,`estado`) VALUES ('Auditorio 1', 80, 'activo');


