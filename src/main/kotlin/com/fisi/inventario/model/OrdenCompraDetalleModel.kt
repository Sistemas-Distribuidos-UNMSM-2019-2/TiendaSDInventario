package com.fisi.inventario.model

class OrdenCompraDetalleModel {
	private var nCodigoProducto: Int? = 0
	private var sNombreProducto: String? = null
	private var nCantidadProducto: Int? = 0
	private var nTotalParcial: Double? = 0.toDouble()
	private var bExistencia: Boolean? = false
	
	fun getnCodigoProducto(): Int? {
		return nCodigoProducto
	}

	fun setnCodigoProducto(nCodigoProducto: Int?) {
		this.nCodigoProducto = nCodigoProducto
	}

	fun getsNombreProducto(): String? {
		return sNombreProducto
	}

	fun setsNombreProducto(sNombreProducto: String?) {
		this.sNombreProducto = sNombreProducto
	}

	fun getnCantidadProducto(): Int? {
		return nCantidadProducto
	}

	fun setnCantidadProducto(nCantidadProducto: Int?) {
		this.nCantidadProducto = nCantidadProducto
	}

	fun getnTotalParcial(): Double? {
		return nTotalParcial
	}

	fun setnTotalParcial(nTotalParcial: Double?) {
		this.nTotalParcial = nTotalParcial
	}

	fun isbExistencia(): Boolean? {
		return bExistencia
	}

	fun setbExistencia(bExistencia: Boolean?) {
		this.bExistencia = bExistencia
	}
}