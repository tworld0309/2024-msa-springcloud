package org.msa.itemservice.controller

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@OpenAPIDefinition(info = @Info(title = "물품 처리요청 API", description = "물품 처리요청 API", version = "v1"))
@RestController
@RequestMapping(value="v1/item")
@Slf4j
@RequiredArgsConstructor
@Validated
class ItemController {
}