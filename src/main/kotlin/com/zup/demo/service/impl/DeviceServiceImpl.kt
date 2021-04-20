package com.zup.demo.service.impl

import com.zup.demo.exception.DeviceNotFoundException
import com.zup.demo.model.Device
import com.zup.demo.repository.DeviceRepository
import com.zup.demo.service.DeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeviceServiceImpl : DeviceService {

    @Autowired
    lateinit var deviceRepository : DeviceRepository

    override fun saveDevice(device: Device): Device {
        return deviceRepository.save(device)
    }

    override fun getDevice(deviceId: Long): Device {
        return deviceRepository.findByDeviceId(deviceId) ?: throw DeviceNotFoundException(DEVICE_NOT_FOUND)
    }

    companion object {
        const val DEVICE_NOT_FOUND = "Device not found!"
    }

}