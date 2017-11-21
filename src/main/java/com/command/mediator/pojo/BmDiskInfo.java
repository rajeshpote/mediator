package com.command.mediator.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bm_disk_info")
public class BmDiskInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@JsonProperty("number_of_disks")
	@Column(name = "number_of_disks")
	private String numberOfDisks;
	
	@JsonProperty("size")
	@Column(name = "size")
	private String size;

	public String getNumberOfDisks() {
		return numberOfDisks;
	}

	public void setNumberOfDisks(String numberOfDisks) {
		this.numberOfDisks = numberOfDisks;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "BmDiskInfo [numberOfDisks=" + numberOfDisks + ", size=" + size + "]";
	}

	
}
