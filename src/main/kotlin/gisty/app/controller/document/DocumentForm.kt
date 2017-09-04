package gisty.app.controller.document

import org.hibernate.validator.constraints.NotBlank

import java.io.Serializable;
import java.time.LocalTime;


class DocumentForm: Serializable{
    @NotBlank(message = "必須です")
    private var startTime: LocalTime? = null

    @NotBlank(message = "必須です")
    private var endTime: LocalTime? = null

    fun getEndTime(): LocalTime? {
        return endTime
    }

    fun getStartTime(): LocalTime? {
        return startTime
    }

    fun setEndTime(endTime: LocalTime) {
        this.endTime = endTime
    }

    fun setStartTime(startTime: LocalTime) {
        this.startTime = startTime
    }


}