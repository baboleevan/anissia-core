package anissia.domain.activePanel.application

import anissia.domain.activePanel.core.model.ActivePanelNoticeRequest
import anissia.domain.activePanel.core.service.ActivePanelService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/active-panel")
class ActivePanelController(
    private val activePanelService: ActivePanelService
) {
    @GetMapping("/list/{page:[\\d]+}")
    fun getList(@RequestParam mode: String, @PathVariable page: Int) = activePanelService.getList(mode == "admin", page)

    @PostMapping("/notice")
    fun addNotice(@RequestBody apnr: ActivePanelNoticeRequest) = activePanelService.saveNotice(apnr)
}
