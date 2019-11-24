package com.fisi.inventario.controller

import java.io.IOException
import java.io.PrintWriter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import com.fisi.inventario.serviceimpl.ProductoServicioImpl
import com.fisi.inventario.model.ProductoModel
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ProductoController {
	@Autowired
	@Qualifier("productoService")
	private val productoServicio: ProductoServicioImpl? = null

	@GetMapping("/obtenerProductos")
	fun listaMateriaPrimaTabla(): ArrayList<ProductoModel?>? {
		val lProductoModal = productoServicio!!.listarProductos()
		return lProductoModal
	}
	
	@GetMapping("/producto")
	fun buscarProducto(): ProductoModel? {
		val lProductoModal = productoServicio!!.buscarProducto(1)
		return lProductoModal
	}
}