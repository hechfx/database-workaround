package me.hechfx.project.psql.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.timestamp

object Users: LongIdTable() {
    var bio = text("bio")
    var likes = integer("likes")
    var color = text("color")
    var coins = long("coins")
    var dailyTimeout = timestamp("daily-timeout").nullable()
    var premium = bool("premium")
    var premiumType = integer("premium-type").nullable()
    var premiumDuration = timestamp("premium-duration").nullable()
    var banned = bool("banned")
    var banReason = text("ban-reason").nullable()
}