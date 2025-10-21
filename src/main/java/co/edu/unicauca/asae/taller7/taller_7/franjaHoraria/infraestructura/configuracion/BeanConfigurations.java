package co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller7.taller_7.comons.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.aplicacion.output.GestionarFranjaHorariaGatewayIntPort;
import co.edu.unicauca.asae.taller7.taller_7.franjaHoraria.dominio.casosDeUso.GestionarFranjaHorariaCUAdapter;

@Configuration
public class BeanConfigurations {
    
    @Bean
    public GestionarFranjaHorariaCUAdapter crearGestionarFranjaHorariaCUInt(
            GestionarFranjaHorariaGatewayIntPort objGestionarFranjaHorariaGateway,
            FormateadorResultadosIntPort objFranjaHorariaFormateadorResultados) {
                GestionarFranjaHorariaCUAdapter objGestionarFranjaHorariaCU = new GestionarFranjaHorariaCUAdapter(objGestionarFranjaHorariaGateway,
                objFranjaHorariaFormateadorResultados);
        return objGestionarFranjaHorariaCU;
    }
    
}

/*
 Creación de relaciones entre clases Entity mediante JPA y su unión con la arquitectura hexagonal 
 1.-KeyWord
A continuación, se relacionan las Keywords que fueron implementadas en el taller 6 ( Uso de Keywords y Query mediante JPA), en el actual taller para cada una de dichas keywords se deben crear servicios rest que permitan usar su respuesta:

(Consultar en una sola tabla) En el repositorio de espacio físico, listar espacios físicos, ordenados ascendientemente por el campo nombre, que comiencen por un patrón de búsqueda, ignorando mayúsculas y minúsculas y que la capacidad sea mayor o igual que un parámetro de búsqueda. (Crear un servicio rest que permita usar su respuesta)

(Consultar en tablas relacionadas) En el repositorio de curso, obtener los cursos por nombre de asignatura (Crear un servicio rest que permita usar su respuesta)

(Consultar en tablas relacionadas) En el repositorio de flanjas, obtener todas las franjas ocupadas por un curso con un id específico (Crear un servicio rest que permita usar su respuesta)
2.-Querys a utilizar en comprobaciones
A continuación, se relacionan las Querys de consulta, que ya fueron implementadas en el taller 6 (Uso de Keywords y Query mediante JPA). En el actual taller se deben usar para comprobaciones de reglas de negocio.

Utilizar una query que reciba día, hora de inicio, hora fin e id del espacio físico. Con los datos de entrada debe hacer un join entre franja Horaria y espacio físico. Debe retornar como resultado si el espacio físico está ocupado en el día, hora de inicio y hora fin. Use JPQL (Úsela para comprobaciones de reglas de negocio)

Utilizar una query que reciba día, hora de inicio, hora fin e id del docente. Con los datos de entrada debe hacer un join entre franja Horaria, curso y docente. Debe retornar como resultado si el docente está ocupado en el día, hora de inicio y hora fin. Use SQL Nativo (Úsela para comprobaciones de reglas de negocio)
3.-Querys a utilizar en consultas
A continuación, se relacionan las Querys de consulta, que ya fueron implementadas en el taller 6 (Uso de Keywords y Query mediante JPA). En el actual taller se deben usar para consultar y actualizar entidades mediante servicios REST.

Utilizar una query que reciba e id del curso. Con los datos de entrada debe hacer un join entre curso, franja Horaria y espacio físico. Debe retornar como resultado los datos de las flanjas, espacio físico y curso. Use JPQL (Crear un servicio rest que permita usar su respuesta)

Utilizar una query para crear una sentencia que permita actualizar solo el estado de un espacio físico a activo o inactivo. Use SQL Nativo (Crear un servicio rest que permita actualizar un espacio físico)

Utilizar una query para crear una sentencia que permita eliminar las flanjas horarias de un curso en particular. Use JPQL (Crear un servicio rest que permita actualizar un espacio físico)
4.-Validaciones automáticas
• Utilizar las anotaciones @size, @notNull, @email, @notEmply y otras para validar automáticamente los campos de los datos de entrada en el registro de los docentes, Espacios Físicos y Franjas Horarias.
• Utilice la anotación @min para validar el parámetro de entrada de la URL al servicio consultar franjas de docente
• Se deben crear 2 validaciones personalizadas para: comprobar que las horas de inicio y fin de una franja horaria siguen el formato militar y validar la capacidad del Espacio Físico frente a la matrícula estimada del curso.
• Las validaciones deben utilizar mensajes personalizados y deben estar almacenados en el archivo de mensajes en español si se configura el idioma español (es), o deben estar almacenados en el archivo de mensajes en ingles si se configura el idioma inglés (en).
• Retornar los códigos http adecuados cuando no se cumplan las validaciones utilizando el controlador de excepciones
5.-Comprobaciones de reglas de negocio utilizando el patrón cadena de responsabilidades
• Validar que, al registrar una Franja Horaria, no este ocupado el Espacio Físico en el día, hora de inicio y hora fin a utilizar. Utilizar la Query creada en el punto 2, y si es el caso utilizar otras Query creadas en el taller anterior (Taller 6). Debe utilizar un puerto de salida que se conecte con el repositorio donde están alojadas las querys.
• Validar que, al registrar una Franja Horaria, un docente no debe estar registrado al mismo tiempo en otra franja horaria en el día, hora de inicio y hora fin a utilizar. Utilizar la Query creada en el punto 2, y si es el caso utilizar otras Query creadas en el taller anterior (Taller 6). Debe utilizar un puerto de salida que se conecte con el repositorio donde están alojadas las querys.
• Validar que el espacio físico, docente y curso existan al momento de crear una franja horaria. Debe utilizar un puerto de salida que se conecte con el repositorio donde están alojadas las querys.
• Validar que, al crear un docente, no exista un docente con el mismo correo electrónico. Si es el caso utilizar las Query creadas en el taller anterior (Taller 6) . Debe utilizar un puerto de salida que se conecte con el repositorio donde están alojadas las querys.
• Retornar los códigos http adecuados cuando se almacenan los recursos o se listan los recursos utilizando el controlador de excepciones
6.-Servicios REST que utilizan las entitys
• Crear Franja Horaria. Este servicio debe crear una Franja Horaria, y asociarla a un Curso y Espacio Físico existente. El servicio debe recibir un objeto de tipo FranjaHorariaDTOPetición. No debe enviar el id de Franja Horaria, pero si debe enviar el id de Espacio Físico y el id del Curso.
• Crear docente. Este servicio permite registrar un docente, persona y la oficina de trabajo asignada, y posteriormente debe almacenar el docente, persona y la oficina en la base de datos. El servicio debe recibir un objeto de tipo DocenteDTO dentro del cual se encuentra un objeto de tipo OficinaDTO. No debe enviar el id del docente ni el id de la oficina. Utilice la acción encascada persist para que al almacenar el docente se almacenen en cascada la persona y oficina. Únicamente debe usar un save del repositorio de docente.
• Listar franja horaria por docente. Este servicio debe mostrar las franjas horarias, espacios físicos y cursos de un docente. El servicio debe recibir el id del docente por la URL y retornar las franjas horarias. Para retornar las franjas horarias utilice un objeto de tipo franjaHorariaDeDocenteDTORespuesta. Utilice el ligado eager para traer los Cursos y Espacio Físicos.
• Listar franja horaria por curso. Este servicio debe mostrar las franjas horarias, espacios físicos y cursos de un docente. El servicio debe recibir el id del curso por la URL y retornar las franjas horarias que tiene. Para retornar las franjas horarias utilice un objeto de tipo franjaHorariaDeCursoDTORespuesta. Utilice el
ligado lazy para no traer el curso, pero si los datos de los espacios físicos y docentes. Recuerde modificar el mapper entre las entity y las clases del dominio.
• Listar espacios físicos. Este servicio debe mostrar los Espacios Físicos. Para retornar los espacios físicos utilice el método creado mediante keyWords del punto 1.
7.-Implementar la arquitectura hexagonal
Cree los siguientes dominios: franja horaria, docente, espacio físico. Por cada dominio cree los paquetes aplicación, dominio e infraestructura.
Paquete aplicación
• En el paquete input debe crear una o varias interfaces (port) que permitan crear franja horaria, crear docente, listar franjas horarias y listar espacios físicos.
• En el paquete output se debe crear interfaces (port) que permitan crear franja horaria, crear docente, listar franjas horarias, listar espacios físicos, y conectarse con las siguientes validaciones: validar que, al registrar una franja horaria, no este ocupado el espacio físico; validar que, al registrar una franja horaria, un docente no debe estar registrado al mismo tiempo; y Validar que, al crear un docente, no exista un docente con el mismo correo electrónico.
• En paquete output se debe crear una interfaz que permita retornar respuestas de error cuando una entidad existe y retornar respuestas cuando ocurre un error en una regla de negocio. 
Paquete dominio
• En el paquete modelos se deben crear las clases docente, persona, oficina, franja horaria, curso, asignatura, y espacio físico.
• En el paquete casos de uso se debe crear una clase o varias clases que implementen los port.
Paquete infraestructura
• En el paquete configuración se deben generar los beans correspondientes.
• En el paquete input debemos ubicar los controladores que ofrecen los servicios REST; los DTO que encapsularan los datos enviados al controlador, los DTO que encapsularan los datos a responder al cliente; y los mappers entre los DTO y el dominio.
• En el paquete output se debe ubicar el controlador de excepciones; la implementación del port que permite formatear las respuestas; y en el sub-paquete persistencia las entidades, respositorios, mappers entre dominio y entity, y un Gateway que implementa el port para guardar docentes, listar flanjas horarias y listar espacios físicos en el medio de persistencia.

*/