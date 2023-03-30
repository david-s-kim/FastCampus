package com.example.fastcampus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.*
import androidx.room.Database
import androidx.room.OnConflictStrategy.REPLACE

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).allowMainThreadQueries()

    }
}


@Database(entities = [UserProfile::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userProfileDao(): UserProfileDao
}


@Dao
interface UserProfileDao {
    // CRUD -> 데이터베이스 조작
    // Query -> 데이터베이스 조회
    @Insert(onConflict = REPLACE)
    fun insert(userProfile: UserProfile)

    @Delete
    fun delete(userProfile: UserProfile)

    @Query("SELECT * FROM userprofile")
    fun getAll() : List<UserProfile>
}


@Entity
class UserProfile(

    @PrimaryKey val id: Int,

    @ColumnInfo(name="last_name")
    val lastName: String,

    @ColumnInfo(name="fisrt_name")
    val firstName: String

)


