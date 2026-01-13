package com.lwk.microservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Shipment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "RecieveName")
	private String recieverName;
	
	@Column(name = "Origin")
	private String origin;
	
	@Column(name = "Destination")
	private String destination;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "TrackingNumber")
	private String trackingNumber;
	
	@Column(name = "ShipmentMethod")
	private String shipmentMethod;
	
	@Column(name = "SenderId")
	private Integer senderId;
	

}
