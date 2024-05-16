package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int ID;
	
	@Column(name = "computerId")
	private Integer computerId;
	
	@Column(name = "soluong")
	private int soluong;
	
	@Column(name = "gia")
	private float gia;
	
//	@ManyToOne
//	@JoinColumn(name = "OrderID")
//	Order order;
	

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public Integer getComputerId() {
		return computerId;
	}

	public void setComputerId(Integer computerId) {
		this.computerId = computerId;
	}

	public float getGia() {
		return gia;
	}

//	public OrderDetail(int iD, Integer computerId, int soluong, float gia, Order order) {
//		super();
//		ID = iD;
//		this.computerId = computerId;
//		this.soluong = soluong;
//		this.gia = gia;
//		this.order = order;
//	}
//
//	

	
	
}
