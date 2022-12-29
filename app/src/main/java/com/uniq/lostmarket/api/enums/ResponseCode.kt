package com.uniq.lostmarket.api.enums

enum class ResponseCode(val code: Int, val text: String, val description: String) {
    OK(200, "OK", "응답 완료"),
    BAD_REQUEST(400, "Bad Request", "올바르지 않은 요청입니다."),
    UNAUTHORIZED(401, "Unauthorized", "유효하지 않은 API_KEY를 사용하고 있습니다."),
    FORBIDDEN(403, "Forbidden", "접근이 거부되었습니다."),
    NOT_FOUND(404, "Not Found", "요청받은 리소스를 찾을 수 없습니다."),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type", "클라이언트가 보낸 페이로드가 지원하지 않는 형식입니다."),
    RATE_LIMIT_EXCEEDED(429, "Rate Limit Exceeded", "너무 많은 요청을 보내고 있습니다."),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "서버가 예상하지 못한 에러를 감지하였습니다."),
    BAD_GATEWAY(502, "BAD_GATEWAY", "업스트림 서버로부터 유효하지 않은 응답을 받았습니다."),
    SERVICE_UNAVAILABLE(503, "Service Unavailable", "현재 서버가 닫혀있는 것 같습니다. 서버 상태를 확인하시거나 잠시 후 다시 시도해주세요."),
    GATEWAY_TIMEOUT(504, "GATEWAY_TIMEOUT", "요청 시간이 초과되었습니다. 서버 상태를 확인하시거나 잠시 후 다시 시도해주세요."),
}