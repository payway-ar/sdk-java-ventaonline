package com.decidir.sdk

import spock.lang.Specification

/**
 * Created by biandra on 05/10/16.
 */
class CardTokenServiceTests extends Specification {

    public static final String secretAccessToken = '00111115_private'//'4cf891e492384cdeadf211564aa87007'
    public static final String apiUrl = "http://localhost:9002"

    def decidir

    def setup(){
        decidir = new Decidir(secretAccessToken, apiUrl, 15)
    }

    def "test list cardTokens"() {
        setup:
        def userSiteId = 'ivalek'
        def bin = null
        def lastFourDigits = null
        def expirationMonth = null
        def expirationYear = null

        when:
        def result = decidir.getCardTokens(userSiteId, bin, lastFourDigits, expirationMonth, expirationYear)

        then:
        result.status == 200
        result.result.tokens != null
    }

    def "test delete cardTokens"() {
        setup:
        def token = "4d575254-0822-4360-a791-7a6ebf58fee4"

        when:
        def result = decidir.deleteCardToken(token)

        then:
        result.status == 204
        result.message ==  'No Content'
    }
}
