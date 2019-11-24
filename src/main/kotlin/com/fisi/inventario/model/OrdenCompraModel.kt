package com.fisi.inventario.model

import java.util.Date

class OrdenCompraModel {
	private var sRucCliente: String? = null
	private var nPrecioTotal: Double? = 0.toDouble()
	private var dFechaCompra: Date? = null
	private var dFechaPago: Date? = null
	private var lDetalleCompra: List<OrdenCompraDetalleModel?>? = null
	
	fun getsRucCliente(): String? {
		return sRucCliente
	}

	fun setsRucCliente(sRucCliente: String?) {
		this.sRucCliente = sRucCliente
	}

	fun getnPrecioTotal(): Double? {
		return nPrecioTotal
	}

	fun setnPrecioTotal(nPrecioTotal: Double?) {
		this.nPrecioTotal = nPrecioTotal
	}

	fun getdFechaCompra(): Date? {
		return dFechaCompra
	}

	fun setdFechaCompra(dFechaCompra: Date?) {
		this.dFechaCompra = dFechaCompra
	}

	fun getdFechaPago(): Date? {
		return dFechaPago
	}

	fun setdFechaPago(dFechaPago: Date?) {
		this.dFechaPago = dFechaPago
	}

	fun getlDetalleCompra(): List<OrdenCompraDetalleModel?>? {
		return lDetalleCompra
	}

	fun setlDetalleCompra(lDetalleCompra: List<OrdenCompraDetalleModel?>?) {
		this.lDetalleCompra = lDetalleCompra
	}
}