package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	

	@Column(name = "username")
	private String username;
	
	@Column(name = "diachi")
	private String diachi;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "tien")
	private float tien;
	
	@Column(name = "soluong")
	private int soluong;
	
	@Column(name = "computerId")
	private int computerId;
	
	@Column(name = "ngaymua")
	private LocalDate ngaymua;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
//	private List<OrderDetail> orderDetails;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

//	public Order(int id, String username, String diachi, String sdt, float tien, int soluong, int computerId,
//			LocalDate ngaymua, List<OrderDetail> orderDetails) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.diachi = diachi;
//		this.sdt = sdt;
//		this.tien = tien;
//		this.soluong = soluong;
//		this.computerId = computerId;
//		this.ngaymua = ngaymua;
//		this.orderDetails = orderDetails;
//	}
	
	



	public int getId() {
		return id;
	}

	public Order(int id, String username, String diachi, String sdt, float tien, int soluong, int computerId,
		LocalDate ngaymua) {
	super();
	this.id = id;
	this.username = username;
	this.diachi = diachi;
	this.sdt = sdt;
	this.tien = tien;
	this.soluong = soluong;
	this.computerId = computerId;
	this.ngaymua = ngaymua;
}



	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getTien() {
		return tien;
	}

	public void setTien(float tien) {
		this.tien = tien;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getComputerId() {
		return computerId;
	}

	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}

	public LocalDate getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(LocalDate ngaymua) {
		this.ngaymua = ngaymua;
	}



	public String getDiachi() {
		return diachi;
	}



	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}



	public String getSdt() {
		return sdt;
	}



	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	
}
