package anissia.domain.agenda.core.service

import anissia.domain.agenda.infrastructure.AgendaPollRepository
import anissia.domain.agenda.infrastructure.AgendaRepository
import org.springframework.stereotype.Service

@Service
class AgendaService(
    private val agendaRepository: AgendaRepository,
    private val agendaPollRepository: AgendaPollRepository
) {

}
