package pl.goralski.kotlinreactiveplayground

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class Group(@Id @JsonProperty("group_id") val groupId: String = "", @JsonProperty("group_lon") val groupLon: String = "",
                 @JsonProperty("group_lat") val groupLat: String = "")
