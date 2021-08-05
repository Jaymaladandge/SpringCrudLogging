package com.mainApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pf_process")
public class PFProcess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pf_num")
	private long pfNum;

	@Column
	private double amount;

	@Column(name = "empid")
	private long empId;

	public long getPfNum() {
		return pfNum;
	}

	public void setPfNum(long pfNum) {
		this.pfNum = pfNum;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PFProcess [pfNum=" + pfNum + ", amount=" + amount + ", empId=" + empId + "]";
	}

}
