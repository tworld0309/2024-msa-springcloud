package org.msa.itemservice.service

import lombok.RequiredArgsConstructor
import org.msa.itemservice.data.dto.ItemDTO
import org.msa.itemservice.data.entity.Item
import org.msa.itemservice.data.repository.ItemRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*


@Service
@RequiredArgsConstructor
class ItemService (private val itemRepository: ItemRepository) {
    private val log = LoggerFactory.getLogger(this.javaClass)!!

    fun insertItem(itemDTO : ItemDTO) {

        val form = SimpleDateFormat("yyyyMMddHHmmss")
        val date = form.format(Date())

        val item: Item = Item.Builder()
            .id(itemDTO.id)
            .name(itemDTO.name)
            .description(itemDTO.description)
            .itemType(itemDTO.itemType)
            .count(itemDTO.count)
            .regDts(date)
            .updDts(date)
            .build()
        itemRepository.save(item)
    }
}