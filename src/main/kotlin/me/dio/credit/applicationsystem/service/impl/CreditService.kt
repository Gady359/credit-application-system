package me.dio.credit.applicationsystem.service.impl

import me.dio.credit.applicationsystem.entity.Credit
import me.dio.credit.applicationsystem.repository.CreditRepository
import me.dio.credit.applicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerID: Long): List<Credit> =
        this.creditRepository.findAllByCustumerId(customerID)

    override fun findByCreditCode(customerID: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode $creditCode not found"))
        return if (credit.customer?.id == customerID) credit else throw RuntimeException("Contact admin")
    }
}