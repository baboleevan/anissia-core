package anissia.domain.account.core.ports.outbound

import anissia.domain.account.core.AccountBanName
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface AccountBanNameRepository : JpaRepository<AccountBanName, String>, QuerydslPredicateExecutor<AccountBanName>
