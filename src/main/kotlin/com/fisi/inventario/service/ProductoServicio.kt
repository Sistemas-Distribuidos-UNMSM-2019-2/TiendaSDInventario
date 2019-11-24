package com.fisi.inventario.service

import com.fisi.inventario.model.ProductoModel

interface ProductoServicio {
	fun listarProductos(): ArrayList<ProductoModel?>?
	
	fun buscarProducto(nCodigoProducto:Int):ProductoModel?
}