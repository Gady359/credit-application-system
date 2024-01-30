package me.dio.credit.applicationsystem.exception

data class BusinessException(override val message: String?): RuntimeException(message) {
}