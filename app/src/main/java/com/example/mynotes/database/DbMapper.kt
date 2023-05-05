package com.example.mynotes.database

import com.example.mynotes.domain.model.ColorModel
import com.example.mynotes.domain.model.NEW_NOTE_ID
import com.example.mynotes.domain.model.NoteModel

class DbMapper {
    // Create list of NoteModels by pairing each note with a color
    fun mapNotes(
        noteDbModels: List<NoteDbModel>,
        colorDbModels: Map<Long, ColorDbModel>
    ): List<NoteModel> = noteDbModels.map {
        val colorDbModel = colorDbModels[it.colorId]
            ?: throw RuntimeException("Color for colorId: ${it.colorId} was not found. Make sure that all colors are passed to this method")

        mapNote(it, colorDbModel)
    }

    // convert NoteDbModel to NoteModel
    fun mapNote(noteDbModel: NoteDbModel, colorDbModel: ColorDbModel): NoteModel {
        val color = mapColor(colorDbModel)
        /*val isCheckedOff = with(noteDbModel) { if (canBeCheckedOff) isCheckedOff else null }*/
        return with(noteDbModel) { NoteModel(id, title, mobile, home, work, etc, isInTrash, color) }
    }

    // convert list of ColorDdModels to list of ColorModels
    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel> =
        colorDbModels.map { mapColor(it) }

    // convert ColorDbModel to ColorModel
    fun mapColor(colorDbModel: ColorDbModel): ColorModel =
        with(colorDbModel) { ColorModel(id, name, hex) }

    // convert NoteModel back to NoteDbModel
    fun mapDbNote(note: NoteModel): NoteDbModel =
        with(note) {
            if (id == NEW_NOTE_ID)
                NoteDbModel(
                    title = title,
                    mobile = mobile,
                    home = home,
                    work = work,
                    etc = etc,
                    colorId = color.id,
                    isInTrash = false
                )
            else
                NoteDbModel(id, title, mobile, home, work, etc, color.id, false)
        }
}