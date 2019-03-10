package pl.goralski.kotlinreactiveplayground

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// TODO Review the data types. At this moment every single field is a string. Use mongodb types
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class Group(@JsonProperty("group_id") val groupId: String = "",
                   @JsonProperty("group_city") val groupCity: String = "",
                   @JsonProperty("group_lon") val groupLon: String = "",
                   @JsonProperty("group_lat") val groupLat: String = "")
