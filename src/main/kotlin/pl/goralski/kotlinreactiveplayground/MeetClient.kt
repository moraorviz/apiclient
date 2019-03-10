package pl.goralski.kotlinreactiveplayground

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux
import java.math.BigInteger
import java.time.Duration
import java.util.function.Predicate

class MeetClient(private val webClient: WebClient) {

    fun getData(): Flux<MeetRepository> {
        return webClient.get()
                .uri("http://stream.meetup.com/2/rsvps")
                .accept(APPLICATION_JSON).retrieve().bodyToFlux()
    }


    // TODO modify to get a date as an input, following the standard ISO Date format
    // TODO Update the url to point to the meet up stream API with the get parameters
    fun getDataSince(date: String): Flux<MeetRepository> {
        return webClient.get()
                .uri("http://stream.meetup.com/2/rsvps?since_mtime=$date")
                .accept(APPLICATION_JSON).retrieve().bodyToFlux()
    }


    fun filter(date: String): Flux<MeetRepository> {
        val dateInt = date.toBigInteger()
        val threshold: BigInteger = dateInt + 86400000.toBigInteger()
        return getDataSince(date).takeWhile(Predicate { it.mTime.toBigInteger().compareTo(threshold) < 1})
    }

}
