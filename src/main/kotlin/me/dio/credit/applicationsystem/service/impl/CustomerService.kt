package me.dio.credit.applicationsystem.service.impl

import me.dio.credit.applicationsystem.entity.Customer
import me.dio.credit.applicationsystem.exception.BusinessException
import me.dio.credit.applicationsystem.repository.CustomerRepository
import me.dio.credit.applicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow() { throw BusinessException("Id $id not found")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}
