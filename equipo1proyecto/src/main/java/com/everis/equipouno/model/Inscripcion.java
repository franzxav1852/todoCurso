package com.everis.equipouno.model;
// Generated 18/09/2019 12:21:43 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Inscripcion generated by hbm2java
 */
@Entity
@Table(name = "inscripcion", catalog = "escuela")
public class Inscripcion implements java.io.Serializable {

	private Integer id;
	private Alumno alumno;
	private Calendario calendario;
	private Set<Pago> pagos = new HashSet<Pago>(0);

	public Inscripcion() {
	}

	public Inscripcion(Alumno alumno, Calendario calendario) {
		this.alumno = alumno;
		this.calendario = calendario;
	}

	public Inscripcion(Alumno alumno, Calendario calendario, Set<Pago> pagos) {
		this.alumno = alumno;
		this.calendario = calendario;
		this.pagos = pagos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "alumno_id", nullable = false)
	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "calendario_id", nullable = false)
	public Calendario getCalendario() {
		return this.calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "inscripcion")
	public Set<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

}
