package io.github.toquery.example.spring.security.oauth2.jwt.bff.admin.test.controller;

import io.github.toquery.example.spring.security.oauth2.jwt.core.util.AuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/test")
public class AdminTestController {

    @ResponseBody
    @GetMapping(value = {"", "/", "/info", "/index"})
    public Map<String, Object> index(
            Authentication authentication,
            @AuthenticationPrincipal OAuth2User oauth2User
    ) {
        return AuthenticationUtils.authenticationInfo(this.getClass().getSimpleName(), authentication, oauth2User, null);
    }
}
