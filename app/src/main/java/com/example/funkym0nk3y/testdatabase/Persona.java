package com.example.funkym0nk3y.testdatabase;

/**
 * Created by FunkyM0nk3y on 8/1/15.
 */
public class Persona {
  private Long id;
  private String nombre;

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Persona{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            '}';
  }
}
