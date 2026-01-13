package com.lwk.microservices.service;

import org.springframework.http.ResponseEntity;

import com.lwk.microservices.dto.ShipmentDTO;

public interface ShipmentService {
	
	ResponseEntity<Object> addShipment(ShipmentDTO shipmentModel);
	
	ResponseEntity<Object> getAllShipments();
	
	ResponseEntity<Object> updateShipment(int id, ShipmentDTO shipmentModel);
	
	ResponseEntity<Object> deleteShipment(int id);

}
