package anissia.domain.login.infrastructure

import anissia.domain.login.core.LoginPass
import org.springframework.data.jpa.repository.JpaRepository

interface LoginPassRepository : JpaRepository<LoginPass, Long>
