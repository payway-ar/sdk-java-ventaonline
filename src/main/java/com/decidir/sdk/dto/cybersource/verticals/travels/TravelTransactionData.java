package com.decidir.sdk.dto.cybersource.verticals.travels;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ivalek on 11/06/17.
 */
public class TravelTransactionData implements Serializable{

    private String reservation_code;
    private Boolean third_party_booking;
    private String departure_city;
    private String final_destination_city;
    private Boolean international_flight;
    private String frequent_flier_number;
    private String class_of_service;
    private DayOfWeekOfFlight day_of_week_of_flight;
    private Integer week_of_year_of_flight;
    private String airline_code;
    private String code_share;    
    private Integer airline_number_of_passengers;
    private DecisionManagerTravel decision_manager_travel;
    private List<Passenger> passengers;
    
    
	public String getReservation_code() {
		return reservation_code;
	}
	public void setReservation_code(String reservation_code) {
		this.reservation_code = reservation_code;
	}
	public Boolean getThird_party_booking() {
		return third_party_booking;
	}
	public void setThird_party_booking(Boolean third_party_booking) {
		this.third_party_booking = third_party_booking;
	}
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getFinal_destination_city() {
		return final_destination_city;
	}
	public void setFinal_destination_city(String final_destination_city) {
		this.final_destination_city = final_destination_city;
	}
	public Boolean getInternational_flight() {
		return international_flight;
	}
	public void setInternational_flight(Boolean international_flight) {
		this.international_flight = international_flight;
	}
	public String getFrequent_flier_number() {
		return frequent_flier_number;
	}
	public void setFrequent_flier_number(String frequent_flier_number) {
		this.frequent_flier_number = frequent_flier_number;
	}
	public String getClass_of_service() {
		return class_of_service;
	}
	public void setClass_of_service(String class_of_service) {
		this.class_of_service = class_of_service;
	}
	public DayOfWeekOfFlight getDay_of_week_of_flight() {
		return day_of_week_of_flight;
	}
	public void setDay_of_week_of_flight(DayOfWeekOfFlight day_of_week_of_flight) {
		this.day_of_week_of_flight = day_of_week_of_flight;
	}
	public Integer getWeek_of_year_of_flight() {
		return week_of_year_of_flight;
	}
	public void setWeek_of_year_of_flight(Integer week_of_year_of_flight) {
		this.week_of_year_of_flight = week_of_year_of_flight;
	}
	public String getAirline_code() {
		return airline_code;
	}
	public void setAirline_code(String airline_code) {
		this.airline_code = airline_code;
	}
	public String getCode_share() {
		return code_share;
	}
	public void setCode_share(String code_share) {
		this.code_share = code_share;
	}
	public Integer getAirline_number_of_passengers() {
		return airline_number_of_passengers;
	}
	public void setAirline_number_of_passengers(Integer airline_number_of_passengers) {
		this.airline_number_of_passengers = airline_number_of_passengers;
	}
	public DecisionManagerTravel getDecision_manager_travel() {
		return decision_manager_travel;
	}
	public void setDecision_manager_travel(DecisionManagerTravel decision_manager_travel) {
		this.decision_manager_travel = decision_manager_travel;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
    
    
}
