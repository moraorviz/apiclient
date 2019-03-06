package pl.goralski.kotlinreactiveplayground

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class MeetRepository(@Id @JsonProperty("rsvp_id") val rsvpId: String = "", val group: Group = Group("", "", ""))