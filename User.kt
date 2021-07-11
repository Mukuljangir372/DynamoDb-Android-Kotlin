package com.mu.jan.relax.data.model

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable

@DynamoDBTable(tableName = "User")
data class User(
    @DynamoDBHashKey(attributeName = "id")
    var id: String? = null,
    @DynamoDBAttribute(attributeName = "name")
    var name: String? = null,
    @DynamoDBAttribute(attributeName = "email")
    var email: String? = null,
    @DynamoDBAttribute(attributeName = "isSignedIn")
    var isSignedIn: Boolean = false,
    @DynamoDBAttribute(attributeName = "favList")
    var favList: List<MusicItem> = listOf(),
    @DynamoDBAttribute(attributeName = "recentList")
    var recentList: List<MusicItem> = listOf()
)