package pl.goralski.kotlinreactiveplayground

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.core.publisher.Flux

class MeetClient(private val webClient: WebClient) {

    fun getRepository(): Flux<MeetRepository> {
        return webClient.get()
                .uri("http://stream.meetup.com/2/rsvps")
                .accept(APPLICATION_JSON).retrieve().bodyToFlux()
    }

    // TODO modify to get a date as an input, following the standard ISO Date format
    // TODO Update the url to point to the meet up stream API with the get parameters
    fun getRepositories(owner: String): Flux<MeetRepository> {
        return webClient.get()
                .uri("https://api.github.com/users/$owner/repos")
                .accept(APPLICATION_JSON).retrieve().bodyToFlux()
    }

}
