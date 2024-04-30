package org.msa.itemservice.controller

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.msa.itemservice.data.dto.ItemDTO
import org.msa.itemservice.data.dto.ResponseDTO
import org.msa.itemservice.data.valid.ItemTypeValid
import org.msa.itemservice.service.ItemService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@OpenAPIDefinition(info = Info(title = "물품 처리요청 API", description = "물품 처리요청 API", version = "v1"))
@RestController
@RequestMapping(value = ["v1/item"])
@Slf4j
@RequiredArgsConstructor
@Validated
class ItemController(private val itemService: ItemService) {

    @Operation(summary = "물품등록 요청", description = "물품 등록을 진행할 수 있다.", tags = ["addItem"])
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "SUCCESS"),
        ApiResponse(responseCode = "501", description = "API EXCEPTION")
    )
    @RequestMapping(value = ["/add/{itemType}"], method = [RequestMethod.POST])
    @Throws(
        Exception::class
    )
    fun add(
        @RequestBody itemDTO: @Valid ItemDTO,
        @ItemTypeValid @PathVariable itemType: String
    ): ResponseEntity<ResponseDTO> {
        //ResponseDTO.Builder responseBuilder = new ResponseDTO.Builder();

        /*
		log.debug("path.variable itemType = {}", itemType);
		boolean hasItemType = false;
		ItemType [] itemTypeList = ItemType.values();
		for(ItemType i : itemTypeList) {
			hasItemType = i.hasItemCd(itemType);
			if(hasItemType) break;
		}

		if(!hasItemType) {
			responseBuilder.code("500").message("invalid itemType .[" + itemType + "]");
			return ResponseEntity.ok(responseBuilder.build());
		}else {
			itemDTO.setItemType(itemType);
		}
		try {
			Integer.parseInt("test");
		}catch(Exception e) {
			throw new ApiException("test에러");
		}
		*/

        itemDTO.itemType = itemType

        itemService.insertItem(itemDTO)
        //log.debug("request add item id = {}", itemDTO.id)

        val responseBuilder = ResponseDTO.Builder().code("200").message("success")
        return ResponseEntity.ok(responseBuilder.build())
    }
}