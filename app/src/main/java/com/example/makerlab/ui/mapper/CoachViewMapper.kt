package com.example.makerlab.ui.mapper

import com.example.makerlab.room.entity.CoachEntity
import com.example.makerlab.ui.model.Coach


class CoachViewMapper : CoachMapper<Coach, CoachEntity> {

    override fun mapToView(type: CoachEntity): Coach {
        return Coach(
            type.name + type.apellido,
            type.name,
            type.apellido,
            type.description
        )
    }

    override fun mapToUseCase(type: Coach): CoachEntity {
        return CoachEntity(
            0,
            type.name,
            type.apellido,
            type.description
        )
    }

}