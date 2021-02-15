package remoto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

class DogEntity {
    @Entity(tableName = "dog_table")
    data class DogEntity (
        @PrimaryKey
        @NotNull
        @SerializedName("id")
        val id : String,
        @SerializedName("breed")
        val breed : String
    )
}