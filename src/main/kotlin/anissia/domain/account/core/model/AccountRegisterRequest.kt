package anissia.domain.account.core.model

import anissia.infrastructure.common.As
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class AccountRegisterRequest(
    @field:NotEmpty(message = "이메일이 형식에 맞지 않습니다.")
    @field:Size(min = 1, max = 64, message = "이메일이 형식에 맞지 않습니다.")
    @field:Email(regexp = As.IS_MAIL, message = "이메일이 형식에 맞지 않습니다.")
    var email: String = "",

    @field:NotEmpty(message = "암호는 8자이상 128자이하로 입력해주세요.")
    @field:Size(min = 8, max = 128, message = "암호는 8자이상 128자이하로 입력해주세요.")
    var password: String = "",

    @field:NotEmpty(message = "닉네임은 특수문자를 제외한\n한글/영어/숫자/한자/일어로\n2자이상 16자 이하로 입력해주세요.")
    @field:Pattern(regexp = As.IS_NAME, message = "닉네임은 특수문자를 제외한\n한글/영어/숫자/한자/일어로\n2자이상 16자 이하로 입력해주세요.")
    var name: String = ""
)
