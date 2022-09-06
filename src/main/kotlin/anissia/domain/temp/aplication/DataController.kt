package anissia.domain.temp.aplication

import anissia.infrastructure.AnissiaCoreApplication
import anissia.infrastructure.configruration.logger
import anissia.domain.temp.core.service.DataService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * it must use only develop server !!
 */

@RestController
@RequestMapping("/data")
class DataController(
    private val dataService: DataService
) {
    var log = logger<AnissiaCoreApplication>()

    @GetMapping("/update/animeDocument")
    fun updateAnimeDocument() = dataService.updateAnimeDocument()

    // basic information
    @GetMapping("/test/basic")
    fun createBasicTestData() = dataService.createBasicTestData()

    // make a anime rank test data
    @GetMapping("/test/rank")
    fun createAnimeHitTestData() = dataService.createAnimeHitTestData()
}
