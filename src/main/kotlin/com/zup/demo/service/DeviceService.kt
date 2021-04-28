package com.zup.demo.service

import com.zup.demo.model.Device

interface DeviceService {

    fun saveDevice(device: Device) : Device
    fun getDevice(deviceId: Long) : Device
    fun removeDevice(deviceId: Long)
    fun updateDevice(device: Device) : Device

}