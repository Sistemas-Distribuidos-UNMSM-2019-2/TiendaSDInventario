package com.fisi.inventario.transform

/**
 * @param <T1> Model
 * @param <T2> Entity
 */
interface Transform<T1, T2> {
	fun transformME(oModel: T1?): T2?
	fun transformME(lModel: List<T1?>?): ArrayList<T2?>?
	fun transformEM(oEntity: T2?): T1?
	fun transformEM(lEntity: List<T2?>?): ArrayList<T1?>?
}