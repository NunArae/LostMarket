package com.uniq.lostmarket.api.enums

enum class ServerLoadMessage(val result: String, val message: String) {
    CONNECTION_SUCCESS("서버 연결 성공", "서버 연결에 성공하였습니다."),
    CONNECTION_FAIL("서버 연결 실패", "잘못된 요청이거나 API키의 인증기간이 만료되었습니다. 관리자에게 문의하여주십시오."),
    API_CONNECTION_FAIL("API 연결 실패", "API서버가 닫혀있습니다. 로스트아크 서버와는 별개입니다. 나중에 다시 시도하여주십시오."),
    ERROR("에러", "알 수 없는 에러가 발생하였습니다. 관리자에게 문의하여주십시오."),
}