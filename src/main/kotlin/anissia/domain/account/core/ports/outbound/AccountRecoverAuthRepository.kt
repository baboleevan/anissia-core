package anissia.domain.account.core.ports.outbound

import anissia.domain.account.core.AccountRecoverAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import java.time.LocalDateTime

interface AccountRecoverAuthRepository : JpaRepository<AccountRecoverAuth, Long>,
    QuerydslPredicateExecutor<AccountRecoverAuth> {

    fun existsByAnAndExpDtAfter(an: Long, expDt: LocalDateTime): Boolean

    fun findByNoAndTokenAndExpDtAfterAndUsedDtNull(no: Long, token: String, expDt: LocalDateTime): AccountRecoverAuth?
}
