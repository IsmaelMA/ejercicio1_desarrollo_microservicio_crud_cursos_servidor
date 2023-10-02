package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.service;

import java.util.List;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;

public interface ICursoService {

    public List<Curso> altaCurso(Curso curso);

    public List<Curso> bajaCurso(String codCurso);

    public void actualizacionDuracion(String codCurso, int duracion);

    public Curso buscarCurso(String codCurso);

    public List<Curso> cursosPorPrecio(int precioMinimo, int precioMaximo);
}
