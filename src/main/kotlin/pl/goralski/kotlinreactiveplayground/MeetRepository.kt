package pl.goralski.kotlinreactiveplayground

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// TODO change to something like @Document(collection = "${mongo.event.collection}")
// Source  https://stackoverflow.com/questions/29597482/spring-data-mongodb-repository-with-custom-collection-name/29607236
// TODO dive into the possible solution of using mongod b method to change the collection name in the runtime
// https://stackoverflow.com/questions/18129291/mongodb-and-spel-expressions-in-document-annotations
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
data class MeetRepository(@JsonProperty("rsvp_id") val rsvpId: String = "",
                            @JsonProperty("guests") val guests: String = "",
                            @JsonProperty("mtime") val mTime: String = "",
                            val group: Group = Group("", "", ""))
