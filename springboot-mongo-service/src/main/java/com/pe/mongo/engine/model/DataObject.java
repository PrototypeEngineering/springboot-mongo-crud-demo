package com.pe.mongo.engine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DataObject {

	@Id
	private String data_id;
	private String data_name;
	private String date_type;

	public String getData_id() {
		return data_id;
	}

	public void setData_id(String data_id) {
		this.data_id = data_id;
	}

	public String getData_name() {
		return data_name;
	}

	public void setData_name(String data_name) {
		this.data_name = data_name;
	}

	public String getDate_type() {
		return date_type;
	}

	public void setDate_type(String date_type) {
		this.date_type = date_type;
	}

	@Override
	public String toString() {
		return "DataObject [data_id=" + data_id + ", data_name=" + data_name + ", date_type=" + date_type + "]";
	}

}
