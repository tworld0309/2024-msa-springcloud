package org.msa.itemservice.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="ITEM")
data class Item (
    @Id
    @Column(name = "ID", length = 30)
    var id: String? = null,

    @Column(name = "ACCOUNT_ID")
    var accountId: String? = null,

    @Column(name = "NAME", length = 30)
    var name: String? = null,

    @Column(name = "DESCRIPTION", length = 30)
    var description: String? = null,

    @Column(name = "ITEM_TYPE", length = 1)
    var itemType: String? = null,

    @Column(name = "CNT", length = 10)
    var count: Long = 0,

    @Column(name = "REG_DTS", length = 14)
    var regDts: String? = null,

    @Column(name = "UPD_DTS", length = 14)
    var updDts: String? = null
) {
    data class Builder (
        var id: String = "",
        var accountId: String? = "",
        var name: String? = "",
        var description: String? = "",
        var itemType: String? = "",
        var count: Long = 0,
        var regDts: String? = "",
        var updDts: String? = "",
    ) {
        fun id(id: String) = apply {this.id = id}
        fun accountId(accountId: String?) = apply {this.accountId = accountId}
        fun name(name: String?) = apply {this.name = name}
        fun description(description: String?) = apply {this.description = description}
        fun itemType(itemType: String?) = apply {this.itemType = itemType}
        fun count(count: Long) = apply {this.count = count}
        fun regDts(regDts: String) = apply {this.regDts = regDts}
        fun updDts(updDts: String) = apply {this.updDts = updDts}
        fun build() =  Item(id, accountId, name, description, itemType, count, regDts, updDts)
    }
}