package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MobileManagerTest {

    @Mock
    private IMobileDataManager dataManager;

    @InjectMocks
    private MobileManager mobileManager;

    @Test
    public void testList() {
        MobileData data1 = new MobileData();
        data1.setId(1);
        data1.setName("iPhone X");
        MobileData data2 = new MobileData();
        data2.setId(2);
        data2.setName("Samsung Galaxy S10");

        List<MobileData> expectedMobileDataList = Arrays.asList(data1, data2);
        Mockito.when(dataManager.getPhonesInfo()).thenReturn(expectedMobileDataList);


        List<MobileData> actualMobileDataList = mobileManager.list();

        assertEquals(expectedMobileDataList, actualMobileDataList);
        Mockito.verify(dataManager).getPhonesInfo();
    }

    @Test
    public void testBook() {
        MobileData data1 = new MobileData();
        data1.setId(1);
        data1.setName("iPhone X");

        Mockito.when(dataManager.getAvailablePhone("iPhone X")).thenReturn(Optional.of(data1));

        mobileManager.book("iPhone X", "John Doe");

        Mockito.verify(dataManager).getAvailablePhone("iPhone X");
    }

    @Test
    public void testRelease() {
        MobileData data1 = new MobileData();
        data1.setId(1);
        data1.setName("iPhone X");

        Mockito.when(dataManager.getBookedPhone("iPhone X", "John Doe")).thenReturn(Optional.of(data1));

        mobileManager.release("iPhone X", "John Doe");

        // Assert
        Mockito.verify(dataManager).getBookedPhone("iPhone X", "John Doe");
    }
}
