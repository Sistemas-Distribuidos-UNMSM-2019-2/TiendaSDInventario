package com.fisi.inventario

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
//@EnableJpaRepositories(basePackages = arrayOf("com.fisi.inventario.repository"))
//@EntityScan(basePackages= arrayOf("com.fisi.inventario.entity"))
open class InventarioApplication

fun main(args: Array<String>) {
	runApplication<InventarioApplication>(*args)
}
