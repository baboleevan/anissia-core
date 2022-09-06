package anissia.domain.anime.core.service

import anissia.infrastructure.configruration.logger
import anissia.domain.anime.core.model.AnimeCaptionRecentDto
import anissia.infrastructure.common.As
import anissia.domain.anime.infrastructure.AnimeCaptionRepository
import me.saro.kit.CacheStore
import org.springframework.stereotype.Service

@Service
class AnimeCaptionRecentService(
        private val animeCaptionRepository: AnimeCaptionRepository
) {
    private val log = logger<AnimeCaptionRecentService>()
    private val recentListStore = CacheStore<String, String>(5 * 60000)

    fun getRecentList() = recentListStore.find("NONE") {
        As.toJsonString(animeCaptionRepository.findTop20ByUpdDtBeforeAndWebsiteNotOrderByUpdDtDesc().map { AnimeCaptionRecentDto(it) })
    }
}
