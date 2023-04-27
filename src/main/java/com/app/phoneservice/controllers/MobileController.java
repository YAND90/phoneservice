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
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MobileData> list() {
        return mobileManager.list();
    }

    @RequestMapping(value = "/listPhone", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<MobileData> listPhone(@RequestParam(name="phone") String phone) {
        return mobileManager.list(phone);
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> book(@RequestParam(name="phone") String phone, @RequestParam(name="owner") String owner) {
        try {
            mobileManager.book(phone, owner);
            return ResponseEntity.status(HttpStatus.OK).body(phone + " booked by owner '" + owner + "'");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/release", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> release(@RequestParam(name="phone") String phone, @RequestParam(name="owner") String owner) {
        try {
            mobileManager.release(phone, owner);
            return ResponseEntity.status(HttpStatus.OK).body(phone + " returned by owner '" + owner + "'");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
