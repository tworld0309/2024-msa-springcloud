package org.msa.itemservice.data.constant

enum class ItemType(private val cd: String, private val desc: String) {
    FOOD("F", "음식"),
    CLOTHES("C", "옷");

    fun hasItemCd(cd: String): Boolean {
        return this.cd == cd
    }
}
