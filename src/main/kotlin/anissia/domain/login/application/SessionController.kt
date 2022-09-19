package anissia.domain.login.application

import anissia.domain.temp.core.model.LoginRequest
import anissia.domain.temp.core.model.LoginTokenRequest
import anissia.domain.temp.core.model.Session
import anissia.domain.temp.core.model.SessionService
import anissia.shared.ResultData
import anissia.shared.ResultStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/session")
class SessionController(
    private val sessionService: SessionService
) {
    @PostMapping
    fun login(@Valid @RequestBody loginRequest: LoginRequest): ResultData<Session> =
        sessionService.doLogin(loginRequest)

    @PostMapping("/token")
    fun tokenLogin(@Valid @RequestBody loginTokenRequest: LoginTokenRequest): ResultData<Session> =
        sessionService.doTokenLogin(loginTokenRequest)

    @DeleteMapping
    fun logout(): ResultStatus = sessionService.doLogout()

    @GetMapping
    fun session(): Session = sessionService.session ?: Session()
}
