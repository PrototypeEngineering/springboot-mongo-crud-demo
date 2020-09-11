package com.pe.mongo.engine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pe.mongo.engine.model.DataObject;

@Repository
public interface MongoDataObject extends MongoRepository<DataObject, String> {

}
