package me.dio.credit.applicationsystem.dto

import me.dio.credit.applicationsystem.entity.Address
import me.dio.credit.applicationsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    val fistName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {

    fun toEntity(): Customer = Customer(
        fistName = this.fistName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )


    )

}
