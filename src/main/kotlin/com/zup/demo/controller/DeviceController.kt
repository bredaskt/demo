package com.zup.demo.controller

import com.zup.demo.model.Device
import com.zup.demo.service.DeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class DeviceController {

    @Autowired
    lateinit var deviceService: DeviceService

    @GetMapping("/device/{deviceId}")
    fun getDevice(@PathVariable deviceId: Long): Device {
        return deviceService.getDevice(deviceId)
    }

    @PostMapping("/device")
    fun createDevice(@RequestBody device: Device) : Device {
        return deviceService.saveDevice(device)
    }

    @PutMapping("/device")
    fun updateService(@RequestBody device: Device) : Device {
        return deviceService.updateDevice(device)
    }

    @DeleteMapping("/device/{deviceId}")
    fun deleteService(@PathVariable deviceId: Long) {
        deviceService.removeDevice(deviceId)
    }

}