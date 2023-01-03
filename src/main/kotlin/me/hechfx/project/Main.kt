package me.hechfx.project

import com.mongodb.MongoClient
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import me.hechfx.project.psql.PostgreSQL
import me.hechfx.project.psql.dao.User
import org.bson.Document
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Instant

suspend fun main() {
    val json = Json {
        ignoreUnknownKeys = true
    }

    val mongoClient = MongoClient("localhost:27017")

    mongoClient.startSession()
    PostgreSQL.start()

    val database = mongoClient.getDatabase("senichi")
    val users = database.getCollection("users").find()

    users.forEach { user ->
        println("inserting ${user.getString("_id")} into psql table")
        newSuspendedTransaction {
            val now = Instant.now()
            User.new(user.getString("_id").toLong()) {
                bio = (user["social"] as Document).getString("bio")
                likes = (user["social"] as Document).getInteger("likes")
                color = (user["social"] as Document).getString("colorProfile")
                coins = (user["economy"] as Document).getInteger("coins").toLong()
                dailyTimeout = now
                premium = user.getBoolean("premium")
                premiumType = user.getInteger("premiumType")
                premiumDuration = now
                banned = (user["banned"] as Document).getBoolean("state")
                banReason = (user["banned"] as Document).getString("reason")
            }
        }
    }
}
