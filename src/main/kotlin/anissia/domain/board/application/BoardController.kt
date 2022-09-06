package anissia.domain.board.application

import anissia.domain.board.core.model.BoardTopicDto
import anissia.domain.board.core.model.BoardPostRequest
import anissia.domain.board.core.model.BoardTopicRequest
import anissia.domain.board.core.service.BoardService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/board")
class BoardController(
    private val boardService: BoardService
) {
    @GetMapping("/ticker/{ticker}")
    fun getTicker(@PathVariable ticker: String): String = boardService.getTickerCached(ticker)

    @GetMapping("/topic/{ticker}/{topicNo}")
    fun getTopic(@PathVariable ticker: String, @PathVariable topicNo: Long): BoardTopicDto = boardService.getTopic(ticker, topicNo)

    @GetMapping("/list/{ticker}/{page}")
    fun getList(@PathVariable ticker: String, @PathVariable page: Int): Page<BoardTopicDto> = boardService.getList(ticker, page)

    @GetMapping("/recent/home")
    fun getHomeRecent() = boardService.getRecent()

    @PostMapping("/topic/{ticker}")
    fun createTopic(@PathVariable ticker: String, @RequestBody @Valid boardTopicRequest: BoardTopicRequest) = boardService.createTopic(ticker, boardTopicRequest)

    @PutMapping("/topic/{topicNo}")
    fun updateTopic(@PathVariable topicNo: Long, @RequestBody @Valid boardTopicRequest: BoardTopicRequest) = boardService.updateTopic(topicNo, boardTopicRequest)

    @DeleteMapping("/topic/{topicNo}")
    fun deleteTopic(@PathVariable topicNo: Long) = boardService.deleteTopic(topicNo)

    @PostMapping("/post/{topicNo}")
    fun createPost(@PathVariable topicNo: Long, @RequestBody @Valid boardPostRequest: BoardPostRequest) = boardService.createPost(topicNo, boardPostRequest)

    @PutMapping("/post/{postNo}")
    fun updatePost(@PathVariable postNo: Long, @RequestBody @Valid boardPostRequest: BoardPostRequest) = boardService.updatePost(postNo, boardPostRequest)

    @DeleteMapping("/post/{postNo}")
    fun deletePost(@PathVariable postNo: Long) = boardService.deletePost(postNo)
}
