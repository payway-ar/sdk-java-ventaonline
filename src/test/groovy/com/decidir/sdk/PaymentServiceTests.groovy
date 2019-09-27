package com.decidir.sdk

import com.decidir.sdk.dto.cybersource.BillingData
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequest
import com.decidir.sdk.dto.payments.pci.CardData
import com.decidir.sdk.dto.payments.pci.CardFraudDetectionData
import com.decidir.sdk.dto.payments.pci.CardTokenData
import com.decidir.sdk.dto.payments.pci.CardTrackInfo
import com.decidir.sdk.dto.cybersource.Channel
import com.decidir.sdk.dto.payments.Currency
import com.decidir.sdk.dto.payments.Customer
import com.decidir.sdk.dto.forms.CustomerInSite
import com.decidir.sdk.dto.cybersource.verticals.travels.DayOfWeekOfFlight
import com.decidir.sdk.dto.cybersource.verticals.travels.DecisionManagerTravel
import com.decidir.sdk.dto.cybersource.verticals.travels.DepartureDate
import com.decidir.sdk.dto.cybersource.FraudDetectionDataResponse
import com.decidir.sdk.dto.payments.Identification
import com.decidir.sdk.dto.payments.IdentificationType
import com.decidir.sdk.dto.cybersource.Item
import com.decidir.sdk.dto.cybersource.verticals.travels.JourneyType
import com.decidir.sdk.dto.cybersource.verticals.travels.Passenger
import com.decidir.sdk.dto.cybersource.verticals.travels.PassengerStatus
import com.decidir.sdk.dto.cybersource.verticals.travels.PassengerType
import com.decidir.sdk.dto.payments.PaymentRequest
import com.decidir.sdk.dto.payments.pci.PaymentPciRequest
import com.decidir.sdk.dto.payments.pci.PaymentPciTokenRequest
import com.decidir.sdk.dto.payments.PaymentType
import com.decidir.sdk.dto.cybersource.PurchaseTotals
import com.decidir.sdk.dto.Status
import com.decidir.sdk.dto.cybersource.verticals.ticketing.TicketingFraudDetectionData
import com.decidir.sdk.dto.cybersource.verticals.ticketing.TicketingTransactionData
import com.decidir.sdk.dto.cybersource.verticals.travels.TravelFraudDetectionData
import com.decidir.sdk.dto.cybersource.verticals.travels.TravelTransactionData
import com.decidir.sdk.exceptions.responses.PaymentException
import com.decidir.sdk.exceptions.ValidateException
import spock.lang.Specification

/**
 * Created by biandra on 05/10/16.
 */
class PaymentServiceTests extends Specification {

    public static final String secretAccessToken = '00111115'; //'781d3b4ed99d4ef6ab94a2f5d923d401'//'4cf891e492384cdeadf211564aa87007'
    public static final String token = "0748b6e8-e2aa-4d9c-b303-a67ce2c2b4d0"
    public static final String valid_bin = "450979"
    public static final String user_id = "decidir_test"
    public static final String apiUrl = "http://localhost:9002/"


    def decidir
    def billTo
    def purchaseTotals
    def customerInSite
    def ticketingTransactionData

    def setup(){
        decidir = new Decidir(secretAccessToken, apiUrl, 30)
        billTo = new BillingData()
        billTo.city = "Buenos Aires"
        billTo.country = "AR"
        billTo.customer_id = "maxiid"
        billTo.email = "accept@decidir.com.ar"
        billTo.first_name = "Maxi"
        billTo.last_name = "Biandratti"
        billTo.phone_number = "1547766329"
        billTo.postal_code = "1414"
        billTo.state = "BA"
        billTo.street1 = "THAMES 677"

        purchaseTotals = new PurchaseTotals()
        purchaseTotals.currency = Currency.ARS
        purchaseTotals.amount = 12444

        customerInSite = new CustomerInSite()
        customerInSite.days_in_site = 243
        customerInSite.is_guest = false
        customerInSite.password = "abracadabra"
        customerInSite.num_of_transactions = 1
        customerInSite.cellphone_number = "12121"

        ticketingTransactionData = new TicketingTransactionData()
        ticketingTransactionData.days_to_event = 55
        ticketingTransactionData.delivery_type = "Pick up"
        def item = new Item()
        item.code = "popblacksabbat2016"
        item.description = "Popular Black Sabbath 2016"
        item.name = "popblacksabbat2016ss"
        item.sku = "asas"
        item.total_amount = 242424
        item.quantity = 2
        item.unit_price = 121212
        ticketingTransactionData.items = Arrays.asList(item)

    }

