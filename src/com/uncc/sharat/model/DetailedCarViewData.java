package com.uncc.sharat.model;

public class DetailedCarViewData {
	public static String VIN;
	public static String Make;
	public static String Model;
	public static String Year;
	public static String Status;
	public static String Mileage;
	public static String Price;
	public static String SalesmanId;
	public static String Color;
	public static String CarType;
	public static String Description;
	public static void setData(String [][] carData) {
		VIN = carData[1][0];
		Make = carData[1][1];
		Model = carData[1][2];
		Year = carData[1][3];
		Status = carData[1][4];
		Mileage = carData[1][5];
		Price = carData[1][6];
		SalesmanId = carData[1][7];
		Color = carData[1][8];
		CarType = carData[1][9];
		Description = carData[1][10];
	}
}
