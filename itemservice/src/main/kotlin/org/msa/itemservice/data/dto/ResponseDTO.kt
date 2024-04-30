package org.msa.itemservice.data.dto

data class ResponseDTO(
    var code: String? = null,
    var message: String? = null
) {
    class Builder {
        private var code: String? = null
        private var message: String? = null

        fun code(code: String?) = apply { this.code = code }
        fun message(message: String?) = apply { this.message = message }

        fun build() = ResponseDTO(code, message)
    }

    companion object {
        fun builder() = Builder()
    }
}