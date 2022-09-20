package anissia.domain.board.core.model

import javax.validation.constraints.NotEmpty

data class BoardPostRequest (
    @field:NotEmpty(message = "내용을 입력해주세요.")
    var content: String = "",
)
