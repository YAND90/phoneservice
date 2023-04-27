package com.app.phoneservice.data;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MobileDataRepositoryTest {

    @Autowired
    private MobileDataRepository mobileDataRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void testFindFirst1ByNameAndIsAvailable() {
        Optional<MobileData> optionalMobileData = mobileDataRepository.findFirst1ByNameAndIsAvailable("Oneplus 9", true);
        assertTrue(optionalMobileData.isPresent());

        MobileData mobileData = optionalMobileData.get();
        assertEquals("Oneplus 9", mobileData.getName());
        assertEquals(5, mobileData.getId());
        assertTrue(mobileData.getIsAvailable());
    }

    @Test
    public void testFindFirst1ByNameAndOwnerAndIsAvailable() {
        Optional<MobileData> optionalMobileData = mobileDataRepository.findFirst1ByNameAndOwnerAndIsAvailable("iPhone X", null, true);
        assertTrue(optionalMobileData.isPresent());

        MobileData mobileData = optionalMobileData.get();
        assertEquals("iPhone X", mobileData.getName());
        assertEquals(9, mobileData.getId());
        assertTrue(mobileData.getIsAvailable());
    }

    @Test
    public void testFindByName() {
        List<MobileData> mobileDataList = mobileDataRepository.findByName("Samsung Galaxy S9");
        assertEquals(1, mobileDataList.size());

        MobileData mobileData = mobileDataList.get(0);
        assertEquals("Samsung Galaxy S9", mobileData.getName());
        assertEquals(1, mobileData.getId());
        assertTrue(mobileData.getIsAvailable());
    }

    @Test
    public void testFindAll() {
        List<MobileData> mobileDataList = mobileDataRepository.findAll();
        assertEquals(10, mobileDataList.size());
    }
}
