package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;
import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.repository.CursoRepository;

/**
 * Implementación del servicio que maneja la lógica de negocio relacionada con
 * los cursos.
 */
@Service
public class CursoService implements ICursoService {

    /** Repositorio que permite la interacción con la base de datos de cursos. */
    @Autowired
    private CursoRepository repository;

    /**
     * Registra un nuevo curso y devuelve una lista de todos los cursos.
     * 
     * @param curso El curso que se quiere registrar.
     * @return Lista de todos los cursos.
     */
    @Override
    public List<Curso> altaCurso(Curso curso) {
        repository.save(curso);
        return repository.findAll();
    }

    /**
     * Elimina un curso por su código y devuelve una lista de todos los cursos.
     * 
     * @param codCurso El código del curso que se quiere eliminar.
     * @return Lista de todos los cursos.
     */
    @Override
    public List<Curso> bajaCurso(String codCurso) {
        repository.deleteById(codCurso);
        return repository.findAll();
    }

    /**
     * Actualiza la duración de un curso específico.
     * 
     * @param codCurso El código del curso al que se quiere actualizar la duración.
     * @param duracion La nueva duración del curso.
     */
    @Override
    public void actualizacionDuracion(String codCurso, int duracion) {
        Curso curso = repository.findById(codCurso).get();
        curso.setDuracion(duracion);
        repository.save(curso);
    }

    /**
     * Busca un curso por su código.
     * 
     * @param codCurso El código del curso que se quiere buscar.
     * @return El curso encontrado.
     */
    @Override
    public Curso buscarCurso(String codCurso) {
        return repository.findById(codCurso).orElse(null);
    }

    /**
     * Devuelve una lista de cursos cuyo precio está entre un rango determinado.
     * 
     * @param precioMinimo El precio mínimo del rango.
     * @param precioMaximo El precio máximo del rango.
     * @return Lista de cursos dentro del rango de precio.
     */
    @Override
    public List<Curso> cursosPorPrecio(int precioMinimo, int precioMaximo) {
        return repository.findByPrecioBetween(precioMinimo, precioMaximo);
    }

    @Override
    public List<Curso> listarTodosLosCursos() {
        return repository.findAll();
    }

}
