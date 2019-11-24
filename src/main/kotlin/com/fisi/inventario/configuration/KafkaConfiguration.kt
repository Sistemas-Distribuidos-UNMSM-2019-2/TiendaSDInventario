package com.fisi.inventario.configuration

import java.util.HashMap
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import com.google.gson.Gson

@Configuration
@EnableKafka
class KafkaConfiguration {
	@Bean
	fun producerFactory(): ProducerFactory<String, String>? {
		val config = HashMap<String?, Any?>()
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
		return DefaultKafkaProducerFactory(config)
	}

	@Bean
	fun kafkaTemplate(): KafkaTemplate<String, String>? {
		return KafkaTemplate(producerFactory())
	}

	@Bean
	fun consumerFactory(): ConsumerFactory<String, String>? {
		val config = HashMap<String?, Any?>()
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroupId")
		return DefaultKafkaConsumerFactory(config, StringDeserializer(), StringDeserializer())
	}

	@Bean
	fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String>? {
		val concurrentKafkaListenerContainerFactory: ConcurrentKafkaListenerContainerFactory<String, String> = ConcurrentKafkaListenerContainerFactory()
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory())
		return concurrentKafkaListenerContainerFactory
	}

	@Bean
	fun jsonConverter(): Gson? {
		return Gson()
	}
}