package com.fisi.inventario.serviceimpl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import com.fisi.inventario.repository.RepositoryProducto
import com.fisi.inventario.transform.ProductoTransform
import java.util.ArrayList
import com.fisi.inventario.model.ProductoModel
import com.fisi.inventario.service.ProductoServicio

@Service("productoService")
class ProductoServicioImpl : ProductoServicio {
	@Autowired
	@Qualifier("productoRepository")
	private val productoRepository: RepositoryProducto? = null
	@Autowired
	@Qualifier("productoTransform")
	private val productoTransform: ProductoTransform? = null

	@Override
	override fun listarProductos(): ArrayList<ProductoModel?>? {
		return productoTransform!!.transformEM(productoRepository!!.findAll())
	}

	@Override
	override fun buscarProducto(nCodigoProducto: Int): ProductoModel? {
		return productoTransform!!.transformEM(productoRepository!!.findByVcodigo(nCodigoProducto))
	}
	
}