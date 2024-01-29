package me.dio.credit.applicationsystem.service

import me.dio.credit.applicationsystem.entity.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerID:Long):List<Credit>

    fun findByCreditCode(customerID: Long, creditCode:UUID): Credit

}