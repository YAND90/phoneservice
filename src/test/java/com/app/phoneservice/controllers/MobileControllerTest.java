package com.app.phoneservice.controllers;

import com.app.phoneservice.data.MobileData;
import com.app.phoneservice.managers.IMobileManager;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MobileControllerTest {

	@Mock
	private IMobileManager mobileManager;

	@InjectMocks
	private MobileController mobileController;

	@Test
	public void testList() {
		MobileData data1 = new MobileData();
		data1.setId(1);
		data1.setName("iPhone");
		MobileData data2 = new MobileData();
		data2.setId(2);
		data2.setName("Samsung");

		List<MobileData> mockMobileDataList = Arrays.asList(
				data1,
				data2
		);

		Mockito.when(mobileManager.list()).thenReturn(mockMobileDataList);

		List<MobileData> result = mobileController.list();

		assertEquals(mockMobileDataList.size(), result.size());
		assertEquals(data1.getName(), result.get(0).getName());
		assertEquals(data1.getId(), result.get(0).getId());
		assertEquals(data2.getName(), result.get(1).getName());
		assertEquals(data2.getId(), result.get(1).getId());
	}

	@Test
	public void testListPhone() {
		MobileData data1 = new MobileData();
		data1.setId(1);
		data1.setName("iPhone");

		List<MobileData> mockMobileDataList = List.of(
				data1
		);

		Mockito.when(mobileManager.list("iPhone")).thenReturn(mockMobileDataList);

		List<MobileData> result = mobileController.listPhone("iPhone");

		assertEquals(mockMobileDataList.size(), result.size());
		assertEquals(data1.getName(), result.get(0).getName());
		assertEquals(data1.getId(), result.get(0).getId());
	}

	@Test
	public void testBook() {
		String phone = "iPhone";
		String owner = "John";

		Mockito.doNothing().when(mobileManager).book(phone, owner);

		ResponseEntity<String> response = mobileController.book(phone, owner);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("iPhone booked by owner 'John'", response.getBody());
	}

	@Test
	public void testBook_InvalidInput() {
		String phone = "iPhone";
		String owner = "John";

		Mockito.doThrow(new RuntimeException("Phone already booked")).when(mobileManager).book(phone, owner);

		ResponseEntity<String> response = mobileController.book(phone, owner);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Phone already booked", response.getBody());
	}

	@Test
	public void testRelease() {
		String phone = "iPhone";
		String owner = "John";

		Mockito.doNothing().when(mobileManager).release(phone, owner);

		ResponseEntity<String> response = mobileController.release(phone, owner);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("iPhone returned by owner 'John'", response.getBody());
	}

	@Test
	public void testRelease_InvalidInput() {
		String phone = "iPhone";
		String owner = "John";

		Mockito.doThrow(new RuntimeException("Invalid owner")).when(mobileManager).release(phone, owner);

		ResponseEntity<String> response = mobileController.release(phone, owner);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid owner", response.getBody());
	}
}

