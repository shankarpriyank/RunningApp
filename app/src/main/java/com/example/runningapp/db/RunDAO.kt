package com.example.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO  {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
     suspend fun InsertRun(run: Run)

     @Delete
     suspend fun deleteRun(run: Run)

     @Query("SELECT * FROM running_table ORDER BY timestamp DESC   ")
      fun getAllRunsSortedByDate():LiveData<List<Run>>


    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC   ")
    fun getAllRunsSortedByTimeInMillis():LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC   ")
    fun getAllRunsSortedByCaloriesBurned():LiveData<List<Run>>


    @Query("SELECT * FROM running_table ORDER BY avgspeedInKMH DESC   ")
    fun getAllRunsSortedByAvgSpeed():LiveData<List<Run>>


    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC   ")
    fun getAllRunsSortedByDistance():LiveData<List<Run>>


    @Query("SELECT SUM(timeInMillis) FROM running_table")
    fun getTotalTimeInMillis():LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM running_table")
    fun getTotalCaloriesBurned():LiveData<Int>


    @Query("SELECT SUM(distanceInMeters) FROM running_table")
    fun getTotalDistance():LiveData<Int>



    @Query("SELECT Avg(avgspeedInKMH) FROM running_table")
    fun getTotalAvgSpeed():LiveData<Float>












}