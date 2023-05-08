package com.app.phoneservice.controllers;

import com.app.phoneservice.data.MobileData;
import com.app.phoneservice.managers.IMobileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class MobileController {
    @Autowired
    IMobileManager mobileManager;

    /**
     * Lists information about all phones
     * @return List of mobiles data
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MobileData> list() {
        return mobileManager.list();
    }

    /**
     * Lists information about phones with the specified name (@phone)
     * @param phone - String - name of the phone
     * @return List of mobiles data
     */
    @RequestMapping(value = "/listPhone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MobileData> listPhone(@RequestParam(name="phone") String phone) {
        return mobileManager.list(phone);
    }

    /**
     * Books phone using @phone and @owner
     * @param phone - String - name of the phone
     * @param owner - String - owner name who wants to book the phone
     * @return OK/BAD_REQUEST
     */
    @RequestMapping(value = "/book", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> book(@RequestParam(name="phone") String phone, @RequestParam(name="owner") String owner) {
        try {
            mobileManager.book(phone, owner);
            return ResponseEntity.status(HttpStatus.OK).body(phone + " booked by owner '" + owner + "'");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Returns phone using @phone and @owner
     * @param phone - String - name of the phone
     * @param owner - String - owner who wants to return the phone
     * @return OK/BAD_REQUEST
     */
    @RequestMapping(value = "/release", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> release(@RequestParam(name="phone") String phone, @RequestParam(name="owner") String owner) {
        try {
            mobileManager.release(phone, owner);
            return ResponseEntity.status(HttpStatus.OK).body(phone + " returned by owner '" + owner + "'");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
