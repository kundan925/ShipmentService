package com.lwk.microservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lwk.microservices.dto.ShipmentDTO;
import com.lwk.microservices.entity.Shipment;
import com.lwk.microservices.entity.User;
import com.lwk.microservices.repository.ShipmentRepository;
import com.lwk.microservices.repository.UserRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService{
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<Object> addShipment(ShipmentDTO shipmentModel) {
		if(shipmentModel == null) {
			return ResponseEntity.badRequest().body("Invalid shipment data");
		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByName(username)
		        .orElseThrow(() -> new RuntimeException("User not found"));
		
		Shipment newShipment = new Shipment();
		newShipment.setRecieverName(shipmentModel.getRecieverName());
		newShipment.setOrigin(shipmentModel.getOrigin());
		newShipment.setDestination(shipmentModel.getDestination());
		newShipment.setStatus(shipmentModel.getStatus());
		newShipment.setTrackingNumber(shipmentModel.getTrackingNumber());
		newShipment.setShipmentMethod(shipmentModel.getShipmentMethod());
		newShipment.setSenderId(user.getId());
		
		Shipment savedShipment = shipmentRepository.save(newShipment);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedShipment);
	}

	
	public ResponseEntity<Object> getAllShipments() {
		
		List<Shipment> shipments = shipmentRepository.findAll();
		if(shipments.isEmpty()) {
			return ResponseEntity.badRequest().body("No shipments found");
		}
		return ResponseEntity.ok(shipments);
	}


	public ResponseEntity<Object> updateShipment(int id, ShipmentDTO shipmentModel) {
		
		Optional<Shipment> optionalShipment = shipmentRepository.findById(id);

	    if (optionalShipment.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("shipment not found");	    }

	    Shipment shipment = optionalShipment.get();
	    shipment.setStatus(shipmentModel.getStatus());

	    Shipment updatedShipment = shipmentRepository.save(shipment);
	    return ResponseEntity.ok(updatedShipment);
	}


	@Override
	public ResponseEntity<Object> deleteShipment(int id) {
		Optional<Shipment> optionalShipment = shipmentRepository.findById(id);
		if(optionalShipment.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shipment not found for delete");
		}
		Shipment shipment = optionalShipment.get();
		shipmentRepository.delete(shipment);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	

}
