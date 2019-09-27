package com.decidir.sdk

import com.decidir.sdk.dto.Status
import spock.lang.Specification

/**
 * Created by biandra on 25/11/16.
 */
class PaymentConfirmServiceTests extends Specification {

    public static final String secretAccessToken = '00111115_private'//'4cf891e492384cdeadf211564aa87007'
    public static final String apiUrl = "http://localhost:9002"

    def decidir

    def setup(){
        decidir = new Decidir(secretAccessToken, apiUrl, 15)
    }

    def "test confirm payment"() {
        setup:
        def paymentId = 657
        def paymentNewAmount = 200L

        when:
        def result = decidir.confirmPayment(paymentId, paymentNewAmount, user)

        then:
        result.status == 200
        result.result.id != null
        result.result.amount != null
        result.result.status == Status.APPROVED
    }


}
