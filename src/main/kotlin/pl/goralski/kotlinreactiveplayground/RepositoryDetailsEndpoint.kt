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

    @GetMapping(value = ["/{startfetching}"])
    fun getRepositoriesByOwner(): Flux<MeetRepository> {
        return meetClient.getRepository().flatMap { it -> entityRepository.save(it) }.log()
    }


    companion object {
        const val OWNER: String = "owner"
        const val REPOSITORY_NAME: String = "repositoryName"
    }
}
