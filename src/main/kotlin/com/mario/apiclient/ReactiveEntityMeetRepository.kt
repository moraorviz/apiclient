package com.mario.apiclient

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ReactiveEntityMeetRepository : ReactiveCrudRepository<MeetRepository, Int>