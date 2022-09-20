package anissia.domain.agenda.infrastructure

import anissia.domain.agenda.core.AgendaPoll
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface AgendaPollRepository : JpaRepository<AgendaPoll, Long>, QuerydslPredicateExecutor<AgendaPoll> {


}
