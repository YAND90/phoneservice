package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;
import com.app.phoneservice.data.MobileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MobileDataManager implements IMobileDataManager {
    @Autowired
    MobileDataRepository repository;
    @Override
    public Optional<MobileData> getAvailablePhone(String phone) {
        return repository.findFirst1ByNameAndIsAvailable(phone, true);
    }

    @Override
    public Optional<MobileData> getBookedPhone(String phone, String owner) {
        return repository.findFirst1ByNameAndOwnerAndIsAvailable(phone, owner, false);
    }

    @Override
    public List<MobileData> getPhonesInfo(String phone) {
        return repository.findByName(phone);
    }

    @Override
    public List<MobileData> getPhonesInfo() {
        return repository.findAll();
    }

    @Override
    public void savePhoneInfo(MobileData data) {
        repository.save(data);
    }
}
