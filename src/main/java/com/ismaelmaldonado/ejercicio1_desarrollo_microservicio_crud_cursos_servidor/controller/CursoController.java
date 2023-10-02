package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;
import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.service.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping(value = "/curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> postAltaDeCursos(@RequestBody Curso curso) {
        return service.altaCurso(curso);
    }

    @DeleteMapping(value = "/curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> deleteEliminacionDeCurso(@RequestParam("codCurso") String codCurso) {
        return service.bajaCurso(codCurso);
    }

    @PutMapping(value = "/curso")
    public void putActualizacionDeDuracion(@RequestParam("codCurso") String codCurso,
            @RequestParam("duracion") int duracion) {
        service.actualizacionDuracion(codCurso, duracion);
    }

    @GetMapping(value = "/curso/{codCurso}")
    public Curso getBusquedaDeCurso(@PathVariable("codCurso") String codCurso) {
        return service.buscarCurso(codCurso);
    }

    @GetMapping(value = "/curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursosPorPrecio(@RequestParam("precioMinimo") int precioMinimo,
            @RequestParam("precioMaximo") int precioMaximo) {
        return service.cursosPorPrecio(precioMinimo, precioMaximo);
    }

}
