package org.msa.itemservice.data.dto


data class ItemDTO (
    val id: String,
    val name: String? = null,
    val description: String? = null,
    var itemType: String? = null,
    val count: Long,
    val regDts: String? = null,
    val updDts: String? = null
)