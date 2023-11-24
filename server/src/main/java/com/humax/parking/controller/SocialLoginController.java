package com.humax.parking.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.humax.parking.dto.SocialUserInfoDto;
import com.humax.parking.service.KakaoUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class SocialLoginController {
    private final KakaoUserService kakaoService;

    @GetMapping("/kakao/callback")
    public SocialUserInfoDto kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoService.kakaoLogin(code, response);
    }
}
