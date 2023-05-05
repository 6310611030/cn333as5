package com.example.mynotes.domain.model

const val NEW_NOTE_ID = -1L

data class NoteModel(
    val id: Long = NEW_NOTE_ID, // This value is used for new notes
    val title: String = "",
    val mobile: String = "",
    val home: String = "",
    val work: String = "",
    val etc: String = "",
    val isInTrash: Boolean = false,
    /*val isCheckedOff: ColorModel = null, // null represents that the note can't be checked off*/
    val color: ColorModel = ColorModel.DEFAULT
)