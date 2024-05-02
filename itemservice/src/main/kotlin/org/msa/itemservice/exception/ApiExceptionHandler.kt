package org.msa.item.exception

import jakarta.servlet.http.HttpServletRequest
import org.msa.itemservice.data.dto.ResponseDTO
import org.msa.itemservice.exception.ApiException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(Exception::class)
    @Throws(Exception::class)
    fun Exception(request: HttpServletRequest?, e: Exception): ResponseEntity<*> {
        val responseBuilder: ResponseDTO.Builder = ResponseDTO.builder()
        responseBuilder.code("500").message(e.message)
        return ResponseEntity.ok(responseBuilder.build())
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @Throws(Exception::class)
    fun handleValidationExceptions(ex: MethodArgumentNotValidException): ResponseEntity<*> {
        val bindingResult = ex.bindingResult
        val builder = StringBuilder()
        for (fieldError in bindingResult.fieldErrors) {
            builder.append("[")
            builder.append(fieldError.field)
            builder.append("](은)는 ")
            builder.append(fieldError.defaultMessage)
            builder.append(" 입력된 값: [")
            builder.append(fieldError.rejectedValue)
            builder.append("]")
        }

        val responseBuilder: ResponseDTO.Builder = ResponseDTO.builder()
        responseBuilder.code("500").message(builder.toString())
        return ResponseEntity.ok(responseBuilder.build())
    }

    @ExceptionHandler(ApiException::class)
    @Throws(Exception::class)
    fun ApiException(request: HttpServletRequest?, e: ApiException): ResponseEntity<*> {
        val responseBuilder: ResponseDTO.Builder = ResponseDTO.builder()
        responseBuilder.code("501").message(e.message)
        return ResponseEntity.ok(responseBuilder.build())
    }
}