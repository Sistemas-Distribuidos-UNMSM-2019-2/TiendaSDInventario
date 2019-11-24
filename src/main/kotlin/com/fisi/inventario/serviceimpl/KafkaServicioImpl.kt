package com.fisi.inventario.serviceimpl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import com.google.gson.Gson
import com.fisi.inventario.service.KafkaServicio
import com.fisi.inventario.model.OrdenCompraModel

@Service("kafkaService")
class KafkaServicioImpl : KafkaServicio {
	@Autowired
	private val kafkaTemplate: KafkaTemplate<String, String>? = null
	@Autowired
	private val jsonConverter: Gson? = null

	@Override
	override fun enviarMensaje(ordenCompraModel: OrdenCompraModel?) {
		kafkaTemplate!!.send("inventario", jsonConverter!!.toJson(ordenCompraModel))
	}

	@Override
	override fun recibirMensaje(sMensaje: String?): OrdenCompraModel? {
		val ordenCompraModel = jsonConverter!!.fromJson(sMensaje, OrdenCompraModel::class.java) as OrdenCompraModel
		return ordenCompraModel
	}
}