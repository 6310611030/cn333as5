package com.example.mynotes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "mobile") val mobile: String,
    @ColumnInfo(name = "home") val home: String,
    @ColumnInfo(name = "work") val work: String,
    @ColumnInfo(name = "etc") val etc: String,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {
    companion object {
        val DEFAULT_NOTES = listOf(
            NoteDbModel(1, "Mariam", "0671869450", "", "", "", 1, false),
            NoteDbModel(2, "Nathaniel", "0840415383", "", "", "", 2, false),
            NoteDbModel(3, "Walther", "0622331595", "", "", "", 3, false),
            NoteDbModel(4, "Rhode", "0929706105", "", "", "", 4, false),
            NoteDbModel(5, "Célia", "0824552690", "", "", "", 5, false),
            NoteDbModel(6, "Farahild", "0994570098", "", "", "", 6, false),
            NoteDbModel(7, "Ruslan", "0925306172", "", "", "", 7, false),
            NoteDbModel(8, "Gideon", "0623919193", "", "", "", 8, false),
            NoteDbModel(9, "Roald", "0625352822", "", "", "", 9, false),
            NoteDbModel(10, "Leon", "0622235351", "", "", "", 10, false),
            NoteDbModel(11, "Carlinhos", "0624682260", "", "", "", 11, false),
            NoteDbModel(12, "Yavuz", "0622586750", "", "", "", 12, false)
        )
    }
}
