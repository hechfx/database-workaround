package me.hechfx.project.psql.dao

import me.hechfx.project.psql.table.Users
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class User(id: EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<User>(Users)

    val userId = this.id.value
    var bio by Users.bio
    var likes by Users.likes
    var color by Users.color
    var coins by Users.coins
    var dailyTimeout by Users.dailyTimeout
    var premium by Users.premium
    var premiumType by Users.premiumType
    var premiumDuration by Users.premiumDuration
    var banned by Users.banned
    var banReason by Users.banReason
}