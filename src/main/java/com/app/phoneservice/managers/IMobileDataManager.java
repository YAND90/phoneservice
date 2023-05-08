package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;

import java.util.List;
import java.util.Optional;

public interface IMobileDataManager {
    /**
     * Gets first available phone from the storage by @phone
     * @param phone - String - phone name
     * @return - MobileData - if exists, then returns MobileData of available phone
     */
    Optional<MobileData> getAvailablePhone(String phone);

    /**
     * Gets first booked phone from the storage by @phone and @owner
     * @param phone - String - phone name
     * @param owner - String - owner name
     * @return - MobileData - if exists, then return MobileData of booked phone
     */
    Optional<MobileData> getBookedPhone(String phone, String owner);

    /**
     * Gets list of phones by @phone
     * @param phone - String - phone name
     * @return - List of mobile data
     */
    List<MobileData> getPhonesInfo(String phone);

    /**
     * Get list of all phones
     * @return List of mobile data
     */
    List<MobileData> getPhonesInfo();

    /**
     * Saves the updated information about the phone by @data
     * @param data - MobileData - new information about the phone
     */
    void savePhoneInfo(MobileData data);
}