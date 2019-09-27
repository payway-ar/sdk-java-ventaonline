package com.decidir.sdk.dto.payments.bsa;

import com.decidir.sdk.dto.payments.Identification;

public class CardTokenBsa {

    private Identification card_holder_identification;
    private String volatile_encrypted_data ;
    private String public_request_key;
    private String public_token;
    private String issue_date;
    private String flag_security_code;
    private String flag_tokenization;
    private String flag_selector_key;
    private String flag_pei;
    private String card_holder_name;


    public String getVolatile_encrypted_data() {
        return volatile_encrypted_data;
    }

    public void setVolatile_encrypted_data(String volatile_encrypted_data) {
        this.volatile_encrypted_data = volatile_encrypted_data;
    }

    public String getPublic_request_key() {
        return public_request_key;
    }

    public void setPublic_request_key(String public_request_key) {
        this.public_request_key = public_request_key;
    }

    public String getPublic_token() {
        return public_token;
    }

    public void setPublic_token(String public_token) {
        this.public_token = public_token;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getFlag_security_code() {
        return flag_security_code;
    }

    public void setFlag_security_code(String flag_security_code) {
        this.flag_security_code = flag_security_code;
    }

    public String getFlag_tokenization() {
        return flag_tokenization;
    }

    public void setFlag_tokenization(String flag_tokenization) {
        this.flag_tokenization = flag_tokenization;
    }

    public String getFlag_selector_key() {
        return flag_selector_key;
    }

    public void setFlag_selector_key(String flag_selector_key) {
        this.flag_selector_key = flag_selector_key;
    }

    public String getFlag_pei() {
        return flag_pei;
    }

    public void setFlag_pei(String flag_pei) {
        this.flag_pei = flag_pei;
    }

    public String getCard_holder_name() {
        return card_holder_name;
    }

    public void setCard_holder_name(String card_holder_name) {
        this.card_holder_name = card_holder_name;
    }

    public Identification getCard_holder_identification() {
        return card_holder_identification;
    }

    public void setCard_holder_identification(Identification card_holder_identification) {
        this.card_holder_identification = card_holder_identification;
    }
}
