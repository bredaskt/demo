package com.zup.demo.model

import org.springframework.data.annotation.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue

@Entity
data class Device(
    @Id @GeneratedValue @javax.persistence.Id val deviceId: Long?,
    @Column(unique = true) val name: String,
    val storage: Int
)