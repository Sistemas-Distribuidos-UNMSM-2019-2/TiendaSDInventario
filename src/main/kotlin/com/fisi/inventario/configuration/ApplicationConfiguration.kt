package com.fisi.inventario.configuration

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan(basePackages = arrayOf("com.fisi.inventario"))
@Import(value = arrayOf(RepositoryConfiguration::class) )
open class ApplicationConfiguration