package anissia.domain.temp.core.model

import anissia.domain.account.core.Account
import anissia.domain.account.core.AccountRole
import com.fasterxml.jackson.annotation.JsonIgnore

data class Session (
        @JsonIgnore
        var an: Long = 0,
        var name: String = "",
        var roles: List<String> = listOf()
) {
    companion object {
        fun cast(account: Account) = Session(
                an = account.an,
                name = account.name,
                roles = account.roles.map { it.name }
        )
    }

    fun isRoot() = roles.contains(AccountRole.ROOT.name)
    fun isManager() = roles.contains(AccountRole.TRANSLATOR.name) || roles.contains(AccountRole.ROOT.name)
}
