package umc.umc_study_2.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.enums.Gender;
import umc.umc_study_2.domain.enums.Role;
import umc.umc_study_2.repository.MemberRepository.MemberRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String clientName = userRequest.getClientRegistration().getClientName();
        Map<String, Object> attributes = oAuth2User.getAttributes();

        String email = null;
        String name = null;

        // 로그 추가: clientName과 attributes 확인
        System.out.println("Client Name: " + clientName);
        System.out.println("Attributes: " + attributes);

        if ("Kakao".equals(clientName)) {
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            name = (String) properties.get("nickname");
            email = name + "@kakao.com";  // 임시 이메일 생성
        } else if ("Google".equals(clientName)) {
            name = (String) attributes.get("name");
            email = (String) attributes.get("email");
        } else if ("Naver".equals(clientName)) {
            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
            name = (String) response.get("name");
            email = name + "@naver.com";
        }

        // 로그 추가: name과 email 값 확인
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        // 사용자 정보 저장 또는 업데이트
        Member member = saveOrUpdateUser(email, name);

        // 이메일을 Principal로 사용하기 위해 attributes 수정
        Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
        modifiedAttributes.put("email", email);

        return new DefaultOAuth2User(
                oAuth2User.getAuthorities(),
                modifiedAttributes,
                "email"  // email Principal로 설정
        );
    }

    private Member saveOrUpdateUser(String email, String name) {
        if (name == null || name.isEmpty()) {
            name = "default_name";  // 기본값 할당
        }

        Member member = memberRepository.findByEmail(email)
                .orElse(Member.builder()
                        .email(email)
                        .name(name)
                        .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                        .gender(Gender.NONE)  // 기본값 설정
                        .address("소셜로그인")  // 기본값 설정
                        .specAddress("소셜로그인")  // 기본값 설정
                        .role(Role.USER)
                        .build());

        return memberRepository.save(member);
    }
}