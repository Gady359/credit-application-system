package me.dio.credit.applicationsystem.dto

import java.math.BigDecimal
import jakarta.persistence.*
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.credit.applicationsystem.entity.Credit
import me.dio.credit.applicationsystem.entity.Customer
import me.dio.credit.applicationsystem.enumeration.Status
import java.time.LocalDate
import java.util.UUID

data class CreditDto(
    @field :NotNull(message ="Invalid input") val creditValue: BigDecimal,
    @field :Future val dayFirstInstallment: LocalDate,
    @field :Min(value = 1, message = "Number of installments cannot be zero")
    @field:Max(value = 48, message = "Number of installments cannot be greater than 48")
    val numberOfInstallments: Int,
    @field :NotNull(message ="Invalid input") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )
}
