package me.dio.credit.applicationsystem.dto

import java.math.BigDecimal
import jakarta.persistence.*
import me.dio.credit.applicationsystem.entity.Credit
import me.dio.credit.applicationsystem.entity.Customer
import me.dio.credit.applicationsystem.enumeration.Status
import java.time.LocalDate
import java.util.UUID

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )
}
