package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.service;

import java.util.List;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;

public interface ICursoService {

    /**
     * Registra un nuevo curso en el sistema.
     *
     * @param curso el curso a registrar
     * @return la lista actualizada de cursos
     */
    public List<Curso> altaCurso(Curso curso);

    /**
     * Elimina un curso del sistema.
     *
     * @param codCurso el código del curso a eliminar
     * @return la lista actualizada de cursos
     */
    public List<Curso> bajaCurso(String codCurso);

    /**
     * Actualiza la duración de un curso existente.
     *
     * @param codCurso el código del curso a actualizar
     * @param duracion la nueva duración del curso en horas
     */
    public void actualizacionDuracion(String codCurso, int duracion);

    /**
     * Busca un curso por su código.
     *
     * @param codCurso el código del curso a buscar
     * @return el curso correspondiente al código, o null si no se encuentra
     */
    public Curso buscarCurso(String codCurso);

    /**
     * Busca todos los cursos cuyo precio está dentro del rango especificado.
     *
     * @param precioMinimo el precio mínimo del rango
     * @param precioMaximo el precio máximo del rango
     * @return la lista de cursos cuyo precio está dentro del rango
     */
    public List<Curso> cursosPorPrecio(int precioMinimo, int precioMaximo);
}