    def "test payment with CS black error"() {
        setup:
        def fraudDetection = new TicketingFraudDetectionData()
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.ticketing_transaction_data = ticketingTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.token = token
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = valid_bin
        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection


        when:
        decidir.payment(payment)

        then:
        def exception = thrown(PaymentException)
        exception.status == 402
        exception.payment.status == Status.REJECTED
        ((FraudDetectionDataResponse)exception.payment.fraud_detection).status.decision == "black"
        exception.payment.fraud_detection.status.reason_code == "-1"
        exception.payment.fraud_detection.status.description == "validation"
        exception.payment.fraud_detection.status.details.error_type == "invalid_request_error"
        exception.payment.fraud_detection.status.details.validation_errors.get(0).code == "missing"
        exception.payment.fraud_detection.status.details.validation_errors.get(0).param == "bill_to"
    }

    def "test confirmPayment valid"() {
        setup:
        def fraudDetection = new TicketingFraudDetectionData()
        fraudDetection.bill_to = billTo
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.ticketing_transaction_data = ticketingTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.token = token
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = valid_bin
        //payment.site_id=
        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection


        when:
        def result = decidir.payment(payment)

        then:
        result.status == 201
        result.result.status == Status.APPROVED
        result.result.fraud_detection.status.decision == "green"
        result.result.fraud_detection.status.reason_code == "100"
        result.result.fraud_detection.status.description == "Decision Manager processing"
    }

    def "test confirmPayment PCI with CardData valid"() {
        setup:
        def fraudDetection = new TicketingFraudDetectionData()
        fraudDetection.bill_to = billTo
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.ticketing_transaction_data = ticketingTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentPciRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = valid_bin

        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection

        def cardData = new CardData()
        cardData.card_number= "4507990000004905"
        cardData.card_expiration_month = "04"
        cardData.card_expiration_year = "20"
        cardData.security_code = "123"
        cardData.card_holder_name ="Juan"

        def cardFraudDetectionData = new CardFraudDetectionData()
        cardFraudDetectionData.device_unique_identifier ="12345"
        cardData.fraud_detection = cardFraudDetectionData

        def cardHolderIdentification = new Identification()
        cardHolderIdentification.number =  "23968498"
        cardHolderIdentification.type = IdentificationType.DNI
        cardData.card_holder_identification = cardHolderIdentification

        payment.card_data = cardData

        when:
        def result = decidir.payment(payment)

        then:
        result.status == 201
        result.result.status == Status.APPROVED
        result.result.fraud_detection.status.decision == "green"
        result.result.fraud_detection.status.reason_code == "100"
        result.result.fraud_detection.status.description == "Decision Manager processing"
    }

    def "test confirmPayment PCI with valid CardTrack Info"() {
        setup:
        def fraudDetection = new TicketingFraudDetectionData()
        fraudDetection.bill_to = billTo
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.ticketing_transaction_data = ticketingTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentPciRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = valid_bin

        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection

        def cardTrackInfo = new CardTrackInfo()
        cardTrackInfo.card_track_1 = "B4507990000004905^Valentin Santiago Gomez^2010datosdiscrecionales"
        cardTrackInfo.card_track_2 = "4507990000004905=2010datosdiscrecionales"
        cardTrackInfo.input_mode = "021"

        def cardData = new CardData()
        //cardData.card_number= "4507990000004905"
        //cardData.card_expiration_month = "04"
        //cardData.card_expiration_year = "20"
        cardData.security_code = "123"
        //cardData.card_holder_name ="Juan"
        cardData.card_track_info = cardTrackInfo

        def cardFraudDetectionData = new CardFraudDetectionData()
        cardFraudDetectionData.device_unique_identifier ="12345"
        cardData.fraud_detection = cardFraudDetectionData

        def cardHolderIdentification = new Identification()
        cardHolderIdentification.number =  "23968498"
        cardHolderIdentification.type = IdentificationType.DNI
        cardData.card_holder_identification = cardHolderIdentification

        payment.card_data = cardData

        when:
        def result = decidir.payment(payment)

        then:
        result.status == 201
        result.result.status == Status.APPROVED
    }

    def "test confirmPayment PCI with CardTokenData valid"() {
        setup:
        def fraudDetection = new TicketingFraudDetectionData()
        fraudDetection.bill_to = billTo
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.ticketing_transaction_data = ticketingTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentPciTokenRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = valid_bin
        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection

        def cardTokenData = new CardTokenData()
        cardTokenData.token= "c1c7470d-4c22-4656-940a-d159075f52b3"
        cardTokenData.security_code = "123"

        def cardFraudDetectionData = new CardFraudDetectionData()
        cardFraudDetectionData.device_unique_identifier ="12345"
        cardTokenData.fraud_detection = cardFraudDetectionData


        payment.card_token_data = cardTokenData
        when:
        def result = decidir.payment(payment)

        then:
        result.status == 201
        result.result.status == Status.APPROVED
        result.result.fraud_detection.status.decision == "green"
        result.result.fraud_detection.status.reason_code == "100"
        result.result.fraud_detection.status.description == "Decision Manager processing"
    }


