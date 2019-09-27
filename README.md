<a name="inicio"></a>
Decidir SDK Java
===============

Modulo para conexión con gateway de pago DECIDIR2
+ [Introducción](#introduccion)
  + [Soporte de Integración](#Soporte)
  + [Alcance](#scope)
  + [Diagrama de secuencia](#secuencia)
+ [Instalación](#instalacion)
  + [Versiones de Java soportadas](#versionesdejavasoportadas)
  + [Ambientes](#environments)
+ [Uso](#uso)
  + [Inicializar la clase correspondiente al conector](#initconector)
  + [Operatoria del Gateway](#operatoria)
    + [Ejecución del Pago](#payment)
      + [Transacción simple](#single)
      + [Transacción PCI](#pci)
      + [Transacción GDS](#gds)
      + [Transacción GDS PCI](#gdspci)
      + [Transacción BSA PCI](#bsapci)
      + [Transacción BSA no PCI](#bsanopci)
      + [Transacción Agro no PCI](#agronopci)
      + [Transacción distribuida](#distributed)
      + [Operación en dos pasos](#twosteps)
      <!--- + [Transacción de Pagos VTE VISA](#pagoAgregador)(TODO) -->
      <!--- + [Transacción de Comercio Agregador](#pagoAgregador)(TODO) -->
      <!--- + [Transacción Offline](#pagoOffline) (TODO) -->
      <!--- + [Transacción PMC](#pagoPMC)(TODO) -->
    + [Listado de Pagos](#getallpayments)
    + [Información de un Pago](#getpaymentinfo)
    + [Devoluciones de pagos](#refunds)
      + [Anulación / Devolución Total de Pago](#totalrefund)
      + [Anulación de Devolución Total](#deleterefund)
      + [Devolución Parcial de un Pago](#partialrefund)
      + [Anulación de Devolución Parcial](#deletepartialrefund)
      <!--- + [Historial de Devoluciones](#historyrefund) (TODO) -->
  + [Tokenización de tarjetas de crédito](#tokenizaciontarjeta)
    + [Listado de tarjetas tokenizadas](#listadotarjetastokenizadas)
    + [Ejecución de pago tokenizado](#pagotokenizado)
    + [Eliminación de tarjeta tokenizada](#eliminartarjetatokenizada)
  + [Integración con Cybersource](#cybersource)
    + [Parámetros Comunes](#parametros-comunes)
    + [Retail](#retail)
    + [Ticketing](#ticketing)
    + [Digital Goods](#digital-goods)
    + [Travel](#travel)
  + [Uso de Responses](#usoResponses)
  + [Manejo de Excepciones](#manejoExceptions)
    + [PaymentException](#paymentException)
    + [DecidirException](#decidirException)
    	+ [ValidateStatusException](#validateStatusException)
      + [ValidateException](#validateException)
      + [ApiException](#apiException)
      + [NotFoundException](#notFoundException)
    + [RefundException](#refundException)
    + [AnnulRefundException](#annulRefundException)
+ [Tablas de referencia](#tablasreferencia)
  + [Códigos de Medios de Pago](#codigos-de-medios-de-pago)
  + [Divisas Aceptadas](#divisasa)
  + [Provincias](#provincias)
  + [Parámetros](#parametros)
    + [Parámetros de Pagos](#parametrosPago)
        + [Parámetros para PagoMisCuentas](#parametrosPMC)
        + [Parámetros para Pago Offline](#parametrosOffline)
        + [Parámetros para Pago Distribuido por Monto](#parametrosDistMonto)
        + [Parámetros para Pago Distribuido por Porcentaje](#parametrosDistPorc)
        + [Parámetros de Comercio Agregador](#parametrosAgregador)
    + [Parámetros de Devolución](#parametrosDevolucion)
  + [Atributos de Excepciones](#atributosExcepciones)
  + [Errores de Sistema](#erroresSistema)

<a name="introduccion"></a>
## Introducción
El flujo de una transacción a través de las **sdks** consta de dos pasos, la **generaci&oacute;n de un token de pago** por parte del cliente y el **procesamiento de pago** por parte del comercio. Existen sdks espec&iacute;ficas para realizar estas funciones en distintos lenguajes que se detallan a continuaci&oacute;n:

+ **Generaci&oacute;n de un token de pago.**  Se utiliza alguna de las siguentes **sdks front-end** :
  + [sdk IOS](https://github.com/decidir/sdk-ios-v2)
  + [sdk Android](https://github.com/decidir/sdk-android-v2)
  + [sdk Javascript](https://github.com/decidir/sdk-javascript-v2)
+ **Procesamiento de pago.**  Se utiliza alguna de las siguentes **sdks back-end** :
  + [sdk Java](https://github.com/decidir/sdk-java-v2)
  + [sdk PHP](https://github.com/decidir/sdk-php-v2)
  + [sdk .Net](https://github.com/decidir/sdk-.net-v2)
  + [sdk Node](https://github.com/decidir/sdk-node-v2)


[<sub>Volver a inicio</sub>](#inicio)

<a name="scope"></a>
## Alcance
La **sdk Java** provee soporte para su **aplicaci&oacute;n back-end**, encargandose de la comunicaci&oacute;n del comercio con la **API Decidir** utilizando su **API Key privada**<sup>1</sup> y el **token de pago** generado por el cliente.

Para generar el token de pago, la aplicaci&oacute;n cliente realizar&aacute; con **Decidir** a trav&eacute;s de alguna de las siguentes **sdks front-end**:
+ [sdk IOS](https://github.com/decidir/sdk-ios-v2)
+ [sdk Android](https://github.com/decidir/sdk-android-v2)
+ [sdk Javascript](https://github.com/decidir/sdk-javascript-v2)

![imagen de sdks](./docs/img/DiagramaSDKs.png)</br>

---
<sup>_1 - Las API Keys serán provistas por el equipo de Soporte de DECIDIR (soporte@decidir.com.ar). _</sup>
<a name="Soporte"></a>
## Soporte de Integración
**DECIDIR** ofrece un servicio de Soporte 24x7 con el siguiente alcance:
•	Lunes a Viernes de 9 a 18 horas: Soporte Técnico, Atención Comercial y Soporte Transaccional.
•	Fuera de Horario Laboral: Soporte Transaccional.
**CANALES DE ATENCIÓN**
•	Teléfono: +54 11 4379 3460
•	Formulario de Contacto: click aquí
•	Help Desk: soporte@decidir.com.ar
•	Control de Red: controldered@decidir.com.ar (en caso de disrupción transaccional)

[<sub>Volver a inicio</sub>](#inicio)

<a name="secuencia"></a>

## Diagrama de secuencia
El flujo de una transacción a través de las **sdks** consta de dos pasos, a saber:

1. **sdk front-end:** Se realiza una solicitud de token de pago con la Llave de Acceso pública (public API Key), enviando los datos sensibles de la tarjeta (PAN, mes y año de expiración, código de seguridad, titular, y tipo y número de documento) y obteniéndose como resultado un token que permitirá realizar la transacción posterior.

2. **sdk back-end:** Se ejecuta el pago con la Llave de Acceso privada (private API Key), enviando el token generado en el Paso 1 más el identificador de la transacción a nivel comercio, el monto total, la moneda y la cantidad de cuotas.

A continuación, se presenta un diagrama con el Flujo de un Pago.

![imagen de configuracion](./docs/img/FlujoPago.png)</br>

[<sub>Volver a inicio</sub>](#inicio)

<a name="instalacion"></a>
## Instalaci&oacute;n
Se encuentran disponibles *2* implementaciones para la &uacute;ltima versi&oacute;n. Una es compatible con __Java7__ _(o superior)_ y la otra con __Java6__ _(o superior)_.
Se puede realizar la integración a través de un manager de dependencias, o bien manualmente descargando el _JAR_ desde [Github](https://github.com).
 
### Java 7+
#### Manager de dependencias
+  __repositoryUrl:__ _http://repo.dev.redbee.io/content/repositories/decidir-sdk/_
+  __groupId:__ _com.decidir.api_
+  __artifactId:__ _decidir2-sdk-java7_
+  __version:__ _2.7_

#### Descarga manual
[Versi&oacute;n 2.7](https://github.com/decidir/sdk-java-v2/blob/master/dist/decidir-v2.7-java7.jar)

### Java 6
#### Manager de dependencias
+  __repositoryUrl:__ _http://repo.dev.redbee.io/content/repositories/decidir-sdk/_
+  __groupId:__ _com.decidir.api_
+  __artifactId:__ _decidir2-sdk-java6_
+  __version:__ _2.1.4_

#### Descarga manual
[Versi&oacute;n 2.1.4](https://github.com/decidir/sdk-java-v2/blob/master/dist/decidir-v2.1.4-java6.jar)


<a name="versionesdejavasoportadas"></a>
### Versiones de Java soportadas
La versi&oacute;n implementada de la SDK, est&aacute; testeada para versiones a partir de **Java 1.6**

[<sub>Volver a inicio</sub>](#inicio)

<a name="environments"></a>

## Ambientes

La **sdk Java** permite trabajar con los ambientes Sandbox y Producc&oacute;n de Decidir.
El ambiente se debe instanciar indicando su URL.

```java
import com.decidir.sdk.Decidir;

public class MiClase {
	String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
	String urlSandbox = "https://developers.decidir.com/api/v2/";
	String urlProduccion = "https://live.decidir.com/api/v2/";
	int timeout = 10; // 10 segundos de timeout
	//Para el ambiente Sandbox
	Decidir decidirSandbox = new Decidir(privateApiKey, urlSandbox, timeout);
	//Para el ambiente de produccion
	Decidir decidirProd = new Decidir(privateApiKey, urlProduccion, timeout);
	// ...codigo...
}
```
[<sub>Volver a inicio</sub>](#inicio)

<a name="uso"></a>
## Uso

<a name="initconector"></a>
### Inicializar la clase correspondiente al conector.

Instanciación de la clase `Decidir`

La misma recibe como parámetros la API Key privada provista por Decidir para el comercio y el ambiente en que se trabajara.

La API Key será provista por el equipo de Soporte de DECIDIR (soporte@decidir.com.ar).

A partir de ahora y por el resto de la documentaci&oacute;n, se ejemplificar&aacute; utilizando una APIKey habilitada para operar en el ambiente Sandbox.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
//...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="operatoria"></a>

## Operatoria del Gateway

<a name="payment"></a>

### Ejecución del Pago
Una vez generado y almacenado el token de pago, se deberá ejecutar la solicitud de pago más el token previamente generado.
Además del token de pago y los parámetros propios de la transacción, el comercio deberá identificar la compra con el site_transaction_id y el user_id(id 
del Customer).

[<sub>Volver a inicio</sub>](#inicio)


<a name="single"></a>

#### Transacción simple
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n simple sin [Cybersource](#cybersource).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

PaymentRequest paymentRequest = new PaymentRequest();
paymentRequest.setToken("ae9fc3e5-ff41-4de2-9c91-81030be1c4a6"); // token de pago
paymentRequest.setSite_transaction_id("TX00001234"); //ID de transaccion asignada por el comercio, no puede repetirse
paymentRequest.setCustomer(customer);
paymentRequest.setPayment_method_id(1); //VISA
paymentRequest.setBin("450799");
paymentRequest.setAmount(23250L);//Valor en centavos: $232.50
paymentRequest.setCurrency(Currency.ARS);
paymentRequest.setInstallments(1);
paymentRequest.setPayment_type(PaymentType.SINGLE); //Tipo de pago simple
paymentRequest.setFirst_installment_expiration_date("2018-05-15"); // Llenar en caso de una compra con tarjeta NacionPyme
List<SubPayment> sub_payments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
paymentRequest.setSub_payments(sub_payments); //Debe enviarse una lista vacia

try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

<a name="pci"></a>

#### Transacción PCI
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n pci sin [Cybersource](#cybersource).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

PaymentPciRequest paymentPciRequest = new PaymentPciRequest();
CardData cardData = new CardData();
cardData.setCard_expiration_month("12");
cardData.setCard_expiration_year("20");
cardData.setIp_address("192.168.1.10"); // Customer IP, en caso de usar Cybersource se usa en el campo CSBTIPADDRESS 

IdentificationType type = IdentificationType.fromId(1); //tipo de documento, ejemplo dni
String number = "23968498"; // nro de documento

Identification identification = new Identification(); //identificacion personal
identification.setNumber(number);
identification.setType(type);
cardData.setCard_holder_identification(identification);
cardData.setCard_holder_name("Juan");
cardData.setCard_number("4509790113276723");
//RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
ServicesFraudDetectionData services =  new ServicesFraudDetectionData();

paymentPciRequest.setCard_data(cardData);
paymentPciRequest.setSite_transaction_id("TX00001234"); //ID de transaccion asignada por el comercio, no puede repetirse
paymentPciRequest.setCustomer(customer);
paymentPciRequest.setPayment_method_id(1); //VISA
paymentPciRequest.setBin("450979");
paymentPciRequest.setAmount(23250L);//Valor en centavos: $232.50
paymentPciRequest.setCurrency(Currency.ARS);
paymentPciRequest.setInstallments(1);
paymentPciRequest.setPayment_type(PaymentType.SINGLE); //Tipo de pago simple
List<SubPayment> sub_payments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
paymentPciRequest.setSub_payments(sub_payments); //Debe enviarse una lista vacia

try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)


<a name="gds"></a>

#### Transacción GDS
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n GDS simple sin [Cybersource](#cybersource).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

GDSPaymentRequestNoPCI gdsPaymentRequest = new GDSPaymentRequestNoPCI();
//RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
ServicesFraudDetectionData services =  new ServicesFraudDetectionData();

gdsPaymentRequest.setToken("a00373a5-b8d7-4d7d-b14d-4aa447726fd9"); // token de pago
gdsPaymentRequest.setSite_transaction_id("TX00001234"); //ID de transaccion asignada por el comercio, no puede repetirse
gdsPaymentRequest.setCustomer(customer);
gdsPaymentRequest.setPayment_method_id(1); //VISA
gdsPaymentRequest.setBin("450979");
gdsPaymentRequest.setAmount(23250L);//Valor en centavos: $232.50
gdsPaymentRequest.setCurrency(Currency.ARS);
gdsPaymentRequest.setInstallments(1);
gdsPaymentRequest.setPayment_type(PaymentType.SINGLE); //Tipo de pago simple
List<SubPayment> sub_payments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
gdsPaymentRequest.setSub_payments(sub_payments); //Debe enviarse una lista vacia
gdsPaymentRequest.setIata_code("4354437656"); // iata_code (logitud menor o igual 10)
gdsPaymentRequest.setNro_location("11140407"); // Id site del locator (longitud 8)

try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

<a name="gdspci"></a>

#### Transacción GDS PCI
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n PCI sin [Cybersource](#cybersource).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

GDSPaymentRequestPCI gdsPaymentRequest = new GDSPaymentRequestPCI();
CardData cardData = new CardData();
cardData.setCard_expiration_month("12");
cardData.setCard_expiration_year("20");
cardData.setIp_address("192.168.1.10"); // Customer IP, en caso de usar Cybersource se usa en el campo CSBTIPADDRESS

IdentificationType type = IdentificationType.fromId(1);
String number = "23968498";

Identification identification = new Identification();
identification.setNumber(number);
identification.setType(type);
cardData.setCard_holder_identification(identification);
cardData.setCard_holder_name("Juan");
cardData.setCard_number("4509790113276723");
//RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
ServicesFraudDetectionData services =  new ServicesFraudDetectionData();

gdsPaymentRequest.setCard_data(cardData);
gdsPaymentRequest.setSite_transaction_id("pci001"); //ID de transaccion asignada por el comercio, no puede repetirse
gdsPaymentRequest.setCustomer(customer);
gdsPaymentRequest.setPayment_method_id(1); //VISA
gdsPaymentRequest.setBin("450979");
gdsPaymentRequest.setAmount(23250L);//Valor en centavos: $232.50
gdsPaymentRequest.setCurrency(Currency.ARS);
gdsPaymentRequest.setInstallments(1);
gdsPaymentRequest.setPayment_type(PaymentType.SINGLE); //Tipo de pago simple
List<SubPayment> sub_payments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
gdsPaymentRequest.setSub_payments(sub_payments); //Debe enviarse una lista vacia
gdsPaymentRequest.setIata_code("iata1"); // iata_code (logitud menor o igual 10)
gdsPaymentRequest.setNro_location("22240407"); // Id site del locator (longitud 8)
try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="bsapci"></a>

#### Transacción BSA PCI
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n BSA PCI sin [Cybersource](#cybersource).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

BSAPaymentRequestPCI bsaPaymentRequestPCI = new BSAPaymentRequestPCI();


IdentificationType type = IdentificationType.fromId(1);
String number = "23968498";

Identification identification = new Identification();
identification.setNumber(number);
identification.setType(type);

bsaPaymentRequestPCI.setCard_holder_identification(identification);


//RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
ServicesFraudDetectionData services = new ServicesFraudDetectionData();

bsaPaymentRequestPCI.setSite_transaction_id("bsapci015"); //ID de transaccion asignada por el comercio, no puede repetirse

bsaPaymentRequestPCI.setCustomer(customer);
bsaPaymentRequestPCI.setPayment_method_id(1); //VISA
bsaPaymentRequestPCI.setBin("450799");
bsaPaymentRequestPCI.setAmount(23250L);//Valor en centavos: $232.50
bsaPaymentRequestPCI.setCurrency(Currency.ARS);
bsaPaymentRequestPCI.setInstallments(1);
bsaPaymentRequestPCI.setPayment_type(PaymentType.SINGLE); //Tipo de pago simple
List<SubPayment> sub_payments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
bsaPaymentRequestPCI.setSub_payments(sub_payments); //Debe enviarse una lista vacia

CardTokenBsa bsaCardData = new CardTokenBsa();

bsaCardData.setPublic_token("4507993431624905");
bsaCardData.setIssue_date("20170908");

bsaCardData.setPublic_request_key("12345678");


bsaCardData.setVolatile_encrypted_data("AvqyWXV1dXXPjUl8azlldQ5HK/gny6UJU4Wo3RFkYy2W9+D0kRfEoKeIIsFWiZh84CxKXvPX+u1j4Eqysg==");
bsaCardData.setCard_holder_name("sarla");
bsaCardData.setFlag_pei("1");
bsaCardData.setFlag_security_code("1");
bsaCardData.setFlag_selector_key("1");
bsaCardData.setFlag_tokenization("0");

bsaPaymentRequestPCI.setCard_token_bsa(bsaCardData);

bsaPaymentRequestPCI.setFraud_detection(services);

try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

<a name="bsanopci"></a>

#### Transacción BSA no PCI

Las transacciones BSA no PCI operan de manera idéntica a las [transacciones simples](#single), para realizar una operacion por bsa no pci basta con seguir el mismo ejemplo que el visto en las transacciones simples.

[<sub>Volver a inicio</sub>](#inicio)

<a name="bsapci"></a>

#### Transacción Agro no PCI
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n Agro simple sin [Cybersource](#cybersource).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

AgroPaymentRequestNoPCI agroPaymentRequestNoPCI = new AgroPaymentRequestNoPCI();
//RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
ServicesFraudDetectionData services = new ServicesFraudDetectionData();

agroPaymentRequestNoPCI.setToken("2f9c80b0-ebb9-4c75-b5e7-098a8c32b63a"); // token de pago
agroPaymentRequestNoPCI.setSite_transaction_id("agro0016"); //ID de transaccion asignada por el comercio, no puede repetirse
agroPaymentRequestNoPCI.setCustomer(customer);
agroPaymentRequestNoPCI.setPayment_method_id(80); //VISA
agroPaymentRequestNoPCI.setBin("448459");
agroPaymentRequestNoPCI.setAmount(23250L);//Valor en centavos: $232.50
agroPaymentRequestNoPCI.setCurrency(Currency.ARS);
//agroPaymentRequestNoPCI.setInstallments(1);

InstallmentData i1 = new InstallmentData();
i1.setId(1);
i1.setAmount(23250L);
i1.setDate(new Date());
List<InstallmentData> l = new ArrayList<InstallmentData>();
l.add(i1);
agroPaymentRequestNoPCI.setInstallmentList(l);

agroPaymentRequestNoPCI.setPayment_type(PaymentType.SINGLE); //Tipo de pago simple

AgroData agroData = new AgroData();
agroData.setToken("123456");
agroData.setToken_type("T");
agroData.setDays_agreement(360);

agroPaymentRequestNoPCI.setAgro_data(agroData);

List<SubPayment> sub_payments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
agroPaymentRequestNoPCI.setSub_payments(sub_payments); //Debe enviarse una lista vacia

try {
    DecidirResponse<AgroPaymentResponse> paymentResponse = decidir.payment(agroPaymentRequestNoPCI);
    System.out.println(paymentResponse.getMessage());
    System.out.println("aaa");
} catch (PaymentException pe) {
    // Manejo de pago rechazado
    // ...codigo...
} catch (DecidirException de) {
    // Manejo de excepcion  de Decidir
    // ...codigo...
} catch (Exception e) {
    //Manejo de excepcion general
    // ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)


<a name="distributed"></a>

#### Transacción distribuida
Existen transacciones distribuidas definidas por monto o por porcentaje. Para indicar los sitios a distribuir, se debe enviar en el campo `sub_payments` cada uno de ellos. En el caso de transacci&oacute;n por monto se indicar&acute;: **Id del sitio receptor, monto a distribuir y la cantidad de cuotas**. Si se distribuye por porcentaje no se debe enviar informacion en `sub_payments` .

A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n distribuida por monto sin [Cybersource](#cybersource).
*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

*Nota Técnica*: A diferencia de las Transacciones Simples, para las Transacciones Distribuidas, el parámetro payment_type debe ser <code>PaymentType.DISTRIBUTED</code>; y el parámetro sub_payments 
se debe popular con los sub-sitios y los montos distribuidos de manera dinámica.

* En Transacciones distribuidas por Monto, la sumatoria de los montos distribuidos debe ser exactamente igual al monto total de la operación Padre.
* En Transacciones distribuidas por Porcentaje, el parámetro sub_payments no debe completarse, pues la distribución es estática 
y se configura en el SAC.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

Integer installments = 2;
Long amount1 = 10000L;
Long amount2 = 25990L;
PaymentRequest paymentRequest = new PaymentRequest();
paymentRequest.setToken("a6f05789-10df-4464-a318-887a1520204b"); // token de pago
paymentRequest.setSite_transaction_id("TX0000000001"); //ID de transaccion asignada por el comercio, no puede repetirse
paymentRequest.setCustomer(customer);
paymentRequest.setPayment_method_id(1); //VISA
paymentRequest.setBin("450979");
paymentRequest.setAmount(amount1 + amount2);//Suma de los pagos distribuidos
paymentRequest.setCurrency(Currency.ARS);
paymentRequest.setInstallments(installments); //Cantidad de cuotas

paymentRequest.setPayment_type(PaymentType.DISTRIBUTED); //Indica transaccion distribuida
List<SubPayment> subPayments = new ArrayList<SubPayment>(); // Llenar en caso de transaccion distribuida por monto
SubPayment subPayment1 = new SubPayment(); //Sitio receptor 1 (solo en caso de distribuida por monto)
subPayment1.setSite_id("00111115"); //Sitio receptor 1 (solo en caso de distribuida por monto)
subPayment1.setAmount(amount1); //Monto a recibir (solo en caso de distribuida por monto)
subPayment1.setInstallments(installments); //Cantidad de cuotas (solo en caso de distribuida por monto)
SubPayment subPayment2 = new SubPayment(); //Sitio receptor 2 (solo en caso de distribuida por monto)
subPayment2.setSite_id("00111116"); //Sitio receptor 2 (solo en caso de distribuida por monto)
subPayment2.setAmount(amount2); //Monto a recibir (solo en caso de distribuida por monto)
subPayment2.setInstallments(installments); //Cantidad de cuotas (solo en caso de distribuida por monto)

subPayments.add(subPayment1);
subPayments.add(subPayment2);
paymentRequest.setSub_payments(subPayments); //Se agregan los datos de distribuida

try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="twosteps"></a>

#### Operación en dos pasos
Una vez generado y almacenado el token de pago, se deberá ejecutar la solicitud de pago más el token previamente generado.
Si el pago es preaprobado `Status.PRE_APPROVED`, se procederá a realizar la confirmaci&oacute;n del pago enviando **ID de pago, monto y usario aprobador**.
A continuaci&oacute;n se muestra un ejemplo con una transacci&oacute;n simple sin Cybersource.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

String privateApiKey = "00111115";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "http://localhost:9002/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

PaymentRequest paymentRequest = new PaymentRequest();
paymentRequest.setToken("a6f05789-10df-4464-a318-887a1520204b"); // token de pago
paymentRequest.setSite_transaction_id("TX0000000001"); //ID de transaccion asignada por el comercio, no puede repetirse
paymentRequest.setCustomer(customer);
paymentRequest.setPayment_method_id(1); //VISA
paymentRequest.setBin("450979");
paymentRequest.setAmount(23250L);//Valor en centavos: $232.50
paymentRequest.setCurrency(Currency.ARS);
paymentRequest.setInstallments(1);
paymentRequest.setPayment_type(PaymentType.SINGLE);
List<SubPayment> sub_payments = new ArrayList<SubPayment>(); //Nunca se utiliza en 2 pasos (se envia vacio)
paymentRequest.setSub_payments(sub_payments);

try {
   DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);

   PaymentResponse paymentResult = paymentResponse.getResult();
   // Confirmar pago preaprobado
   if (Status.PRE_APPROVED.equals(paymentResult.getStatus())) {
       Long paymentId = paymentResult.getId(); //Obtener id de pago
       DecidirResponse<PaymentResponse> confirmPayment = decidir.confirmPayment(paymentId, paymentRequest.getAmount(), "usuario_aprobador");
       paymentResult = confirmPayment.getResult();
   }
   // Procesamiento de respuesta de ejecucion de pago
   // ...codigo...
} catch (PaymentException pe) {
   // Manejo de pago rechazado
   // ...codigo...
} catch (DecidirException de) {
   // Manejo de excepcion  de Decidir
   // ...codigo...
} catch (Exception e) {
   //Manejo de excepcion general
   // ...codigo...
}
 // ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="getallpayments"></a>

### Listado de Pagos

Mediante este recurso, se genera una solicitud de listado de pagos.
Este recurso admite la posibilidad de agregar filtros adicionales

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

Integer offset = 20;//OPCIONAL, desplazamiento en los resultados devueltos. Valor por defecto = 0.
Integer pageSize = 10; //OPCIONAL, cantidad máxima de resultados retornados. Valor por defecto = 50.
String siteOperationId = null; //OPCIONAL, ID único de la transacción a nivel comercio (equivalente al site_transaction_id).
String sitetId = null;//OPCIONAl, ID Site del comercio.

try {
	DecidirResponse<Page> pagos = decidir.getPayments(offset, pageSize, siteOperationId, siteId);
	// Procesamiento de respuesta de listado de pagos
	// ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="getpaymentinfo"></a>

### Información de un Pago

Mediante este recurso, se genera una solicitud de información de un pago previamente realizado, pasando como parámetro el id del pago.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

long idPago = 000123L; //ID devuelto por la operacion de pago (NO CONFUNDIR con site_transaction_id asignado por el comercio)
try {
	DecidirResponse<PaymentResponse> pago = decidir.getPayment(idPago);
	// Procesamiento de respuesta de consulta de pago
	// ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="refunds"></a>
### Devoluciones de pagos

A continuaci&oacute;n se describen las diferentes operatorias para realizar anulaciones y devoluciones de pagos

[<sub>Volver a inicio</sub>](#inicio)


<a name="totalrefund"></a>

#### Anulación / Devolución Total de Pago

Mediante este recurso, se genera una solicitud de anulación / devolución total de un pago puntual, pasando como parámetro el id del pago y el usuario del cliente.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
long idPago = 000123L; //ID devuelto por la operacion de pago (NO CONFUNDIR con site_transaction_id asignado por el comercio)
String usuario = "usuario_que_realiza_la_accion"; //OPCIONAL NULLABLE, Usuario habilitado para realizar la anulacion/devolucion. Se utiliza para matener un registro de quien realiza la operacion
RefundPayment refundPayment = new RefundPayment(); //Se instancia sin datos
try {
	DecidirResponse<RefundPaymentResponse> devolucion = decidir.refundPayment(idPago, refundPayment, usuario);
	// Procesamiento de respuesta de la devolucion de pago
	// ...codigo...
} catch (ValidateStatusException vse) {
    // Manejo de excepcion en devolucion
    String status = vse.getErrorDetail().getValidation_errors().getStatus();
    vse.printStackTrace();	
} catch (RefundException re) {
    // Manejo de excepcion en devolucion
    re.printStackTrace();
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	// ...codigo...
} catch (Exception e) {
	//Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="deleterefund"></a>

#### Anulación de Devolución Total

Mediante este recurso, se genera una solicitud de anulación de devolución total de un pago puntual, pasando como parámetro el id del pago, el id de la devolución y el usuario del cliente.
```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
long idPago = 000123L;//ID devuelto por la operacion de pago (NO CONFUNDIR con site_transaction_id asignado por el comercio)
long idDevolucion = 00012L;//ID devuelto por la operacion de devolucion
String usuario = "usuario_que_realiza_la_accion"; //OPCIONAL NULLABLE, Usuario habilitado para realizar la anulacion/devolucion. Se utiliza para matener un registro de quien realiza la operacion

try {
	DecidirResponse<AnnulRefundResponse> anulacion = decidir. cancelRefund(idPago, idDevolucion, usuario)
	// Procesamiento de respuesta de anulacion de devolucion
	// ...codigo...
} catch (AnnulRefundException are) {
    are.printStackTrace();
    // Manejo de excepcion de anulacion de devolucion
    // ...codigo...
} catch (ValidateStatusException vse) {
    // Manejo de excepcion en devolucion
    String status = vse.getErrorDetail().getValidation_errors().getStatus();
    vse.printStackTrace();	
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```
[<sub>Volver a inicio</sub>](#inicio)

<a name="partialrefund"></a>

#### Devolución Parcial de un Pago

Mediante este recurso, se genera una solicitud de devolución parcial de un pago puntual, pasando como parámetro el id del pago, el monto de la devolución y el usuario del cliente.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
long idPago = 000123L; //ID devuelto por la operacion de pago (NO CONFUNDIR con site_transaction_id asignado por el comercio)
String usuario = "usuario_que_realiza_la_accion"; //OPCIONAL NULLABLE, Usuario habilitado para realizar la anulacion/devolucion. Se utiliza para matener un registro de quien realiza la operacion
long  montoDevolucion = 1250L // Expresado en centavos

RefundPayment refundPayment = new RefundPayment();
refundPayment.setAmount(montoDevolucion);
refundPayment.setSub_payments(new ArrayList<RefundSubPayment>());//Llenar en caso de solicitar devolucion parcial en transaccion distribuida
try {
	DecidirResponse<RefundPaymentResponse> devolucion = decidir.refundPayment(idPago, refundPayment, usuario)
	// Procesamiento de respuesta de la devolucion de pago
	// ...codigo...
} catch (RefundException re) {
    // Manejo de excepcion en devolucion
    re.printStackTrace();
} catch (ValidateStatusException vse) {
    // Manejo de excepcion en devolucion
    String status = vse.getErrorDetail().getValidation_errors().getStatus();
    vse.printStackTrace();	
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="deletepartialrefund"></a>

#### Anulación de Devolución Parcial

Mediante este recurso, se genera una solicitud de anulación de devolución parcial de un pago puntual, pasando como parámetro el id del pago, el id de la devolución  el usuario del cliente.
```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
long idPago = 000123L;//ID devuelto por la operacion de pago (NO CONFUNDIR con site_transaction_id asignado por el comercio)
long idDevolucion = 00012L;//ID devuelto por la operacion de devolucion
String usuario = "usuario_que_realiza_la_accion"; //OPCIONAL NULLABLE, Usuario habilitado para realizar la anulacion/devolucion. Se utiliza para matener un registro de quien realiza la operacion
try {
	DecidirResponse<AnnulRefundResponse> anulacion = decidir.cancelRefund(idPago, idDevolucion, usuario)
	// Procesamiento de respuesta de anulacion de devolucion
	// ...codigo...
} catch (AnnulRefundException are) {
    are.printStackTrace();
    // Manejo de excepcion de anulacion de devolucion
    // ...codigo...
} catch (ValidateStatusException vse) {
    // Manejo de excepcion en devolucion
    String status = vse.getErrorDetail().getValidation_errors().getStatus();
    vse.printStackTrace();	
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```
[<sub>Volver a inicio</sub>](#inicio)

<a name="tokenizaciontarjeta"></a>

## Tokenización de tarjetas de crédito

Esta funcionalidad permite que luego de realizar una compra con una tarjeta, se genere un token alfanumerico unico en el backend de Decidir, esto permite que a la hora de comprar nuevamente con esta tarjeta solo requerira el codigo de seguridad.
Como primer paso se debe realizar una un pago normal, el token generado estara en el campo "token" de la respuesta.

[<sub>Volver a inicio</sub>](#inicio)

<a name="listadotarjetastokenizadas"></a>

### Listado de tarjetas tokenizadas

Este método permite conocer el listado de tarjetas tokenizadas que posee un usuario determinado. Para esto es necesario el nombre de usuario a la instancia de token.
Este recurso admite la posibilidad de agregar filtros adicionales.


```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

String usuario = "usuario_cliente"; // Usuario para el cual se consultan las tarjetas tokenizadas
String bin = "450799"; //OPCIONAL, bin de la tarjeta.
String ultimosCuatroDigitos = null; //OPCIONAL, ultimos 4 digitos de la tarjeta.
String mesVencimiento = null; //OPCIONAL, mes de vencimiento de la tarjeta.
String anioVencimiento = "18"; //OPCIONAL, año de vencimiento de la tarjeta.

try {
	DecidirResponse<CardTokens> tarjetasTokenizadas = decidir.getCardTokens(usuario, bin, ultimosCuatroDigitos, mesVencimiento, anioVencimiento);
	// Procesamiento de respuesta de listado de tarjetas tokenizadas
	// ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="pagotokenizado"></a>

### Ejecución de pago tokenizado

Una vez que se obtiene el token a partir de la tarjeta tokenizada, se deberá ejecutar la solicitud de pago. Además del token de pago y los parámetros propios de la transacción, el comercio deberá identificar la compra con el "site_transaction_id" y "user_id"(id 
del Customer).

*Aclaracion* : amount es un campo long el cual representa el valor en centavos.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
Customer customer = new Customer();
customer.setId("test"); // user_id
customer.setEmail("test@decidir.com"); // user_email

PaymentRequest paymentRequest = new PaymentRequest();
paymentRequest.setToken("ae9fc3e5-ff41-4de2-9c91-81030be1c4a6"); // token de pago
paymentRequest.setSite_transaction_id("0001234");
paymentRequest.setCustomer(customer);
paymentRequest.setPayment_method_id(1); //MASTERCARD
paymentRequest.setBin("45079");
paymentRequest.setAmount(23250L);//Valor en centavos: $232.50
paymentRequest.setCurrency(Currency.ARS);
paymentRequest.setInstallments(1);
paymentRequest.setPayment_type(PaymentType.SINGLE);
List<SubPayment> sub_payments = new ArrayList<SubPayment>() // Llenar en caso de transaccion distribuida
paymentRequest.setSub_payments(sub_payments);

try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="eliminartarjetatokenizada"></a>

### Eliminación de tarjeta tokenizada

El servicio da la posibilidad de eliminar un token de tarjeta generadas, esto se logra instanciando token y utilizando el método DeleteCardToken(token). Funciona enviando la tarjeta tokenizada.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
try {
	DecidirResponse<Void> respuesta = decidir.deleteCardToken("ae9fc3e5-ff41-4de2-9c91-81030be1c4a6");
	// Procesamiento de respuesta de eliminacion de tarjeta tokenizada
	// ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```
[<sub>Volver a inicio</sub>](#inicio)

<a name="cybersource"></a>

## Integración con Cybersource

Para utilizar el Servicio de Control de Fraude Cybersource, en la operación SendAuthorizeRequest, deben enviarse datos adicionales sobre la operación de compra que se quiere realizar.
Se han definido cinco verticales de negocio que requieren parámetros específicos, así como también parámetros comunes a todas las verticales.

[<sub>Volver a inicio</sub>](#inicio)

<a name="parametros-comunes"></a>

### Parámetros Comunes

Los parámetros comunes a todas las verticales deben enviarse junto con los datos específicos de cada uno. A continuación, describiremos los párametros comúnes que se deberan agregar a los datos de cada vertical al momento de instanciar la clase correspondiente.

1.  **bill_to**
```java
// ...codigo...
BillingData billTo = new BillingData();
billTo.setCity("Buenos Aires"); //Ciudad de facturación, MANDATORIO.
billTo.setCountry("AR"); //País de facturación. MANDATORIO. Código ISO. (http://apps.cybersource.com/library/documentation/sbc/quickref/countries_alpha_list.pdf)
billTo.setCustomer_id("test");//Identificador del usuario al que se le emite la factura. MANDATORIO. No puede contener un correo electrónico.
billTo.setEmail("usuario@email.com.ar");//Mail del usuario al que se le emite la factura. MANDATORIO.
billTo.setFirst_name("Usuario"); //Nombre del usuario al que se le emite la factura. MANDATORIO.
billTo.setLast_name("Prueba");//Apellido del usuario al que se le emite la factura. MANDATORIO.
billTo.setPhone_number("54116763329");//Teléfono del usuario al que se le emite la factura. No utilizar guiones, puntos o espacios. Incluir código de país. MANDATORIO.
billTo.setPostal_code("1414");//Código Postal de la dirección de facturación. MANDATORIO.
billTo.setState("C");//Provincia de la dirección de facturación. MANDATORIO. Ver tabla anexa de provincias.
billTo.setStreet1("THAMES 677");//Domicilio de facturación (calle y nro). MANDATORIO.
billTo.setStreet2("4to F");//Complemento del domicilio. (piso, departamento). OPCIONAL.
fraudDetectionData.setBill_to(billTo); //Subclase de com.decidir.sdk.dto.FraudDetectionDataRequest
// ...codigo...
```
2.  **purchase_totals**
```java
// ...codigo...
PurchaseTotals purchaseTotals = new PurchaseTotals();
purchaseTotals.setCurrency(Currency.ARS); //com.decidir.sdk.dto.Currency. MANDATORIO.
purchaseTotals.setAmount(34900L);//Monto en centavos. MANDATORIO.
fraudDetectionData.setPurchase_totals(purchaseTotals); //Subclase de com.decidir.sdk.dto.FraudDetectionDataRequest
// ...codigo...
```

3. **customer_in_site**
```java
// ...codigo...
CustomerInSite customerInSite = new CustomerInSite();
customerInSite.setDays_in_site(243);
customerInSite.setIs_guest(Boolean.FALSE);
customerInSite.setPassword("abracadabra");
customerInSite.setNum_of_transactions(1);
customerInSite.setCellphone_number("1546763329");
fraudDetectionData.setCustomer_in_site(customerInSite); //Subclase de com.decidir.sdk.dto.FraudDetectionDataRequest
// ...codigo...
```
4.  **copy_paste_card_data**
```java
// ...codigo...
CopyPasteCardData copyPasteCardData = new CopyPasteCardData();
copyPasteCardData.setCard_number(Boolean.TRUE);//valor booleano
copyPasteCardData.setSecurity_code(Boolean.TRUE);//valor booleano
fraudDetectionData.setCopy_paste_card_data(copyPasteCardData);//Subclase de com.decidir.sdk.dto.FraudDetectionDataRequest
// ...codigo...
```
5.  _**Otros campos**_
```java
// ...codigo...
fraudDetectionData.setChannel(Channel.WEB);//Tambien puede recibir un valor de tipo String 
fraudDetectionData.setDispatch_method("domicilio");//{domicilio, click and collect, courrier}
fraudDetectionData.setSend_to_cs(Boolean.true);// true o false
fraudDetectionData.setDevice_unique_id("fingerprint-del-cliente");//Subclase de com.decidir.sdk.dto.FraudDetectionDataRequest
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="retail"></a>

### Retail
Se enviá un `RetailFraudDetectionData` con los [parámetros comunes](#parametros-comunes) y con los siguientes parámetros que se deben enviar específicamente para la vertical Retail. Además se deben enviar datos específicos de cada producto involucrado en la transacción.

```java
// ...codigo...
RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//seteo de parámetros comunes
// ...codigo...
RetailTransactionData retailTransactionData = new RetailTransactionData();//Datos para la vertical Retail
//Datos de envio
ShippingData shipTo = new ShippingData();
shipTo.setCity("Buenos Aires"); //Ciudad de envío, MANDATORIO.
shipTo.setCountry("AR"); //País de envío. MANDATORIO. Código ISO. (http://apps.cybersource.com/library/documentation/sbc/quickref/countries_alpha_list.pdf)
shipTo.setEmail("usuario@email.com.ar");//Mail del destinatario. MANDATORIO.
shipTo.setFirst_name("Usuario"); //Nombre del destinatario. MANDATORIO.
shipTo.setLast_name("Prueba");//Apellido del destinatario. MANDATORIO.
shipTo.setPhone_number("54116763329");//Teléfono del destinatario. No utilizar guiones, puntos o espacios. Incluir código de país. MANDATORIO.
shipTo.setPostal_code("1414");//Código Postal de la dirección de envío. MANDATORIO.
shipTo.setState("C");//Provincia de la dirección de envío. MANDATORIO. Ver tabla anexa de provincias.
shipTo.setStreet1("THAMES 677");//Domicilio de envío (calle y nro). MANDATORIO.
shipTo.setStreet2("4to F");//Complemento del domicilio. (piso, departamento). OPCIONAL.
retailTransactionData.setShip_to(shipTo);//Datos de envio. MANDATORIO
retailTransactionData.setDays_to_delivery("2");
retailTransactionData.setTax_voucher_required(Boolean.TRUE);
retailTransactionData.setCustomer_loyality_number("123232");
setCoupon_code("cupon22");
//Items de compra (Al menos un item)
Item item = new Item();
item.setCode("popblacksabbat2016");  //MANDATORIO
item.setDescription("Popular Black Sabbath 2016"); //OPCIONAL
item.setName("popblacksabbat2016ss");//MANDATORIO
item.setSku("sku");//MANDATORIO
item.setTotal_amount(34900L);//MANDATORIO
item.setQuantity(1);//MANDATORIO
item.setUnit_price(34900L);//MANDATORIO
ticketingTransactionData.setItems(Arrays.asList(item); //Items de compra. MANDATORIO
retail.setRetail_transaction_data(retailTransactionData);//Datos de vertical Retail. MANDATORIO
// ...codigo...
```

Para incorporar estos datos en el requerimiento inicial, se debe instanciar un objeto de la clase `RetailFraudDetectionData` de la siguiente manera.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
PaymentRequest paymentRequest = new PaymentRequest();
// Datos del pago
 // ...codigo...
 RetailFraudDetectionData retail =  new RetailFraudDetectionData();
//Datos de vertical Retail
// ...codigo...
paymentRequest.setFraud_detection(retail);
try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="ticketing"></a>

### Ticketing

Se enviá un `TicketingTransactionData` con los [parámetros comunes](#parametros-comunes) y con los siguientes parámetros que se deben enviar específicamente para la vertical Ticketing. Además se deben enviar datos específicos de cada producto involucrado en la transacción.

```java
// ...codigo...
TicketingTransactionData ticketing =  new TicketingTransactionData();
//seteo de parámetros comunes
// ...codigo...
TicketingTransactionData ticketingTransactionData = new TicketingTransactionData();//Datos para la vertical Ticketing

ticketingTransactionData.setDays_to_event(10);   //MANDATORIO
ticketingTransactionData.setDelivery_type("Pick up");  //MANDATORIO
//Items de compra (Al menos un item)
Item item = new Item();
item.setCode("popblacksabbat2016");  //MANDATORIO
item.setDescription("Popular Black Sabbath 2016"); //OPCIONAL
item.setName("popblacksabbat2016ss");//MANDATORIO
item.setSku("sku");//MANDATORIO
item.setTotal_amount(34900L);//MANDATORIO
item.setQuantity(1);//MANDATORIO
item.setUnit_price(34900L);//MANDATORIO
ticketingTransactionData.setItems(Arrays.asList(item); //Items de compra. MANDATORIO
ticketing.setTicketing_transaction_data(ticketingTransactionData);//Datos de vertical Ticketing. MANDATORIO
// ...codigo...
```

Para incorporar estos datos en el requerimiento inicial, se debe instanciar un objeto de la clase`TicketingTransactionData`  de la siguiente manera.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

PaymentRequest paymentRequest = new PaymentRequest();
// Datos del pago
 // ...codigo...
TicketingTransactionData ticketing =  new TicketingTransactionData();
//Datos de vertical Ticketing
// ...codigo...
paymentRequest.setFraud_detection(ticketing);
try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="retailTP"></a>

### RetailTP
Se enviá un `RetailTPFraudDetectionData` con los [parámetros comunes](#parametros-comunes) y con los siguientes parámetros que se deben enviar específicamente para la vertical RetailTP. Además se deben enviar datos específicos de cada producto involucrado en la transacción.

```java
// ...codigo...
RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
//seteo de parámetros comunes
// ...codigo...
RetailTPTransactionData retailTPTransactionData = new RetailTPTransactionData();//Datos para la vertical RetailTP
//Datos de envio
ShippingData shipTo = new ShippingData();
shipTo.setCity("Buenos Aires"); //Ciudad de envío, MANDATORIO.
shipTo.setCountry("AR"); //País de envío. MANDATORIO. Código ISO. (http://apps.cybersource.com/library/documentation/sbc/quickref/countries_alpha_list.pdf)
shipTo.setEmail("usuario@email.com.ar");//Mail del destinatario. MANDATORIO.
shipTo.setFirst_name("Usuario"); //Nombre del destinatario. MANDATORIO.
shipTo.setLast_name("Prueba");//Apellido del destinatario. MANDATORIO.
shipTo.setPhone_number("54116763329");//Teléfono del destinatario. No utilizar guiones, puntos o espacios. Incluir código de país. MANDATORIO.
shipTo.setPostal_code("1414");//Código Postal de la dirección de envío. MANDATORIO.
shipTo.setState("C");//Provincia de la dirección de envío. MANDATORIO. Ver tabla anexa de provincias.
shipTo.setStreet1("THAMES 677");//Domicilio de envío (calle y nro). MANDATORIO.
shipTo.setStreet2("4to F");//Complemento del domicilio. (piso, departamento). OPCIONAL.
retailTPTransactionData.setShip_to(shipTo);//Datos de envio. MANDATORIO
retailTPTransactionData.setDays_to_delivery("2");
retailTPTransactionData.setTax_voucher_required(Boolean.TRUE);
retailTPTransactionData.setCustomer_loyality_number("123232");
setCoupon_code("cupon22");
//Items de compra (Al menos un item)
Item item = new Item();
item.setCode("popblacksabbat2016");  //MANDATORIO
item.setDescription("Popular Black Sabbath 2016"); //OPCIONAL
item.setName("popblacksabbat2016ss");//MANDATORIO
item.setSku("sku");//MANDATORIO
item.setTotal_amount(34900L);//MANDATORIO
item.setQuantity(1);//MANDATORIO
item.setUnit_price(34900L);//MANDATORIO
ticketingTransactionData.setItems(Arrays.asList(item); //Items de compra. MANDATORIO

Account account = new Account();
account.setId("account_id");
account.setType("account_type");
account.setName("account_name");
account.setCategory(123);
account.setAntiquity(12);

Wallet wallet = new Wallet();
wallet.setId("wallet_id");
wallet.setAntiquity(12);

retailTPTransactionData.setAccount(account);
retailTPTransactionData.setWallet_account(wallet);
retailTPTransactionData.setPayment_method_risk_level(33);
retailTPTransactionData.setEnroled_card_quantity(22);
retailTPTransactionData.setDouble_factor_tp(1);

retailTP.setRetailTP_transaction_data(retailTPTransactionData);//Datos de vertical RetailTP. MANDATORIO
// ...codigo...
```

Para incorporar estos datos en el requerimiento inicial, se debe instanciar un objeto de la clase `RetailTPFraudDetectionData` de la siguiente manera.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);
PaymentRequest paymentRequest = new PaymentRequest();
// Datos del pago
 // ...codigo...
 RetailTPFraudDetectionData retailTP =  new RetailTPFraudDetectionData();
//Datos de vertical RetailTP
// ...codigo...
paymentRequest.setFraud_detection(retailTP);
try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="digital-goods"></a>

### Digital Goods

Se enviá un `DigitalGoodsFraudDetectionData` con los [parámetros comunes](#parametros-comunes) y con los siguientes parámetros que se deben enviar específicamente para la vertical Digital Goods. Además se deben enviar datos específicos de cada producto involucrado en la transacción.

```java
// ...codigo...
DigitalGoodsFraudDetectionData digitalGoods =  new DigitalGoodsFraudDetectionData();
//seteo de parámetros comunes
// ...codigo...
DigitalGoodsTransactionData digitalGoodsTransactionData = new DigitalGoodsTransactionData();//Datos para la vertical Digital Goods

digitalGoodsTransactionData.setDelivery_type("Pick up");  //MANDATORIO
//Items de compra (Al menos un item)
Item item = new Item();
item.setCode("popblacksabbat2016");  //MANDATORIO
item.setDescription("Popular Black Sabbath 2016"); //OPCIONAL
item.setName("popblacksabbat2016ss");//MANDATORIO
item.setSku("sku");//MANDATORIO
item.setTotal_amount(34900L);//MANDATORIO
item.setQuantity(1);//MANDATORIO
item.setUnit_price(34900L);//MANDATORIO
digitalGoodsTransactionData.setItems(Arrays.asList(item); //Items de compra. MANDATORIO
digitalGoods.setDigital_goods_transaction_data(digitalGoodsTransactionData);//Datos de vertical Digital Goods. MANDATORIO
// ...codigo...
```

Para incorporar estos datos en el requerimiento inicial, se debe instanciar un objeto de la clase`DigitalGoodsFraudDetectionData`  de la siguiente manera.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

PaymentRequest paymentRequest = new PaymentRequest();
// Datos del pago
 // ...codigo...
DigitalGoodsFraudDetectionData digitalGoods=  new DigitalGoodsFraudDetectionData();
//Datos de vertical Digital Goods
// ...codigo...
paymentRequest.setFraud_detection(digitalGoods);
try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="travel"></a>

### Travel

Se enviá un `TravelFraudDetectionData` con los [parámetros comunes](#parametros-comunes) y con los siguientes parámetros que se deben enviar específicamente para la vertical Travel. Además se deben enviar datos específicos de cada pasajero.

```java
// ...codigo...
 TravelFraudDetectionData travel =  new TravelFraudDetectionData();
//seteo de parámetros comunes
// ...codigo...
TravelTransactionData travelTransactionData = new TravelTransactionData();//Datos para la vertical Ticketing
travelTransactionData.setReservation_code("GJH784"); //MANDATORIO
travelTransactionData.setThird_party_booking(Boolean.FALSE); //MANDATORIO
travelTransactionData.setDeparture_city("EZE");//OPCIONAL
travelTransactionData.setFinal_destination_city("HND");//OPCIONAL
travelTransactionData.setInternational_flight(Boolean.TRUE);//OPCIONAL
travelTransactionData.setFrequent_flier_number("00000123");//OPCIONAL
travelTransactionData.setClass_of_service("class");//OPCIONAL
travelTransactionData.setDay_of_week_of_flight(DayOfWeekOfFlight.MONDAY);//OPCIONAL
travelTransactionData.setWeek_of_year_of_flight(5);//OPCIONAL
travelTransactionData.setAirline_code("AA");//OPCIONAL
travelTransactionData.setCode_share("SKYTEAM");//OPCIONAL
travelTransactionData.setAirline_number_of_passengers(1);//MANDATORIO
//Lista de Pasajeros
Passenger passenger = new Passenger();
passenger.setEmail("juan@mail.com");//MANDATORIO
passenger.setFirst_name("Juan");//MANDATORIO
passenger.setLast_name("Perez");//MANDATORIO
passenger.setPassport_id("412314851231"); //OPCIONAL
passenger.setPhone("541134356768");//MANDATORIO
passenger.setPassenger_status(PassengerStatus.GOLD);//MANDATORIO
passenger.setPassenger_type(PassengerType.ADULT);//MANDATORIO
travelTransactionData.setPassengers(Arrays.asList(passenger)); //Lista de pasajeros. MANDATORIO

//Fecha de partida (horario del aeropuerto de partida)
Calendar departureDateTime = Calendar.getInstance();
departureDateTime.setTimeZone(TimeZone.getTimeZone("GMT-0300"));
departureDateTime.set(2018, 06, 25, 8, 35);

DepartureDate departureDate = new DepartureDate();//MANDATORIO. Fecha de partida
departureDate.setDeparture_time(departureDateTime.getTime());//MANDATORIO. Horario de partida
departureDate.setDeparture_zone("GMT-0300");//MANDATORIO. Zona horaria de aeropuerto de partida
DecisionManagerTravel decisionManagerTravel = new DecisionManagerTravel();
decisionManagerTravel.setComplete_route("EZE-LAX:LAX-HND");//MANDATORIO. Ruta completa del viaje. Formato = PP1-DD1:PP2-DD2:... -> PPx = Aeropuerto de partida para escala x; DDx = Aeropuerto destino para escala x; : = Separador de escalas
decisionManagerTravel.setJourney_type(JourneyType.ONE_WAY);//MANDATORIO. Tipo de viaje
decisionManagerTravel.setDeparture_date(departureDate);//MANDATORIO. Fecha de partida

travelTransactionData.setDecision_manager_travel(decisionManagerTravel); ;//MANDATORIO
travel.setTravel_transaction_data(travelTransactionData);//Datos de vertical Ticketing. MANDATORIO
// ...codigo...
```

Para incorporar estos datos en el requerimiento inicial, se debe instanciar un objeto de la clase`TravelFraudDetectionData`  de la siguiente manera.

```java
// ...codigo...
String privateApiKey = "92b71cf711ca41f78362a7134f87ff65";//Private API Key habilitada para operar en ambiente Sandbox
String urlSandbox = "https://developers.decidir.com/api/v2/";
int timeout = 10; // 10 segundos de timeout
//Ejemplo para el ambiente Sandbox
Decidir decidir = new Decidir(privateApiKey, urlSandbox, timeout);

PaymentRequest paymentRequest = new PaymentRequest();
// Datos del pago
 // ...codigo...
 TravelFraudDetectionData travel =  new TravelFraudDetectionData();
//Datos de vertical Travel
// ...codigo...
paymentRequest.setFraud_detection(travel);
try {
	DecidirResponse<PaymentResponse> paymentResponse = decidir.payment(paymentRequest);
	// Procesamiento de respuesta de ejecucion de pago
	// ...codigo...
} catch (PaymentException pe) {
	 // Manejo de pago rechazado
	 // ...codigo...
} catch (DecidirException de) {
	// Manejo de excepcion  de Decidir
	 // ...codigo...
} catch (Exception e) {
	 //Manejo de excepcion general
	// ...codigo...
}
// ...codigo...
```
[<sub>Volver a inicio</sub>](#inicio)


<a name="usoResponses"></a>

## Uso de Responses

Luego de haber realizado una operación, DECIDIR devuelve los siguientes objetos:

### PaymentResponse

Es usado en:
*   [Transacción Simple](#single)
*   [Transacción PCI](#pci)
*   [Transacción GDS](#gds)
*   [Transacción GDS PCI](#gdspci)
*   [Transacción BSA PCI](#bsapci)
*   [Transacción BSA no PCI](#bsanopci)
*   [Transacción Agro no PCI](#agronopci)
*   [Transacción Pci por Token]()
*   [Información de un Pago](#getpaymentinfo)
*   [Operación en dos pasos](#twosteps)

### Page
*   [Listado de Pagos](#getallpayments)

### RefundPaymentHistoryResponse
*   [Listado de Devoluciones]()


### RefundPaymentResponse
*   [Anulación / Devolución Total de Pago](#totalrefund)
*   [Devolución Parcial de un Pago](#partialrefund)

### AnnulRefundResponse
*   [Anulación de Devolución Total](#deleterefund)
*   [Anulación de Devolución Parcial](#deletepartialrefund)

### CardTokens

*   [Listado de tarjetas tokenizadas](#listadotarjetastokenizadas)


[<sub>Volver a inicio</sub>](#inicio)

<a name="manejoExceptions"></a>

## Manejo de Excepciones

Todas las respuestas negativas del backend de DECIDIR deberán ser manejadas mediante Excepciones.

Las Excepciones tienen dos naturalezas:

* Resultados de Transacciones y Operaciones:
    * [PaymentException](#paymentException)
    * [RefundException](#refundException)
    * [AnnulRefundException](#annulRefundException)
	* [ValidateStatusException](#validateStatusException)    
* Errores en el proceso de Transacción y Operaciones:
    * [DecidirException](#decidirException)
        * [ValidateException](#validateException)
        * [ApiException](#apiException)
        * [NotFoundException](#notFoundException)


<a name="paymentException"></a>
### PaymentException

El <code>PaymentException</code> será lanzado cuando:

* Un pago haya sido RECHAZADO
* El control de CyberSource haya rechazado el Pago (Excepto para Pagos en dos pasos).

#### Atributos
	- status: int
	- message: String
	- paymentResponse: PaymentResponse

*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>PaymentException</code>:
```java
try {
    // ...codigo...
	// Pago enviado a DECIDIR
	// ...codigo...
} catch (PaymentException pe) {
    // Estado general de la Excepción
    int httpStatus = pe.getStatus();
    String exceptionMessage = pe.getMessage();

    // Respuesta de DECIDIR
    PaymentResponse paymentResponse = pe.getPayment();
}
```
<a name="decidirException"></a>
### DecidirException

El <code>DecidirException</code> será lanzado cuando DECIDIR no pueda procesar una solicitud.

#### Atributos
    - status: int
    - message: String

Además es <code>superclass</code> de las siguientes excepciones:

<a name="validateException"></a>
#### ValidateException

Es lanzado cuando DECIDIR intenta procesar datos con formatos no esperados.

#### Atributos
    - status: int
    - message: String
    - errorDetail: ValidateError
*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>ValidateException</code>:
```java
try {
    // ...codigo...
    // Pago enviado a DECIDIR
    // ...codigo...
} catch (ValidateException ve) {
    // Estado general de la Excepción
    int httpStatus = ve.getStatus();
    String exceptionMessage = ve.getMessage();

    // Detalle de error en DECIDIR
    ValidateError errorDetail = ve.getErrorDetail();
}
```

<a name="validateStatusException"></a>
#### ValidateStatusException

Es lanzado cuando DECIDIR intenta realizar operaciones con estados no esperados.

#### Atributos
    - status: int
    - message: String
    - errorDetail: ValidateStatusError
*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>ValidateStatusException</code>:
```java
try {
    // ...codigo...
    // Pago enviado a DECIDIR
    // ...codigo...
} catch (ValidateStatusException ve) {
    // Estado general de la Excepción
    int httpStatus = ve.getStatus();
    String exceptionMessage = ve.getMessage();

    // Detalle de error en DECIDIR
    ValidateStatusError errorDetail = ve.getErrorDetail().getValidation_errors().getStatus();
}
```

<a name="apiException"></a>
#### ApiException

Es lanzado por los siguientes motivos:
* Inconvenientes de acceso a los endpoints del API DECIDIR
* ApiKey incorrecta
* Llamadas demasiado frecuentes al API DECIDIR

#### Atributos
    - status: int
    - message: String
    - errorDetail: ApiError
*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>ApiException</code>:
```java
try {
    // ...codigo...
    // Pago enviado a DECIDIR
    // ...codigo...
} catch (ApiException ae) {
    // Estado general de la Excepción
    int httpStatus = ae.getStatus();
    String exceptionMessage = ae.getMessage();

    // Detalle de error en DECIDIR
    ApiError errorDetail = ae.getErrorDetail();
}
```

<a name="notFoundException"></a>
#### NotFoundException

Es lanzado cuando DECIDIR intenta procesar datos incompletos o no existentes en DECIDIR.

#### Atributos
    - status: int
    - message: String
    - errorDetail: NotFoundError
*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>NotFoundException</code>:
```java
try {
    // ...codigo...
    // Pago enviado a DECIDIR
    // ...codigo...
} catch (NotFoundException nfe) {
    int httpStatus = nfe.getStatus();
    String exceptionMessage = nfe.getMessage();

    // Detalle de error en DECIDIR
    NotFoundError errorDetail = nfe.getErrorDetail();
}
```

<a name="refundException"></a>
### RefundException

Es lanzado cuando DECIDIR rechaza:

* Devoluciones totales
* Devoluciones parciales
* Anulaciones

#### Atributos
    - status: int
    - message: String
    - refundPaymentResponse: RefundPaymentResponse

*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>RefundException</code>:
```java
try {
    // ...codigo...
    // Devolución enviada a DECIDIR
    // ...codigo...
} catch (RefundException re) {
    // Estado general de la Excepción
    int httpStatus = re.getStatus();
    String exceptionMessage = re.getMessage();
    
    // Respuesta de DECIDIR
    RefundPaymentResponse refundPayment = re.getRefundPayment();
}
```

<a name="annulRefundException"></a>
### AnnulRefundException

Es lanzado cuando DECIDIR rechaza:

* Anulaciones de devoluciones totales
* Anulaciones de devoluciones parciales

#### Atributos
    - status: int
    - message: String
    - annulRefundResponse: AnnulRefundResponse

*Ver los valores posibles en la tabla de [Atributos de Excepciones](#atributosExcepciones)*

Ejemplo de cómo capturar el <code>AnnulRefundException</code>:
```java
try {
    // ...codigo...
    // Anulación de devolución enviada a DECIDIR
    // ...codigo...
} catch (AnnulRefundException are) {
    // Estado general de la Excepción
    int httpStatus = are.getStatus();
    String exceptionMessage = are.getMessage();

    // Respuesta de DECIDIR
    AnnulRefundResponse annulRefund = are.getAnnulRefund();
}
```

[<sub>Volver a inicio</sub>](#inicio)

<a name="tablasreferencia"></a>

## Tablas de Referencia

<a name="codigos-de-medios-de-pago"></a>

### Códigos de Medios de pago

| MEDIO DE PAGO | NOMBRE |
----------------|--------
| 1 | VISA |
| 8 | DINERS |
| 15 | MASTERCARD |
| 20 | MASTERCARD TEST |
| 23 | TARJETA SHOPPING |
| 24 | TARJETA NARANJA |
| 25 | PAGO FACIL |
| 26 | RAPIPAGO |
| 27 | CABAL |
| 29 | ITALCRED |
| 30 | ARGENCARD |
| 31 | VISA DEBITO<sup>1</sup> |
| 34 | COOPEPLUS |
| 36 | ARCASH |
| 37 | NEXO |
| 38 | CREDIMAS |
| 39 | TARJETA NEVADA |
| 41 | PAGOMISCUENTAS |
| 42 | NATIVA |
| 43 | TARJETA MAS |
| 44 | TARJETA CARREFOUR |
| 45 | TARJETA PYMENACION |
| 46 | PAYSAFECARD |
| 47 | MONEDERO ONLINE |
| 48 | CAJA DE PAGOS |
| 50 | BBPS |
| 51 | COBRO EXPRESS |
| 52 | QIDA |
| 53 | LAPOS WEB TRAVEL |
| 54 | GRUPAR |
| 55 | PATAGONIA 365 |
| 56 | TARJETA CLUD DIA |
| 59 | TARJETA TUYA |
| 60 | DISTRIBUTION |
| 61 | LA ANONIMA |
| 62 | CREDIGUIA |
| 63 | CABAL PRISMA |
| 64 | TARJETA SOL |
| 65 | AMEX |
| 66 | MC DEBIT |
| 67 | CABAL DEBITO (Cabal24) |
| 99 | MAESTRO |

1. Visa Debito no acepta devoluciones parciales en ecommerce.

[<sub>Volver a inicio</sub>](#inicio)

<a name="divisasa"></a>

### Divisas Aceptadas

| Divisa | Descripción | Código API
---------|-------------|--------
| AR$ | Pesos Argentinos | ARS
| U$S | Dólares Americanos | USD

**NOTA** Si bien la API RESTful de DECIDIR admite compras en Dólares Americanos, la legislación argentina sólo permite transacciones en Pesos Argentinos. Es por esto que DECIDIR recomienda que todas las transacciones se cursen en dicha moneda.

[<sub>Volver a inicio</sub>](#inicio)

<a name="provincias"></a>

### Provincias

| Provincia | Código |
|----------|-------------|
| CABA | C |
| Buenos Aires | B |
| Catamarca | K |
| Chaco | H |
| Chubut | U |
| Córdoba | X |
| Corrientes | W |
| Entre Ríos | R |
| Formosa | P |
| Jujuy | Y |
| La Pampa | L |
| La Rioja | F |
| Mendoza | M |
| Misiones | N |
| Neuquén | Q |
| Río Negro | R |
| Salta | A |
| San Juan | J |
| San Luis | D |
| Santa Cruz | Z |
| Santa Fe | S |
| Santiago del Estero | G |
| Tierra del Fuego | V |
| Tucumán | T |

[<sub>Volver a inicio</sub>](#inicio)

<a name="parametros"></a>

### Parámetros
En ésta sección se describirán todos los parámetros utilizados por la SDK para realizar Operaciones 
y Transacciones.

<a name="parametrosPago"></a>
#### Parámetros de Pagos

|Campo              |Definición                                                                                                                                               |Obligatorio(SI/NO)|Validación                                                                                                        |Ejemplo                                |
|:------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------|:-----------------------------------------------------------------------------------------------------------------|:--------------------------------------|
|user_id            |usuario que esta haciendo uso del sitio (se utiliza para tokenizacion)                                                                                   |Condicional       |Sin validacion                                                                                                    |user_id: "marcos"                      |
|site_transaction_id|nro de operacion                                                                                                                                         |SI                |Alfanumerico de hasta 39 caracteres                                                                               |site_transaction_id: "prueba 1"        |
|site_id            |Site relacionado a otro site, este mismo no requiere del uso de la apikey ya que para el pago se utiliza la apikey del site al que se encuentra asociado.|NO                |Se debe encontrar configurado en la tabla site_merchant como merchant_id del site_id</br>Numérico de 8 caracteres.|site_id: "28464385"                    |
|token              |token generado en el primer paso                                                                                                                         |SI                |Alfanumerico de hasta 36 caracteres. No se podra ingresar un token utilizado para un  pago generado anteriormente.|token: ""                              |
|payment_method_id  |id del medio de pago                                                                                                                                     |SI                |El id debe coincidir con el medio de pago de tarjeta ingresada.                                                   |payment_method_id: 1                   |
|bin                |primeros 6 numeros de la tarjeta                                                                                                                         |SI                |Se valida que sean los primeros 6 digitos de la tarjeta ingresada al generar el token.                            |bin: "456578"                          |
|amount             |importe del pago                                                                                                                                         |SI                |Importe minimo = 1 ($0.01)</br> Importe Maximo = 9223372036854775807 ($92233720368547758.07)                      |amount: 20000                          |
|currency           |moneda                                                                                                                                                   |SI                |Valor permitido: ARS                                                                                              |currency: "ARS"                        |
|installments       |cuotas del pago                                                                                                                                          |SI                |Valor minimo = 1</br>Valor maximo = 99                                                                            |installments: 1                        |
|payment_type       |forma de pago                                                                                                                                            |SI                |Valor permitido: single / distributed                                                                             |payment_type: "single"                 |
|establishment_name |nombre de comercio                                                                                                                                       |Condicional       |Alfanumerico de hasta 25 caracteres                                                                               |establishment_name : "prueba desa soft"|


<a name="parametrosPMC"></a>
##### Parámetros para PagoMisCuentas

|Campo             |Definición                                                                                                                    |Obligatorio(SI/NO)|Validación          |Ejemplo                           |
|:-----------------|:-----------------------------------------------------------------------------------------------------------------------------|:-----------------|:-------------------|:---------------------------------|
|bank_code         |ID del banco que se utilizara para realizar el pago.</br>Se guarda en la tabla spstransac.idbanco                             |SI                |Dato variable       |bank_code : "17"                  |
|invoice_expiration|Fecha y hora de vencimiento de la factura. Puede omitirse las 'horas' y 'minutos', informando solo la fecha con formato DDMMYY|SI                |Formato: DDMMYY HHMM|invoice_expiration : "311219 2359"|

[<sub>Volver a inicio</sub>](#inicio)

<a name="parametrosOffline"></a>
##### Parámetros para Pagos Offline

|Campo             |Definición                                                                                                                                    |Obligatorio(SI/NO)|Validación                            |Ejemplo                        |
|:-----------------|:---------------------------------------------------------------------------------------------------------------------------------------------|:-----------------|:-------------------------------------|:------------------------------|
|cod_p3            |Son los días que existen entre el 1º y 2º vencimiento de la factura. Poner “00” si la factura no tiene 2º vencimiento.                        |SI                |Longitud 2 caracteres numéricos       |"cod_p3": "11"                 |
|cod_p4            |Son los días después del 1º vencimiento y hasta el que el cliente puede pagar la factura por Rapipago.                                        |SI                |Longitud 3 caracteres numéricos       |"cod_p4": "134"                |
|client            |-Código de cliente provisto al momento de habilitar al comercio.</br>-Nro de establecimiento visa dentro de visa, nro fijo para cada comercio|SI                |8 dígitos numericos , dato fijo       |"client": "12345678"           |
|surcharge         |Recargo por Vto. del plazo, dato generado por el comercio. Es un monto (no un porcentaje). 5 cifras enteras y 2 decimales.                    |SI                |Longitud máxima 7 caracteres numericos|"surcharge": 1234567           |
|invoice_expiration|Fecha de vencimiento para el pago del cupón, dato generado por el comercio                                                                    |SI                |Formato: AAMMDD                       |"invoice_expiration" : "191223"|

[<sub>Volver a inicio</sub>](#inicio)

<a name="parametrosDistMonto"></a>
##### Parámetros para Pagos Distribuidos por Monto


|Campo                    |Definición                    |Obligatorio(SI/NO)|Validación                                                                          |Ejemplo            |
|:------------------------|:-----------------------------|:-----------------|:-----------------------------------------------------------------------------------|:------------------|
|sub_payments.site_id     |site_id del sub_payment       |SI                |Numérico de 8 caracteres, se debe encontrar habilitado y vinculado al site padre    |site_id: "28464384"|
|sub_payments.installments|Cuotas del sub_payment        |SI                |Valor minimo = 1 </br> Valor maximo = 99                                            |installments: 5    |
|sub_payments.amount      |Monto que lleva el sub_payment|SI                |Monto total para un pago = 9223372036854775807. Este mismo es parte del amount Total|amount: 10000      |

[<sub>Volver a inicio</sub>](#inicio)

<a name="parametrosDistPorc"></a>
##### Parámetros para Pagos Distribuidos por Porcentaje

Las transacciones distribuidas por Porcentaje no llevan parámetros adicionales pues 
la distribución de pagos se realiza estáticamente.

[<sub>Volver a inicio</sub>](#inicio)

<a name="parametrosAgregador"></a>
##### Parámetros para pagos de Comercios Agregadores.


|Campo                |Definición                                                                           |Obligatorio(SI/NO)    |Validación                                                                           |Ejemplo                                |
|:--------------------|:------------------------------------------------------------------------------------|:---------------------|:------------------------------------------------------------------------------------|:--------------------------------------|
|indicator            |Indicador del tipo de documento                                                      |SI                    |Numérico, 1 dígito.</br>Valores posibles: 0 CUIT, 1 CUIL, 2 Número único             |"indicator" : "0"                      |
|identification_number|Numero de CUIT, CUIL o Numero Único (en este caso completar con ceros a la izquierda)|SI                    |Caracter, 11 posiciones                                                              |"identification_number" : "20380902325"|
|bill_to_pay          |Numero de Factura a Pagar                                                            |SI (Visa), NO (Master)|Alfanumérico 12 caracteres.                                                          |"bill_to_pay" : "1234km1"              |
|bill_to_refund       |Número de factura de anulación/Devolución                                            |SI (Visa), NO (Master)|Alfanumérico 12 caracteres.                                                          |"bill_to_refund" : "1234567m90120"     |
|merchant_name        |Nombre de comercio o nombre y apellido del vendedor                                  |SI (Visa), NO (Master)|Alfanumérico 20 caracteres. En caso de nombre y apellido, deben estar separados por /|"merchant_name" : "dario/gomez"        |
|street               |Dirección del comercio o del vendedor                                                |SI (Visa), NO (Master)|Alfanumérico 20 caracteres.                                                          |"street" : "Jose Maria"                |
|number               |Número de puerta                                                                     |SI (Visa), NO (Master)|Alfanumérico 6 caracteres.                                                           |"number" : "9898"                      |
|postal_code          |Código postal                                                                        |SI (Visa), NO (Master)|Alfanumérico 8 caracteres.                                                           |"postal_code" : "1234"                 |
|category             |Código de actividad (rubro)                                                          |SI (Visa), NO (Master)|Alfanumérico 5 caracteres.                                                           |"category" : "1234m"                   |
|channel              |Código de canal                                                                      |SI (Visa), NO (Master)|Alfanumérico 3 caracteres.                                                           |"channel" : "89j"                      |
|geographic_code      |Código geográfico del vendedor                                                       |SI (Visa), NO (Master)|Alfanumérico 5 caracteres.                                                           |"geographic_code" : "12345"            |
|city		      |Ciudad del domicilio del comercio vendedor                                           |SI (Amex), NO (Visa / Master)|Alfanumérico 15 caracteres como máximo.                                       |"city" : "C.A.B.A."	                 |
|merchant_id	      |Identificador único del comercio vendedor                                            |SI (Amex), NO (Visa / Master)|Numérico de 16 dígitos como máximo.                                       	 |"merchant_id" : "12345"     		 |
|province  	      |Provincia del comercio vendedor                                                      |SI (Amex), NO (Visa / Master)|Caracter 1 posición. [<sub>Valores posibles</sub>](#provincias)               |"province" : "C"                       |
|country     	      |País del comercio vendedor	                                                    |SI (Amex), NO (Visa / Master)|Numérico de 3 caracteres. </br> "032" para Argentina                          |"country" : "032"                      |
|merchant_email       |Email del comercio vendedor                                                          |SI (Amex), NO (Visa / Master)|Alfanumérico 40 caracteres como máximo.                                       |"merchant_email" : "com@decidir.com"   |
|merchant_phone       |Teléfono del comercio vendedor                                                       |SI (Amex), NO (Visa / Master)|Numérico 20 caracteres como máximo.                                           |"merchant_phone" : "48021111"          |

[<sub>Volver a inicio</sub>](#inicio)


<a name="parametrosDevolucion"></a>
#### Parámetros para Devoluciones parciales, totales y Anulaciones.


|Campo |Definición                                                                                                                                                                                                                       |Obligatorio(SI/NO)|Validación                                                                                          |Ejemplo     |
|:-----|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------|:---------------------------------------------------------------------------------------------------|:-----------|
|amount|Importe del pago a devolver.</br> Si se completa el campo antes del cierre por un monto menor al de la compra se toma como devolucion parcial</br> Si se ingresa el monto total o no se envia dicho campo se toma como anulacion.|NO                |Monto total para un pago = 9223372036854775807. Este mismo se debe distribuir sobre los subpayments.|amount: 1000|

[<sub>Volver a inicio</sub>](#inicio)

<a name="atributosExcepciones"></a>

### Atributos de Excepciones

|Atributo         |Tipo                 |Descripción                     |Pertenece a                                                                                                |
|:----------------|:--------------------|:-------------------------------|:----------------------------------------------------------------------------------------------------------|
|status           |int                  |Estado HTTP                     |Todas                                                                                                      |
|message          |String               |Descripción del Estado HTTP     |Todas                                                                                                      |
|errorDetail      |ValidateError        |Descripción del error           |[ValidateException](#validateException)                                                                    |
|errorDetail      |ValidateStatusError  |Descripción del error           |[ValidateStatusException](#validateStatusException)                                                                    |
|errorDetail      |ApiError             |Descripción del error           |[ApiException](#apiException)                                                                              |
|errorDetail      |NotFoundError        |Descripción del error           |[NotFoundException](#notFoundException)                                                                    |
|validation_errors|List<ValidationError>|Lista de Errores de validación  |[ValidateError](#validateException)                                                                        |
|validation_errors|ValidationStatus     |Validación del estado erróneo   |[ValidateStatusError](#validateStatusException)                                                                        |
|code             |String               |Código de error                 |[ValidationError](#validateException)<br/>[ApiError](#apiException)<br/>[NotFoundError](#notFoundException)|
|param            |String               |Parámetro involucrado           |[ValidationError](#validateException)                                                                      |
|message          |String               |Descripción del error           |[ApiError](#apiException)<br/>[NotFoundError](#notFoundException)                                          |
|id               |String               |Valor identificatorio           |[NotFoundError](#notFoundException)                                                                        |
|entityName       |String               |Nombre de la entidad involucrada|[NotFoundError](#notFoundException)                                                                        |

[<sub>Volver a inicio</sub>](#inicio)

<a name="erroresSistema"></a>

### Errores de Sistema
Estos códigos de Errores son los status en las Excepciones.

|Código(HTTP)|Mensaje                |Descripción                                     |
|:-----------|:----------------------|:-----------------------------------------------|
|400         |malformed_request_error|Error en la comunicación del SDK con el API REST|
|401         |authentication_error   |ApiKey Inválido                                 |
|402         |invalid_request_error  |Error por datos inválidos                       |
|404         |not_found_error        |Error con datos no encontrados                  |
|409         |api_error              |Error inesperado en la API REST                 |

[<sub>Volver a inicio</sub>](#inicio)
