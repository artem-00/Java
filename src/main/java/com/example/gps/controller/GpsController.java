package com.example.gps.controller;

import com.example.gps.model.Location;
import com.example.gps.data.GpsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GpsController {

    private final GpsData gpsData;

    @Autowired
    public GpsController(GpsData gpsData) {
        this.gpsData = gpsData;
    }

    @GetMapping("/location/{ip}")
    public Location getLocation(@PathVariable String ip) {
        return gpsData.getLocationByIp(ip);
    }
}
