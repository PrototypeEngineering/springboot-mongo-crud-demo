package com.pe.mongo.engine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.mongo.engine.exception.MongoDataNotFoundException;
import com.pe.mongo.engine.exception.MongoCreateException;
import com.pe.mongo.engine.model.DataObject;
import com.pe.mongo.engine.repository.MongoDataObject;

@Service
public class MongoServiceImpl implements MongoService {

	@Autowired
	private MongoDataObject mongoRepository;

	public DataObject save(DataObject object) throws MongoCreateException {
		DataObject dataObject = this.mongoRepository.insert(object);
		if (dataObject == null) {
			throw new MongoCreateException("cannot be created");
		}
		return dataObject;
	}

	public boolean delete(String objectId) throws MongoDataNotFoundException {
		Optional<DataObject> optional = this.mongoRepository.findById(objectId);
		if (!optional.isPresent()) {
			throw new MongoDataNotFoundException("NOT FOUNF");
		} else {
			this.mongoRepository.delete(optional.get());
			return true;
		}
	}

	public DataObject update(DataObject dataObject, String objectId) throws MongoDataNotFoundException {
		DataObject updateDataObject = mongoRepository.findById(objectId).get();
		updateDataObject.setData_name(dataObject.getData_name());
		updateDataObject.setDate_type(dataObject.getDate_type());
		mongoRepository.save(updateDataObject);
		return updateDataObject;
	}

	public DataObject getMongoDataById(String objectId) throws MongoDataNotFoundException {
		Optional<DataObject> optional = this.mongoRepository.findById(objectId);
		if (!optional.isPresent()) {
			throw new MongoDataNotFoundException("NOT FOUNF");
		} else {
			return optional.get();
		}
	}

	public List<DataObject> getAllMongoDatas() {
		return this.mongoRepository.findAll();
	}

}
