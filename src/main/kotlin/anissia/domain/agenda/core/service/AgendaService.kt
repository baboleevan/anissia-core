package anissia.domain.agenda.core.service

import anissia.domain.agenda.core.ports.outbound.AgendaPollRepository
import anissia.domain.agenda.core.ports.outbound.AgendaRepository
import org.springframework.stereotype.Service

@Service
class AgendaService(
    private val agendaRepository: AgendaRepository,
    private val agendaPollRepository: AgendaPollRepository
) {

}
