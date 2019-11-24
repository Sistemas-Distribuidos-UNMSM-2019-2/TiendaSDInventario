package com.fisi.inventario.entity

// Generated 22/11/2019 01:09:25 PM by Hibernate Tools 4.0.1.Final
import javax.persistence.Column
import javax.persistence.Embeddable

/**
 * OrdencompraHasProductoId generated by hbm2java
 */
@Embeddable
class OrdencompraHasProductoId : java.io.Serializable {
	@get:Column(name = "OrdenCompra_vIdOrdenCompra", nullable = false)
	var ordenCompraVIdOrdenCompra: Int = 0
	@get:Column(name = "Producto_vCodigo", nullable = false)
	var productoVCodigo: Int = 0

	constructor() {}
	constructor(ordenCompraVIdOrdenCompra: Int, productoVCodigo: Int) {
		this.ordenCompraVIdOrdenCompra = ordenCompraVIdOrdenCompra
		this.productoVCodigo = productoVCodigo
	}

	public fun equals(other: Any): Boolean {
		if ((this === other))
			return true
		if ((other == null))
			return false
		if (!(other is OrdencompraHasProductoId))
			return false
		val castOther = other as OrdencompraHasProductoId
		return ((this.ordenCompraVIdOrdenCompra == castOther.ordenCompraVIdOrdenCompra) && (this.productoVCodigo == castOther.productoVCodigo))
	}

	public override fun hashCode(): Int {
		var result = 17
		result = 37 * result + this.ordenCompraVIdOrdenCompra
		result = 37 * result + this.productoVCodigo
		return result
	}
}