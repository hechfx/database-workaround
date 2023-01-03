package me.hechfx.project.mongo

import com.mongodb.MongoClient
import com.mongodb.client.ClientSession

class Mongo {
    private lateinit var mongoClient: MongoClient

    fun start(): ClientSession {
        mongoClient = MongoClient("localhost:27017")

        return mongoClient.startSession()
    }
}