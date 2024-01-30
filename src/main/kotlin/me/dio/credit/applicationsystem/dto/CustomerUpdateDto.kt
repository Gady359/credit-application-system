package me.dio.credit.applicationsystem.dto

import me.dio.credit.applicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val fistName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.fistName = this.fistName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode

        return customer
    }
}
