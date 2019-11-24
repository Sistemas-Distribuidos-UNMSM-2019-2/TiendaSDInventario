package com.fisi.inventario.controller

import java.io.IOException
import java.io.PrintWriter
import java.util.ArrayList
import java.util.UUID
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.fisi.inventario.serviceimpl.ProductoServicioImpl
import com.fisi.inventario.serviceimpl.KafkaServicioImpl
import com.fisi.inventario.model.OrdenCompraModel

@RestController
@RequestMapping("/")
class OrdenCompraController {
	@Autowired
	@Qualifier("productoService")
	private val productoServicio: ProductoServicioImpl? = null
	@Autowired
	@Qualifier("kafkaService")
	private val kafkaServicio: KafkaServicioImpl? = null

	fun enviarMensaje(ordenCompraModel: OrdenCompraModel?) {
		kafkaServicio!!.enviarMensaje(ordenCompraModel)
	}
	

	@KafkaListener(topics = ["validar"])
	fun listenerKafka(ordenCompra: String?) {
		val ordenCompraModel = kafkaServicio!!.recibirMensaje(ordenCompra)		
		
		for (pos in 0 until ordenCompraModel!!.getlDetalleCompra()!!.count()) {
			val ordenCompraDetalle = ordenCompraModel.getlDetalleCompra()!!.get(pos)
			val producto = productoServicio!!.buscarProducto(ordenCompraDetalle!!.getnCodigoProducto() as Int)
			
			if((ordenCompraDetalle.getnCantidadProducto() as Int) > (producto!!.getnCantidad()  as Int)){
				ordenCompraDetalle.setbExistencia(false);
			}
			
		}
		
		enviarMensaje(ordenCompraModel)		
	}
}