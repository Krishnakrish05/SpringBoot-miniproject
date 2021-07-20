//package com.krishna.minproject;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//
//import com.fasterxml.jackson.annotation.JsonAlias;
///*
// * Request object for get transaction
// */
//public class GetRequest {
//
//	public Date getFromDate() {
//		return fromDate;
//	}
//	public void setFromDate(String fromDate) {
//		try {
//			this.fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
//		} catch (ParseException e) {
//			throw new DateFormatException("Incorrect Date format");
//			
//		} 
//	}
//	public Date getToDate() {
//		return toDate;
//	}
//	public void setToDate(String toDate) {
//		try {
//			this.toDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
//		} catch (ParseException e) {
//			throw new DateFormatException("Incorrect Date format");
//			
//		} 
//	}
//	
//}