    def "test confirmPayment with ValidateException"() {
        setup:
        def fraudDetection = new TicketingFraudDetectionData()
        fraudDetection.bill_to = billTo
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.ticketing_transaction_data = ticketingTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.token = token
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = "123456"
        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection

        when:
        decidir.payment(payment)

        then:
        def exception = thrown(ValidateException)
        exception.status == 400
        exception.errorDetail.error_type == "invalid_request_error"
        exception.errorDetail.validation_errors.get(0).code == "Payment"
        exception.errorDetail.validation_errors.get(0).param == "bin"
        exception.message == "Bad Request"
    }

    def "test list of payments"() {
        when:
        def decidirResponse = decidir.getPayments(null, null, null, null)

        then:
        decidirResponse.status == 200
        decidirResponse.result != null
        decidirResponse.message == "OK"
    }
    
    def "test get payment"() {
        when:
        def payments = decidir.getPayments(null, null, null, null)
        def payment = decidir.getPayment(payments.result.results[0].id)

        then:
        payment != null
        payment.result.amount == payments.result.results[0].amount
    }
    
    
    def "test confirmPayment valid  with vertical Travel"() {
        setup:
       
        def travelTransactionData = new TravelTransactionData()
		travelTransactionData.reservation_code = "GJH784"
		travelTransactionData.third_party_booking = false
		travelTransactionData.departure_city = "EZE"
		travelTransactionData.final_destination_city = "HND"
		travelTransactionData.international_flight = true
		travelTransactionData.frequent_flier_number = "00000123"
		travelTransactionData.class_of_service = "class" 
		travelTransactionData.day_of_week_of_flight = DayOfWeekOfFlight.TUESDAY
		travelTransactionData.week_of_year_of_flight = 5
		travelTransactionData.airline_code = "AA"
		travelTransactionData.code_share = "SKYTEAM"
		
		def decisionManagerTravel = new DecisionManagerTravel()
		decisionManagerTravel.complete_route = "EZE-LAX:LAX-HND"
		decisionManagerTravel.journey_type = JourneyType.ONE_WAY
        def departureDate = new DepartureDate()
		departureDate.departure_time = new Date()
        departureDate.departure_zone= "GMT-0300"
        decisionManagerTravel.departure_date = departureDate
        travelTransactionData.decision_manager_travel = decisionManagerTravel
		
		
		def passenger = new Passenger()
		passenger.email = "juan@mail.com"
		passenger.first_name = "Juan"
		passenger.last_name = "Perez"
		passenger.passport_id = "412314851231"
		passenger.phone = "541134356768"
		passenger.passenger_status = PassengerStatus.GOLD
		passenger.passenger_type = PassengerType.SENIOR_CITIZEN
		
		
        travelTransactionData.passengers = Arrays.asList(passenger)
        travelTransactionData.airline_number_of_passengers = 5
        
        
        def fraudDetection = new TravelFraudDetectionData()
        fraudDetection.bill_to = billTo
        fraudDetection.purchase_totals = purchaseTotals
        fraudDetection.channel = Channel.WEB
        fraudDetection.customer_in_site = customerInSite
        fraudDetection.device_unique_id = "devicefingerprintid"
        fraudDetection.travel_transaction_data = travelTransactionData

        def customer = new Customer()
        customer.id = user_id

        def payment = new PaymentRequest()
        payment.payment_type = PaymentType.SINGLE
        payment.currency = Currency.ARS
        payment.amount = 5
        payment.token = "44b3915c-6135-4da2-9665-a25f0823bb57"
        payment.customer = customer
        payment.installments = 7
        payment.sub_payments = []
        payment.site_transaction_id = UUID.randomUUID().toString()
        payment.bin = "450979"
        //payment.site_id=
        payment.payment_method_id = 1
        payment.fraud_detection = fraudDetection


        when:
        def result = decidir.payment(payment)

        then:
        result.status == 201
        result.result.status == Status.APPROVED
        result.result.fraud_detection.status.decision == "green"
        result.result.fraud_detection.status.reason_code == "100"
        result.result.fraud_detection.status.description == "Decision Manager processing"
    }

    def "test offline"() {
        setup:

        def payment = new OfflinePaymentRequest()
        payment.site_transaction_id = "00000045"
        payment.token = "3a392c0c-3ed9-4d5e-8ec1-0dfa2eccecf6"
        payment.payment_method_id = 48
        payment.amount = 5
        payment.currency = Currency.ARS
        payment.payment_type = PaymentType.SINGLE
        payment.email = "max@gmail.com"
        payment.invoice_expiration = "191123"
        payment.cod_p3 = "1"
        payment.cod_p4 = "134"
        payment.client = "12345678"
        payment.surcharge = 1001
        payment.second_invoice_expiration = "191223"


        when:
        def result = decidir.offlinePayment(payment)

        then:
        result.status == 201
        result.result.status == Status.APPROVED
    }
}
