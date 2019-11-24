package com.fisi.inventario.transform

import java.util.ArrayList
import org.springframework.stereotype.Component
import com.fisi.inventario.model.ProductoModel
import com.fisi.inventario.entity.Producto

@Component("productoTransform")
class ProductoTransform : Transform<ProductoModel, Producto> {
	@Override
	public override fun transformME(oModel: ProductoModel?): Producto? {
		if (oModel != null) {
			val oProducto = Producto()
			oProducto.vcodigo = oModel.getnCodigo()
			oProducto.vnombre = oModel.getsNombre()
			oProducto.vdescripcion = oModel.getsDescripcion()
			oProducto.nprecioUnitario = oModel.getnPrecioUnitario()
			oProducto.ncantidad = oModel.getnCantidad()
			
			return oProducto
		}
		return null
	}

	@Override
	public override fun transformME(lModel: List<ProductoModel?>?): ArrayList<Producto?>? {
		if (lModel != null) {
			val lProducto = ArrayList<Producto?>()
			for (auxiliar in lModel) {
				lProducto.add(transformME(auxiliar))
			}
			return lProducto
		}
		return null
	}

	@Override
	public override fun transformEM(oEntity: Producto?): ProductoModel? {
		if (oEntity != null) {
			val oProductoModel = ProductoModel();
			oProductoModel.setnCodigo(oEntity.vcodigo)
			oProductoModel.setsNombre(oEntity.vnombre)
			oProductoModel.setsDescripcion(oEntity.vdescripcion)
			oProductoModel.setnCantidad(oEntity.ncantidad)
			oProductoModel.setnPrecioUnitario(oEntity.nprecioUnitario)
			return oProductoModel
		}
		return null
	}

	@Override
	public override fun transformEM(lEntity: List<Producto?>?): ArrayList<ProductoModel?>? {
		if (lEntity != null) {
			val lProductoModel = ArrayList<ProductoModel?>()
			for (auxiliar in lEntity) {
				var productoModel = transformEM(auxiliar)
				lProductoModel.add(productoModel)
			}
			return lProductoModel
		}
		return null
	}
}