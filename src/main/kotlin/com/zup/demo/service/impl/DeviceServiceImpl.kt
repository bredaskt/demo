package com.zup.demo.service.impl

import com.zup.demo.exception.DeviceAlreadyExistsException
import com.zup.demo.exception.DeviceNotFoundException
import com.zup.demo.model.Device
import com.zup.demo.repository.DeviceRepository
import com.zup.demo.service.DeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeviceServiceImpl : DeviceService {

    @Autowired
    lateinit var deviceRepository: DeviceRepository

    override fun saveDevice(device: Device): Device {
        if (deviceRepository.findByName(device.name) != null) throw DeviceAlreadyExistsException(
            DEVICE_ALREADY_EXISTS
        )
        return deviceRepository.save(device)
    }

    override fun getDevice(deviceId: Long): Device {
        return deviceRepository.findByDeviceId(deviceId) ?: throw DeviceNotFoundException(DEVICE_NOT_FOUND)
    }

    override fun removeDevice(deviceId: Long) {
        deviceRepository.findByDeviceId(deviceId) ?: throw DeviceNotFoundException(DEVICE_NOT_FOUND)
        deviceRepository.deleteById(deviceId)
    }

    override fun updateDevice(device: Device): Device {
        val foundDevice = deviceRepository.findByName(device.name) ?: throw DeviceNotFoundException(
            DEVICE_NOT_FOUND
        )

        return deviceRepository.save(device.copy(foundDevice.deviceId))

    }

    companion object {
        const val DEVICE_NOT_FOUND = "Device not found!"
        const val DEVICE_ALREADY_EXISTS = "Device already registered"
    }

}