package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;
import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.service.CursoService;

/**
 * Controlador que maneja las peticiones HTTP relacionadas con los cursos.
 */
@RestController
public class CursoController {

    /** Servicio que contiene la lógica de negocio relacionada con los cursos. */
    @Autowired
    private CursoService service;

    /**
     * Registra un nuevo curso y devuelve una lista de todos los cursos.
     * 
     * @param curso El curso que se quiere registrar.
     * @return Lista de todos los cursos.
     */
    @PostMapping(value = "/curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> postAltaDeCursos(@RequestBody Curso curso) {
        return service.altaCurso(curso);
    }

    /**
     * Elimina un curso por su código y devuelve una lista de todos los cursos.
     * 
     * @param codCurso El código del curso que se quiere eliminar.
     * @return Lista de todos los cursos.
     */
    @DeleteMapping(value = "/curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> deleteEliminacionDeCurso(@RequestParam("codCurso") String codCurso) {
        return service.bajaCurso(codCurso);
    }

    /**
     * Actualiza la duración de un curso específico.
     * 
     * @param codCurso El código del curso al que se quiere actualizar la duración.
     * @param duracion La nueva duración del curso.
     */
    @PutMapping(value = "/curso")
    public void putActualizacionDeDuracion(@RequestParam("codCurso") String codCurso,
            @RequestParam("duracion") int duracion) {
        service.actualizacionDuracion(codCurso, duracion);
    }

    /**
     * Busca un curso por su código.
     * 
     * @param codCurso El código del curso que se quiere buscar.
     * @return El curso encontrado.
     */
    @GetMapping(value = "/curso/{codCurso}")
    public Curso getBusquedaDeCurso(@PathVariable("codCurso") String codCurso) {
        return service.buscarCurso(codCurso);
    }

    /**
     * Devuelve una lista de cursos cuyo precio está entre un rango determinado.
     * 
     * @param precioMinimo El precio mínimo del rango.
     * @param precioMaximo El precio máximo del rango.
     * @return Lista de cursos dentro del rango de precio.
     */
    @GetMapping(value = "/curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursosPorPrecio(@RequestParam("precioMinimo") int precioMinimo,
            @RequestParam("precioMaximo") int precioMaximo) {
        return service.cursosPorPrecio(precioMinimo, precioMaximo);
    }

}
