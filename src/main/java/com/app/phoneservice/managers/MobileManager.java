package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MobileManager implements IMobileManager {
    @Autowired
    IMobileDataManager dataManager;
    @Override
    synchronized public List<MobileData> list(String phone) {
        return dataManager.getPhonesInfo(phone);
    }

    @Override
    synchronized public List<MobileData> list() {
        return dataManager.getPhonesInfo();
    }

    @Override
    synchronized public void book(String phone, String owner) {
        Optional<MobileData> mobile = dataManager.getAvailablePhone(phone);
        if (mobile.isPresent()) {
            dataManager.savePhoneInfo(mobile.get().book(owner));
        } else {
            throw new RuntimeException("Phone '" + phone + "' was not found");
        }
    }

    @Override
    synchronized public void release(String phone, String owner) {
        Optional<MobileData> mobile = dataManager.getBookedPhone(phone, owner);
        if (mobile.isPresent()) {
            dataManager.savePhoneInfo(mobile.get().release());
        } else {
            throw new RuntimeException("Unexpected returning of the phone '" + phone + "' for owner '" + owner + "'");
        }
    }
}
