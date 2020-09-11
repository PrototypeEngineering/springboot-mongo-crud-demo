package com.pe.mongo.engine.service;

import java.util.List;

import com.pe.mongo.engine.exception.MongoDataNotFoundException;
import com.pe.mongo.engine.exception.MongoCreateException;
import com.pe.mongo.engine.model.DataObject;

public interface MongoService {
	
	DataObject save(DataObject objectId) throws MongoCreateException;

    boolean delete(String objectId) throws MongoDataNotFoundException;

    DataObject update(DataObject object, String objectId) throws MongoDataNotFoundException;

    DataObject getMongoDataById(String objectId) throws MongoDataNotFoundException;

    List<DataObject> getAllMongoDatas();
    
}
