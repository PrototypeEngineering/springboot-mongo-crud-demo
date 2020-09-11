package com.pe.mongo.engine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.mongo.engine.exception.MongoDataNotFoundException;
import com.pe.mongo.engine.exception.MongoCreateException;
import com.pe.mongo.engine.model.DataObject;
import com.pe.mongo.engine.service.MongoService;

@RestController
@RequestMapping("/api/engine")
public class MongoServiceController {

	@Autowired
	private MongoService mongoService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody final DataObject dataObject) {
		try {
			mongoService.save(dataObject);
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		} catch (MongoCreateException e) {
			return new ResponseEntity<String>("Conflict", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			mongoService.delete(id);
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		} catch (MongoDataNotFoundException e) {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody DataObject dataObject, @PathVariable String id) {
		try {
			DataObject object = mongoService.update(dataObject, id);
			return new ResponseEntity<DataObject>(object, HttpStatus.OK);
		} catch (MongoDataNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getMongoDataById/{id}")
	public ResponseEntity<?> getMongoData(@PathVariable String id) {
		try {
			DataObject dataObject = mongoService.getMongoDataById(id);
			return new ResponseEntity<DataObject>(dataObject, HttpStatus.OK);
		} catch (MongoDataNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getMongoDatas() {
		return new ResponseEntity<List<DataObject>>(mongoService.getAllMongoDatas(), HttpStatus.OK);
	}

}
