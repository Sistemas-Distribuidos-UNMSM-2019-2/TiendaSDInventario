package com.fisi.inventario.model

class ProductoModel {
	private var nCodigo: Int? = 0
	private var sNombre: String? = null
	private var sDescripcion: String? = null
	private var nPrecioUnitario: Double? = 0.toDouble()
	private var nCantidad: Int? = 0
	
	fun getnCodigo(): Int? {
		return nCodigo
	}

	fun setnCodigo(nCodigo: Int?) {
		this.nCodigo = nCodigo
	}

	fun getsNombre(): String? {
		return sNombre
	}

	fun setsNombre(sNombre: String?) {
		this.sNombre = sNombre
	}

	fun getsDescripcion(): String? {
		return sDescripcion
	}

	fun setsDescripcion(sDescripcion: String?) {
		this.sDescripcion = sDescripcion
	}

	fun getnPrecioUnitario(): Double? {
		return nPrecioUnitario
	}

	fun setnPrecioUnitario(nPrecioUnitario: Double?) {
		this.nPrecioUnitario = nPrecioUnitario
	}

	fun getnCantidad(): Int? {
		return nCantidad
	}

	fun setnCantidad(nCantidad: Int?) {
		this.nCantidad = nCantidad
	}
	
}