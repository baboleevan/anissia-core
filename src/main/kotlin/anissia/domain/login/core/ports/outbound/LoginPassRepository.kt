package anissia.domain.login.core.ports.outbound

import anissia.domain.login.core.LoginPass
import org.springframework.data.jpa.repository.JpaRepository

interface LoginPassRepository : JpaRepository<LoginPass, Long>
