package umc.umc_study_2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.service.MemberService.MemberQueryService;
import umc.umc_study_2.service.MissionService.MissionQueryService;
import umc.umc_study_2.service.ReviewService.ReviewQueryService;
import umc.umc_study_2.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class UmcStudy2Application {

    public static void main(String[] args) {
        SpringApplication.run(UmcStudy2Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> {
//            StoreQueryService storeService = context.getBean(StoreQueryService.class);
//
//            // 파라미터 값 설정
//            String name = "스타벅스 강남점";
//            Float score = 4.5f;
//
//            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//            System.out.println("Executing findStoresByNameAndScore with parameters:");
//            System.out.println("Name: " + name);
//            System.out.println("Score: " + score);
//
//            storeService.findStoresByNameAndScore(name, score)
//                    .forEach(System.out::println);

            // 미션 진행중/진행 완료 조회 쿼리
//            MissionQueryService memberMissionService = context.getBean(MissionQueryService.class);
//            Pageable pageable = PageRequest.of(0, 10);
//
//            Long memberId = 1L;
//            MissionStatus status = MissionStatus.valueOf("CHALLENGING");
//            //MissionStatus status = MissionStatus.valueOf("COMPLETE");
//            Long lastMissionId = 10L;
//
//            System.out.println("Executing findMissionByMemberIdAndStatus with parameters:");
//            System.out.println("Status: " + status);
//
//            memberMissionService.findMissionByMemberIdAndStatus(memberId, status, lastMissionId, pageable)
//                    .forEach(System.out::println);

//            // 리뷰 작성하는 쿼리
//            ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);
//
//            Long member_id = 1L;
//            Long store_id = 1L;
//            float score = 4.5F;
//            String title = "스타벅스 강남점 리뷰";
//            String body = "매장이 크고 쾌적함";
//
//            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//            System.out.println("Executing insertReview with parameters:");
//            System.out.println("Member ID: " + member_id);
//            System.out.println("Store ID: " + store_id);
//            System.out.println("Score: " + score);
//            System.out.println("Title: " + title);
//            System.out.println("Body: " + body);
//
//            reviewService.insertReview(member_id, store_id, title, body, score);

//            //마이페이지 화면 쿼리
//            MemberQueryService memberQueryService = context.getBean(MemberQueryService.class);
//
//            Long id = 1L;
//
//            System.out.println("Executing insertReview with parameters:");
//            System.out.println("Member ID: " + id);
//
//            memberQueryService.findMemberById(id);

            //홈 화면 쿼리 (달성한 미션 갯수)
            MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);

            Long memberId = 1L;
            MissionStatus status = MissionStatus.valueOf("COMPLETE");

            System.out.println("Executing findCompletedMissionCountByMemberIdAndStatus with parameters:");
            System.out.println("Status: " + status);

        };
    }
}
