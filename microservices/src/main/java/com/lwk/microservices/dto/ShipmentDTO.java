package com.lwk.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDTO {

	private String recieverName;
	
	private String origin;
	
	private String destination;
	
	private String status;
	
	private String trackingNumber;
	
	private String shipmentMethod;
	
}
