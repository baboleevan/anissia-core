package anissia.infrastructure.configruration

import anissia.domain.temp.core.model.Session
import anissia.infrastructure.common.PrefixRoleGrantedAuthority
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

class AnissiaAuthentication(
    private var session: Session,
    private var authenticated: Boolean = true
) : Authentication {

    override fun getAuthorities(): List<GrantedAuthority> = session.roles.map { PrefixRoleGrantedAuthority(it) }
    override fun getName() = session.name
    override fun getPrincipal() = session
    override fun getDetails() = null
    override fun getCredentials() = null
    override fun isAuthenticated() = authenticated

    override fun setAuthenticated(isAuthenticated: Boolean) {
        authenticated = isAuthenticated
    }
}
