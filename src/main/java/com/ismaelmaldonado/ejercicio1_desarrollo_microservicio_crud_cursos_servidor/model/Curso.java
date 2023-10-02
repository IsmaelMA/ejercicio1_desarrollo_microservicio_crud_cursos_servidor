package com.ismaelmaldonado.ejercicio1_desarrollo_microservicio_crud_cursos_servidor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa el modelo de un Curso con sus respectivos atributos y métodos.
 * Esta clase está mapeada como una entidad en la base de datos bajo la tabla
 * "cursos".
 */
@Entity
@Table(name = "cursos")
public class Curso {

    /** Identificador único del curso. */
    @Id
    @Column(name = "cod_curso")
    private String codCurso;

    /** Nombre del curso. */
    @Column(name = "nombre")
    private String nombre;

    /** Duración del curso en horas o días. */
    @Column(name = "duracion")
    private int duracion;

    /** Precio del curso. */
    @Column(name = "precio")
    private int precio;

    /**
     * Constructor por defecto.
     */
    public Curso() {
    }

    /**
     * Constructor con el identificador del curso como parámetro.
     * 
     * @param codCurso Identificador único del curso.
     */
    public Curso(String codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * Constructor que inicializa todos los atributos del curso.
     * 
     * @param codCurso Identificador único del curso.
     * @param nombre   Nombre del curso.
     * @param duracion Duración del curso.
     * @param precio   Precio del curso.
     */
    public Curso(String codCurso, String nombre, int duracion, int precio) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    /**
     * Retorna el código del curso.
     * 
     * @return El código del curso.
     */
    public String getCodCurso() {
        return codCurso;
    }

    /**
     * Establece el código del curso.
     * 
     * @param codCurso El código del curso a establecer.
     */
    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    /**
     * Retorna el nombre del curso.
     * 
     * @return El nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del curso.
     * 
     * @param nombre El nombre del curso a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la duración del curso.
     * 
     * @return La duración del curso.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del curso.
     * 
     * @param duracion La duración del curso a establecer.
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Retorna el precio del curso.
     * 
     * @return El precio del curso.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del curso.
     * 
     * @param precio El precio del curso a establecer.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Calcula y retorna el código hash del curso basado en su identificador.
     * 
     * @return El código hash del curso.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCurso == null) ? 0 : codCurso.hashCode());
        return result;
    }

    /**
     * Determina si este curso es igual a otro objeto.
     * 
     * @param obj El objeto con el cual comparar.
     * @return true si son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (codCurso == null) {
            if (other.codCurso != null)
                return false;
        } else if (!codCurso.equals(other.codCurso))
            return false;
        return true;
    }

    /**
     * Retorna una representación en cadena del curso.
     * 
     * @return Una representación en cadena del curso.
     */
    @Override
    public String toString() {
        return "Curso [codCurso=" + codCurso + ", nombre=" + nombre + ", duracion=" + duracion + ", precio=" + precio
                + "]";
    }
}
