package viewModel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import remoto.DogEntity
import remoto.ImageDogEntity


@Database(entities = [DogEntity::class, ImageDogEntity::class], version = 1)
    abstract class DogDataBase: RoomDatabase() {

        abstract fun getDogDao(): DogDao

        companion object {
            @Volatile
            private var Instance: DogDataBase? = null

            fun getDataBase (context: Context): DogDataBase {
                val tempInstance = Instance
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        DogDataBase::class.java, "dog_db"
                    ).build()
                    Instance = instance
                    return instance
                }
            }
        }
    }
