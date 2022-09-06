package anissia.domain.login.infrastructure

import anissia.domain.login.core.LoginToken
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface LoginTokenRepository : JpaRepository<LoginToken, Long> {
    fun findByTokenNoAndTokenAndExpDtAfter(tokenNo: Long, token: String, expDt: LocalDateTime): LoginToken?
}
