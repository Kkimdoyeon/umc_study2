package umc.umc_study_2.service.MissionService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_study_2.apiPayload.exception.handler.MissionHandler;
import umc.umc_study_2.apiPayload.exception.handler.StoreHandler;
import umc.umc_study_2.apiPayload.code.status.ErrorStatus;
import umc.umc_study_2.converter.MissionConverter;
import umc.umc_study_2.domain.Mission;
import umc.umc_study_2.domain.Store;
import umc.umc_study_2.domain.enums.MissionStatus;
import umc.umc_study_2.domain.mapping.MemberMission;
import umc.umc_study_2.repository.MemberMissionRepository.MemberMissionRepository;
import umc.umc_study_2.repository.MissionRepository.MissionRepository;
import umc.umc_study_2.repository.StoreRepository.StoreRepository;
import umc.umc_study_2.web.dto.Mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionCommandServiceImpl implements MissionCommandService{
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission addMissionToStore(MissionRequestDTO.AddMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        newMission.setStore(store);
        return missionRepository.save(newMission);
    }

    // 해당 missionId에 맞는 미션이 존재하는지
    @Override
    public boolean doMissionExist(Long missionId) {
        if (missionId == null) {
            return false;
        }
        return missionRepository.existsById(missionId);
    }

    @Override
    public MemberMission updateMissionStatus(Long memberId, Long missionId, MissionStatus status) {
        MemberMission memberMission = (MemberMission) memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId).orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));
        memberMission.setStatus(status);
        return memberMission;
    }

}