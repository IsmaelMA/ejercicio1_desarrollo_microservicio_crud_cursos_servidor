package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;
import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.repository.CursoRepository;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoRepository repository;

    @Override
    public List<Curso> altaCurso(Curso curso) {
        repository.save(curso);
        return repository.findAll();
    }

    @Override
    public List<Curso> bajaCurso(String codCurso) {
        repository.deleteById(codCurso);
        return repository.findAll();
    }

    @Override
    public void actualizacionDuracion(String codCurso, int duracion) {
        Curso curso = repository.findById(codCurso).get();
        curso.setDuracion(duracion);
        repository.save(curso);
    }

    @Override
    public Curso buscarCurso(String codCurso) {
        return repository.findById(codCurso).get();
    }

    @Override
    public List<Curso> cursosPorPrecio(int precioMinimo, int precioMaximo) {
        return repository.findByPrecioBetween(precioMinimo, precioMaximo);
    }

}
