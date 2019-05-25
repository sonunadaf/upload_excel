package com.xworkz.application.fileupload.entity.uploadFile;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "election_result_19")
public class UploadEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int id;
	@Column(name = "PARTY_ID")
	private Double partyId;
	@Column(name = "PARTY_NAME")
	private String partyName;
	@Column(name = "WON")
	private Double won;
	@Column(name = "LOST")
	private Double lost;
	@Column(name = "STATE")
	private String state;

	public UploadEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPartyId() {
		return partyId;
	}

	public void setPartyId(Double partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public Double getWon() {
		return won;
	}

	public void setWon(Double won) {
		this.won = won;
	}

	public Double getLost() {
		return lost;
	}

	public void setLost(Double lost) {
		this.lost = lost;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
