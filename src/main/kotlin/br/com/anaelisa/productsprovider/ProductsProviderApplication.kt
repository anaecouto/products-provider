package br.com.anaelisa.productsprovider

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@EnableFeignClients
@SpringBootApplication
class ProductsProviderApplication

fun main(args: Array<String>) {
	runApplication<ProductsProviderApplication>(*args)
}
