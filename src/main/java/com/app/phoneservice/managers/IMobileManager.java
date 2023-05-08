package com.app.phoneservice.managers;

import com.app.phoneservice.data.MobileData;

import java.util.List;

public interface IMobileManager {
    /**
     * Lists of the phones by @phone
     * @param phone - String - phone name
     * @return - list of mobile data
     */
    List<MobileData> list(String phone);

    /**
     * Lists of all phones
     * @return - list of mobile data
     */
    List<MobileData> list();

    /**
     * Books the @phone by @owner
     * @param phone - String - phone name
     * @param owner - String - owner name
     */
    void book(String phone, String owner);

    /**
     * Releases the @phone @ by @owner
     * @param phone - String - phone name
     * @param owner - String - owner name
     */
    void release(String phone, String owner);
}
