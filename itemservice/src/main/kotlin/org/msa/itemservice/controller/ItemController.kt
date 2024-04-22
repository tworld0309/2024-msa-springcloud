package org.msa.itemservice.controller

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.msa.itemservice.data.dto.ItemDTO
import org.msa.itemservice.data.dto.ResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

//@OpenAPIDefinition(info = @Info(title = "물품 처리요청 API", description = "물품 처리요청 API", version = "v1"))
@RestController
@RequestMapping("v1/item")
@RequiredArgsConstructor
@Validated
class ItemController {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    @PostMapping("/add")
    fun add(@RequestBody itemDTO: ItemDTO): ResponseEntity<ResponseDTO> {
        val responseBuilder: ResponseDTO.ResponseDTOBuilder = ResponseDTO.ResponseDTOBuilder()

        log.debug("request add item id = {}", itemDTO.id)

        responseBuilder.code("200").message("success")
        return ResponseEntity.ok(responseBuilder.build())
    }

}