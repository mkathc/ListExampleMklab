package com.example.makerlab.ui.mapper

interface CoachMapper<V, D> {

    fun mapToView(type: D): V

    fun mapToUseCase(type: V): D

}