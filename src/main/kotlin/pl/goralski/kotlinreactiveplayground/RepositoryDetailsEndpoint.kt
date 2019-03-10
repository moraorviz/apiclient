package pl.goralski.kotlinreactiveplayground

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
@RequestMapping("meet")
class RepositoryDetailsEndpoint(
        private val meetClient: MeetClient,
        private val entityRepository: ReactiveEntityMeetRepository) {

    @GetMapping(value = ["/{start_fetching}"])
    fun getRepositoriesByOwner(): Flux<MeetRepository> {
        return meetClient.getRepository().flatMap { it -> entityRepository.save(it) }.log()
    }

    // TODO implement API endpoint for python-flask to trigger.
    // TODO implement takeWhile reactor method for discarding undesired data (ouside day-date boundaries)
}
