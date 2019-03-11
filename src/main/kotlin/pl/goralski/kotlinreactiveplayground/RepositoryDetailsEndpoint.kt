package pl.goralski.kotlinreactiveplayground

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.math.BigInteger


@RestController
@RequestMapping("meet")
class RepositoryDetailsEndpoint(
        private val meetClient: MeetClient,
        private val entityRepository: ReactiveEntityMeetRepository) {

    @GetMapping(value = ["/start_fetching"])
    fun getStart(): Flux<MeetRepository> {
        return meetClient.getData().flatMap { it -> entityRepository.save(it) }.log()
    }

    @GetMapping(value = ["/{date}"])
    fun getStartSince(
            @PathVariable("date") date: String): Flux<MeetRepository> {
        println(date)
        val dateInt = date.toBigInteger()
        val threshold: BigInteger = dateInt + 86400000.toBigInteger()
        return meetClient.getDataSince(date).takeWhile { it.mTime.toBigInteger().compareTo(threshold) < 1}.log()
                .flatMap { it -> entityRepository.save(it) }

    }
}
