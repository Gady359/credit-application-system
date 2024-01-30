package me.dio.credit.applicationsystem.exception

import java.time.LocalDateTime

data class ExceptionDetails(
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exeption: String,
    val details: MutableMap<String, String?>
) {
}