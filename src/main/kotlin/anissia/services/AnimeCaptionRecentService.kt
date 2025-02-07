package anissia.services

import anissia.configruration.logger
import anissia.dto.AnimeCaptionRecentDto
import anissia.misc.As
import anissia.rdb.repository.AnimeCaptionRepository
import me.saro.kit.CacheStore
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class AnimeCaptionRecentService(
        private val animeCaptionRepository: AnimeCaptionRepository
) {
    private val log = logger<AnimeCaptionRecentService>()
    private val recentListStore = CacheStore<String, String>(5 * 60000)

    fun getRecentList() = recentListStore.find("NONE") {
        As.toJsonString(animeCaptionRepository.findAllByWebsiteNotOrderByUpdDtDesc(PageRequest.of(0, 20)).content.map { AnimeCaptionRecentDto(it) })
    }

    fun getRecentList(page: Int) =
        animeCaptionRepository.findAllByWebsiteNotOrderByUpdDtDesc(PageRequest.of(page, 20)).map { AnimeCaptionRecentDto(it) }
}
