package com.lwk.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwk.microservices.dto.ShipmentDTO;
import com.lwk.microservices.service.ShipmentServiceImpl;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

	@Autowired
	private ShipmentServiceImpl shipmentServiceImpl;
	
	@PostMapping("/add")
    public ResponseEntity<Object> postShipment(@RequestBody ShipmentDTO shipmentModel) {

		return shipmentServiceImpl.addShipment(shipmentModel);
	}
	
	@GetMapping("/all")
    public ResponseEntity<Object> getShipment() {

		return shipmentServiceImpl.getAllShipments();
    }
	
	@PatchMapping("/update/{id}")
    public ResponseEntity<Object> updateShipment(@PathVariable int id,  @RequestBody ShipmentDTO shipmentModel) {

		return shipmentServiceImpl.updateShipment(id, shipmentModel);
    }
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteShipment(@PathVariable int id) {
        return shipmentServiceImpl.deleteShipment(id);
    }

}
