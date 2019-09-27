package com.decidir.sdk

import com.decidir.sdk.dto.payments.Currency
import com.decidir.sdk.dto.payments.Customer
import com.decidir.sdk.dto.forms.DataForm
import com.decidir.sdk.dto.forms.PaymentForm
import com.decidir.sdk.dto.payments.PaymentType
import com.decidir.sdk.dto.forms.SiteForm
import spock.lang.Specification

/**
 * Created by biandra on 19/06/17.
 */
class FormServiceTests extends Specification {

    public static final String secretAccessToken = '00290815'
    public static final String apiUrl = "http://localhost:9006"

    def form

    def setup(){
        form = new Form(secretAccessToken, apiUrl, 2)
    }

    def "validate"() {
        setup:
        def siteForm = new SiteForm()
        siteForm.transaction_id = UUID.randomUUID().toString()
        def customer = new Customer()
        customer.id = "maxi"
        customer.email = "maxi@gmail.com"
        def payment = new PaymentForm()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.sub_payments = []

        def dataForm = new DataForm()
        dataForm.site = siteForm
        dataForm.customer = customer
        dataForm.payment = payment
        dataForm.success_url = "success_url"
        dataForm.cancel_url = "cancel_url"

        when:
        def result = form.validate(dataForm)

        then:
        result.status == 201
        result.result.hash != null
    }
}
