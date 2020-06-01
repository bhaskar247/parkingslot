package com.successfactors.aft.parkingslot.controller;

import com.successfactors.aft.parkingslot.model.ParkingSlot;
import com.successfactors.aft.parkingslot.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ParkingSlotController {

    @Autowired
    private ParkingSlotService parkingSlotService;

    @RequestMapping("/slots")
    public List<ParkingSlot> getAllParkingSlots() {
        return parkingSlotService.getAllParkingSlots();
    }

    @RequestMapping(value = "/add-slot", method = RequestMethod.POST)
    public void addParkingSlot(@RequestBody ParkingSlot parkingSlot) {
        parkingSlotService.addParkingSlot(parkingSlot);
    }

    @RequestMapping(value = "/update-slot", method = RequestMethod.POST)
    @Transactional
    public void updateParkingSlot(@RequestBody ParkingSlot parkingSlot) {
        parkingSlotService.updateParkingSlot(parkingSlot.getState(), parkingSlot.getId());
    }
}
