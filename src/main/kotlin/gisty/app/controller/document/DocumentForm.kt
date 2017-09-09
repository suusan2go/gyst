package gisty.app.controller.document

import org.hibernate.validator.constraints.NotBlank

import java.io.Serializable;
import java.time.LocalTime;


class DocumentForm: Serializable {
    @get:NotBlank(message = "必須です")
    var title: String = ""
    @get:NotBlank(message = "必須です")
    var body: String = ""
}


