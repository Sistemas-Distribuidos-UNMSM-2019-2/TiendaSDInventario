package com.fisi.inventario.service

import com.fisi.inventario.model.OrdenCompraModel

interface KafkaServicio {
	fun enviarMensaje(ordenCompraModel: OrdenCompraModel?)
	fun recibirMensaje(sMensaje: String?): OrdenCompraModel?
}