package com.fisi.inventario.entity

// Generated 22/11/2019 01:09:25 PM by Hibernate Tools 4.0.1.Final
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Trabajador generated by hbm2java
 */
@Entity
@Table(name = "trabajador", catalog = "sdtienda")
class Trabajador : java.io.Serializable {
	@get:Id
	@get:Column(name = "vDNI", unique = true, nullable = false, length = 8)
	var vdni: String? = null
	@get:Column(name = "vApellidoPaterno", length = 40)
	var vapellidoPaterno: String? = null
	@get:Column(name = "vApellidoMaterno", length = 40)
	var vapellidoMaterno: String? = null
	@get:Column(name = "vNombre", length = 40)
	var vnombre: String? = null
	@get:Column(name = "nTipoTrabajador")
	var ntipoTrabajador: Integer? = null

	constructor() {}
	constructor(vdni: String?) {
		this.vdni = vdni
	}

	constructor(
		vdni: String?, vapellidoPaterno: String?, vapellidoMaterno: String?, vnombre: String?,
		ntipoTrabajador: Integer?
	) {
		this.vdni = vdni
		this.vapellidoPaterno = vapellidoPaterno
		this.vapellidoMaterno = vapellidoMaterno
		this.vnombre = vnombre
		this.ntipoTrabajador = ntipoTrabajador
	}
}