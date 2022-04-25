package br.com.anaelisa.productsprovider.controller

import br.com.anaelisa.productsprovider.resource.ProductsResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProductsController(@Autowired private val productsResource: ProductsResource) {

    @PostMapping("")
    fun create(@RequestParam zipCode: String): ResponseEntity<Unit> {
        return ResponseEntity.ok(productsResource.readFromExcelFile(zipCode))
    }

}
