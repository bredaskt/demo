package com.zup.demo.service.imp

import com.zup.demo.exception.DeviceNotFoundException
import com.zup.demo.repository.DeviceRepository
import com.zup.demo.service.impl.DeviceServiceImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DeviceServiceImplTest {

    @Mock
    private lateinit var deviceRepository : DeviceRepository

    @InjectMocks
    private lateinit var deviceService: DeviceServiceImpl

    @Test()
    fun `get device not found should throw exception test`() {
        `when`(deviceRepository?.findByDeviceId(1)).thenReturn(null)
         assertThrows<DeviceNotFoundException> {deviceService?.getDevice(1) }
    }

}