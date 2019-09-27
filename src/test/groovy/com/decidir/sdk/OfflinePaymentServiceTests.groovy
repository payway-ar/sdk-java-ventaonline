package com.decidir.sdk

import com.decidir.sdk.dto.payments.Currency
import com.decidir.sdk.dto.payments.Identification
import com.decidir.sdk.dto.payments.IdentificationType
import com.decidir.sdk.dto.payments.offline.OfflineCustomer
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequest
import com.decidir.sdk.dto.payments.PaymentRequest
import com.decidir.sdk.dto.payments.PaymentType
import com.decidir.sdk.dto.Status
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequestPCI
import spock.lang.Specification

class OfflinePaymentServiceTests extends Specification {

    public static final String secretAccessToken = '28464383'//'660b244e41bf404b821789c0113c6337'
    public static final String token = "12513a94-6b86-4c33-ba17-6ae6d13f2c77"
    public static final String apiUrl = "http://localhost:9002"

    def decidir

    def setup() {
        decidir = new Decidir(secretAccessToken, apiUrl, 30)
    }

    def "test PMC payment"() {
        setup:

        def payment = new PaymentRequest()
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.token = token
        payment.payment_method_id = 41
        payment.amount = 5000
        payment.currency = Currency.ARS
        payment.payment_type = PaymentType.SINGLE
        payment.email = "persona@email.com"
        payment.bank_id = 1
        payment.invoice_expiration = "311219 2359"

        when:
        def result = decidir.payment(payment)

        then:
        result.status == 201
        result.result.status == Status.INVOICE_GENERATED
    }

    def "test offline payment"() {
        setup:
        def offline = new OfflinePaymentRequest()
        offline.site_transaction_id = UUID.randomUUID().toString()
        offline.token = token
        offline.payment_method_id = 25
        offline.amount = 5000
        offline.currency = Currency.ARS
        offline.payment_type = PaymentType.SINGLE
        offline.email = "persona@email.com"
        offline.invoice_expiration = "191223"
//        offline.cod_p1 = "123"
//        offline.cod_p2 = "1123"
        offline.cod_p3 = "11"
        offline.cod_p4 = "123"
        offline.client = "12345678"
        offline.surcharge = 100l

        when:
        def result = decidir.offlinePayment(offline)

        then:
        result.status == 201
        result.result.status == Status.INVOICE_GENERATED
        //Si no se cambia los datos previos
        result.result.barcode == "67800121234567823968498191223000050001100001001237"
    }

    def "test PCI offline payment"() {
        setup:
        def offlinePCI = new OfflinePaymentRequestPCI()

        def offlineCustomer = new OfflineCustomer()
        def identification = new Identification()
        identification.type = IdentificationType.DNI
        identification.number = '33333333'
        offlineCustomer.identification = identification
        offlineCustomer.name = "NOMBRE APELLIDO"

        offlinePCI.site_transaction_id = UUID.randomUUID().toString()
//        offlinePCI.offlinePaymentRequest.token = token
        offlinePCI.payment_method_id = 25
        offlinePCI.amount = 5000
        offlinePCI.currency = Currency.ARS
        offlinePCI.payment_type = PaymentType.SINGLE
        offlinePCI.email = "persona@email.com"
        offlinePCI.invoice_expiration = "191223"
        offlinePCI.cod_p3 = "11"
        offlinePCI.cod_p4 = "123"
        offlinePCI.client = "12345678"
        offlinePCI.surcharge = 100l

        offlinePCI.customer = offlineCustomer

        when:
        def result = decidir.offlinePCIPayment(offlinePCI)

        then:
        result.status == 201
        result.result.status == Status.INVOICE_GENERATED
        //Si no se cambia los datos previos
        result.result.barcode == "67800121234567833333333191223000050001100001001230"
    }
}
