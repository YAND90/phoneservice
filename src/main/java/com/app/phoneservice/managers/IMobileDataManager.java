package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;

import java.util.List;
import java.util.Optional;

public interface IMobileDataManager {
    Optional<MobileData> getAvailablePhone(String phone);
    Optional<MobileData> getBookedPhone(String phone, String owner);
    List<MobileData> getPhonesInfo(String phone);
    List<MobileData> getPhonesInfo();
    void savePhoneInfo(MobileData data);
}