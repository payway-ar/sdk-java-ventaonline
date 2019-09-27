package com.decidir.sdk

import com.decidir.sdk.dto.payments.pci.CardTrackInfo
import com.decidir.sdk.dto.refunds.RefundMPOSPayment
import com.decidir.sdk.dto.refunds.RefundPayment
import com.decidir.sdk.dto.refunds.RefundSubPayment
import com.decidir.sdk.dto.refunds.RollbackMPOSPayment
import com.decidir.sdk.exceptions.responses.RefundException
import spock.lang.*
import com.decidir.sdk.dto.*

class RefundServiceTests extends Specification {

  public static final String secretAccessToken = '00290815'//'4cf891e492384cdeadf211564aa87007'
  public static final String apiUrl = "http://localhost:9002"

  def decidir

  def setup(){
    decidir = new Decidir(secretAccessToken, apiUrl, 15)
  }

  def "test payment annulled"() {
    setup:
    def paymentId = 48277
    def refundPayment = new RefundPayment()
    def refundSubPayment = new RefundSubPayment()
    refundSubPayment.id = 7151
    refundPayment.sub_payments = Arrays.asList(refundSubPayment)

    def user = "ccopello"

    when:
    def result = decidir.refundPayment(paymentId, refundPayment, user)

    then:
    then:
    def exception = thrown(RefundException)
    exception.status == 402
    exception.refundPayment.status == Status.REJECTED
    /*result.status == 200
    result.result.id != null
    result.result.amount != null
    result.result.status == Status.ANNULLED*/
  }

  def "test payment refunded"() {
    setup:
    def paymentId = 3247
    def refundPayment = new RefundPayment()
    def user = "ccopello"
    refundPayment.amount = 3

    when:
    def result = decidir.refundPayment(paymentId, refundPayment, user)

    then:
    result.status == 200
    result.result.id != null
    result.result.amount != null
    result.result.status == Status.APPROVED
  }

  def "test payment cancelRefund"() {
    setup:
    def paymentId = 1383
    def refundId = 201
    def user = "ccopello"

    when:
    def result = decidir.cancelRefund(paymentId, refundId, user)

    then:
    result.status == 200
    result.result.amount != null
    result.result.status == Status.APPROVED
  }

  def "test get refunds"() {
    setup:
    def paymentId = 1385

    when:
    def result = decidir.getRefunds(paymentId)

    then:
    result.status == 200
    result.result.parent.history.get(0) != null
  }

  def "test payment refunded with card track info"() {
    setup:
    def paymentId = 10642
    def refundPayment = new RefundMPOSPayment()
    def user = "ccopello"
    refundPayment.amount = 3

    def cardTrackInfo = new CardTrackInfo()
    cardTrackInfo.card_track_1 = "B4507990000004905^Valentin Santiago Gomez^2010datosdiscrecionales"
    cardTrackInfo.card_track_2 = "4507990000004905=2010datosdiscrecionales"
    cardTrackInfo.input_mode = "021"

    refundPayment.card_track_info = cardTrackInfo

    when:
    def result = decidir.refundPayment(paymentId, refundPayment, user)

    then:
    result.status == 201
    result.result.id != null
    result.result.amount != null
    result.result.status == Status.APPROVED
  }

  def "test rollback of refunded payment with card track info"() {
    setup:
    def paymentId = 10642
    def refundId = 300
    def user = "ccopello"
    def rollbackPayment = new RollbackMPOSPayment()

    def cardTrackInfo = new CardTrackInfo()
    cardTrackInfo.card_track_1 = "B4507990000004905^Valentin Santiago Gomez^2010datosdiscrecionales"
    cardTrackInfo.card_track_2 = "4507990000004905=2010datosdiscrecionales"
    cardTrackInfo.input_mode = "021"

    rollbackPayment.setCard_track_info(cardTrackInfo)
    rollbackPayment.security_code = 123

    when:
    def result = decidir.cancelRefund(paymentId, refundId, rollbackPayment, user)

    then:
    result.status == 201
    result.result.id != null
    result.result.amount != null
    result.result.status == Status.APPROVED
  }

}
