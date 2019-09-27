package com.decidir.sdk.dto.payments;

import com.decidir.sdk.dto.Status;

import java.io.Serializable;

/**
 * Represents a subpayment.
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code ...
 * SubPayment subPayment = new SubPayment();
 * subPayment.setSite_id("0000001");
 * subPayment.setInstallments(1);
 * subPayment.setAmount(23250L);//Amount in cents: $232.50 
 * ...
 * }
 * </pre>
 */
public class SubPayment implements Serializable {

  private String site_id;
  private Integer installments;
  private Long amount;
  private String ticket;
  private String card_authorization_code;
  private Long subpayment_id;
  private Status status;

  public String getSite_id() {
    return site_id;
  }

  public void setSite_id(String site_id) {
    this.site_id = site_id;
  }

  public Integer getInstallments() {
    return installments;
  }

  public void setInstallments(Integer installments) {
    this.installments = installments;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public String getCard_authorization_code() {
    return card_authorization_code;
  }

  public void setCard_authorization_code(String card_authorization_code) {
    this.card_authorization_code = card_authorization_code;
  }

  public Long getSubpayment_id() {
    return subpayment_id;
  }

  public void setSubpayment_id(Long subpayment_id) {
    this.subpayment_id = subpayment_id;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Status getStatus() { return this.status; }
}
