package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl business;

	@Mock
	SomeDataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingDataService());
	}

	@Test
	public void countNamesHavingLengthGreater3_NormalCase() {
		when(dataServiceMock.getRandomNames()).thenReturn(new String[] { "manish", "wo", "ersd" });
		assertEquals(2, business.getCountOfNamesLengthGreatearThan3());
	}

	@Test
	public void countNamesHavingLengthGreater3_Empty() {
		when(dataServiceMock.getRandomNames()).thenReturn(new String[] {});
		assertEquals(0, business.getCountOfNamesLengthGreatearThan3());
	}

	@Test
	public void countNamesHavingLengthGreater3_Single() {
		when(dataServiceMock.getRandomNames()).thenReturn(new String[] { "manish" });
		assertEquals(1, business.getCountOfNamesLengthGreatearThan3());
	}
}
