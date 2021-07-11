package com.mu.jan.relax.data.database

import android.content.Context
import com.amazonaws.auth.CognitoCachingCredentialsProvider
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.mu.jan.relax.data.model.User
import com.mu.jan.relax.utils.Const
import com.mu.jan.relax.utils.runOnBack
import kotlinx.coroutines.*

class DynamoDb(private val mContext: Context) {
    //credentials
    private var credentials = CognitoCachingCredentialsProvider(
        mContext,Const.identityPoolId,Const.dynamoDbRegion)
    //client
    private var client = AmazonDynamoDBClient(credentials)
    //mapper
    private var mapper = DynamoDBMapper(client)

    init {
        //this is important
        client.setRegion(Region.getRegion(Regions.US_EAST_2))
    }
    //User
    fun addOrUpdateUser(user: User): Boolean{
        return try {
            runOnBack {
             mapper.save(user)
            }
            true
        }catch (e: Exception) {
            false
        }
    }
    suspend fun isUserExists(id: String): Boolean{
        return getUserById(id)!=null
    }
    suspend fun getUserById(id: String) : User?{
        return withContext(CoroutineScope(Dispatchers.IO).coroutineContext){
            mapper.load(User::class.java,id)
        }
    }

}