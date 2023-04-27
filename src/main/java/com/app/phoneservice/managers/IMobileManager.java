package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;

import java.util.List;

public interface IMobileManager {
    List<MobileData> list(String phone);
    List<MobileData> list();
    void book(String phone, String owner);
    void release(String phone, String owner);
}
