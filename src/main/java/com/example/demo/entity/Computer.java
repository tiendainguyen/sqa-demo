package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "computers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int ID;
	
	@Column(name = "ten", nullable = false)
	private String ten;
	
	@Column(name = "cpu")
	private String cpu;
	
	@Column(name = "ram")
	private String ram;
	
	@Column(name = "ocung")
	private String ocung;
	
	@Column(name = "manhinh")
	private String manhinh;
	
	@Column(name = "hedieuhanh")
	private String hedieuhanh;
	
	@Column(name = "hangsanxuat")
	private String hangsanxuat;
	
	@Column(name = "dongia")
	private float dongia;
	
	@Column(name = "soluong")
	private int soluong;
	
	@Column(name = "anh")
	private String anh;
	
//	@OneToMany(mappedBy = "computer")
//	List<OrderDetail> orderDetails;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getOcung() {
		return ocung;
	}

	public void setOcung(String ocung) {
		this.ocung = ocung;
	}

	public String getManhinh() {
		return manhinh;
	}

	public void setManhinh(String manhinh) {
		this.manhinh = manhinh;
	}

	public String getHedieuhanh() {
		return hedieuhanh;
	}

	public void setHedieuhanh(String hedieuhanh) {
		this.hedieuhanh = hedieuhanh;
	}

	public String getHangsanxuat() {
		return hangsanxuat;
	}

	public void setHangsanxuat(String hangsanxuat) {
		this.hangsanxuat = hangsanxuat;
	}
	

	public float getDongia() {
		return dongia;
	}

	public void setDongia(float dongia) {
		this.dongia = dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

//	public List<OrderDetail> getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(List<OrderDetail> orderDetails) {
//		this.orderDetails = orderDetails;
//	}

	public Computer(int iD, String ten, String cpu, String ram, String ocung, String manhinh, String hedieuhanh,
			String hangsanxuat, float dongia, int soluong, String anh) {
		super();
		ID = iD;
		this.ten = ten;
		this.cpu = cpu;
		this.ram = ram;
		this.ocung = ocung;
		this.manhinh = manhinh;
		this.hedieuhanh = hedieuhanh;
		this.hangsanxuat = hangsanxuat;
		this.dongia = dongia;
		this.soluong = soluong;
		this.anh = anh;
	}

	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Computer(String ten, String cpu, String ram, String ocung, String manhinh, String hedieuhanh,
			String hangsanxuat, float dongia, int soluong, String anh) {
		super();
		this.ten = ten;
		this.cpu = cpu;
		this.ram = ram;
		this.ocung = ocung;
		this.manhinh = manhinh;
		this.hedieuhanh = hedieuhanh;
		this.hangsanxuat = hangsanxuat;
		this.dongia = dongia;
		this.soluong = soluong;
		this.anh = anh;
	}

	
	
}
