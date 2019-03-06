package pl.goralski.kotlinreactiveplayground

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ReactiveEntityMeetRepository : ReactiveCrudRepository<MeetRepository, Int>