package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, String> {

    @Query("SELECT c FROM Curso c WHERE c.precio BETWEEN ?1 AND ?2")
    List<Curso> findByPrecioBetween(int precioMinimo, int precioMaximo);

}
