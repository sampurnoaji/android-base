package id.petersam.base.data.mapper

import id.petersam.base.data.response.LoginDto
import id.petersam.base.domain.entity.LoginData
import id.petersam.base.external.base.BaseMapper
import javax.inject.Inject

class LoginMapper @Inject constructor() : BaseMapper<LoginDto, LoginData>() {
    override fun map(input: LoginDto): LoginData {
        return LoginData(
            name = input.name ?: "",
            token = input.token ?: ""
        )
    }
}
