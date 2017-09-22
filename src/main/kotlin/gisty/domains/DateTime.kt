package gisty.domains

import java.time.LocalDateTime

data class DateTime(val value: LocalDateTime) {
    companion object {
        fun current(): DateTime {
            return DateTime(LocalDateTime.now())
        }
    }
}