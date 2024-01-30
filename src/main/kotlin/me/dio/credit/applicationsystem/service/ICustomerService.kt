package me.dio.credit.applicationsystem.service

import me.dio.credit.applicationsystem.entity.Customer

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long)

}