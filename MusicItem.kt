package com.mu.jan.relax.data.model

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBDocument

@DynamoDBDocument
data class MusicItem(
    @DynamoDBAttribute(attributeName = "title")
    var title: String? = null,
    @DynamoDBAttribute(attributeName = "des")
    var des: String? = null,
    @DynamoDBAttribute(attributeName = "url")
    var url: String? = null,
    @DynamoDBAttribute(attributeName = "thumbnailUrl")
    var thumbnailUrl: String? = null,
    @DynamoDBAttribute(attributeName = "isFav")
    var isFav: Boolean? = null,
    @DynamoDBAttribute(attributeName = "isVideo")
    var isVideo: Boolean = false,
    @DynamoDBAttribute(attributeName = "time")
    var time: Int = 0,
    @DynamoDBAttribute(attributeName = "color")
    var color: Int = 0
)
