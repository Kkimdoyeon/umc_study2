package umc.umc_study_2.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.apiPayload.exception.handler.FoodCategoryHandler;
import umc.umc_study_2.converter.MemberConverter;
import umc.umc_study_2.converter.MemberPreferConverter;
import umc.umc_study_2.domain.FoodCategory;
import umc.umc_study_2.domain.Member;
import umc.umc_study_2.domain.mapping.MemberPrefer;
import umc.umc_study_2.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.umc_study_2.repository.MemberRepository.MemberRepository;
import umc.umc_study_2.web.dto.Member.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}