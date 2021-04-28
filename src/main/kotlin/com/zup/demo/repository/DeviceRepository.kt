package com.zup.demo.repository

import com.zup.demo.model.Device
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DeviceRepository : CrudRepository<Device, Long>{

    fun findByDeviceId(id: Long): Device?
    fun findByName(name: String): Device?

}