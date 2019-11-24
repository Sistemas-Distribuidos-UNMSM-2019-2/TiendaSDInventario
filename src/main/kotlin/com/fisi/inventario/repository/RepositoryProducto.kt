package com.fisi.inventario.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.fisi.inventario.entity.Producto

@Repository("productoRepository")
interface RepositoryProducto : JpaRepository<Producto, Int> {
	fun findByVcodigo(vcodigo:Int):Producto
}