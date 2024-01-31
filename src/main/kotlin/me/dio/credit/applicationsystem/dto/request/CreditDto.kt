package me.dio.credit.applicationsystem.dto.request

import java.math.BigDecimal
import jakarta.persistence.*
import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.credit.applicationsystem.entity.Credit
import me.dio.credit.applicationsystem.entity.Customer
import me.dio.credit.applicationsystem.enumeration.Status
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.UUID
import kotlin.reflect.KClass

data class CreditDto(
    @field :NotNull(message ="Invalid input") val creditValue: BigDecimal,
    @field:MaxThreeMonths  val dayFirstInstallment: LocalDate,
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

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Constraint(validatedBy = [MaxThreeMonthsValidator::class])
annotation class MaxThreeMonths(
    val message: String = "The date must be in the future and within a maximum period of 3 months",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class MaxThreeMonthsValidator : ConstraintValidator<MaxThreeMonths, LocalDate> {
    override fun isValid(value: LocalDate?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return true // Let @NotNull handle null check
        }
        val currentDate = LocalDate.now()
        val maxDate = currentDate.plus(3, ChronoUnit.MONTHS)
        return value.isAfter(currentDate) && value.isBefore(maxDate)
    }
}
