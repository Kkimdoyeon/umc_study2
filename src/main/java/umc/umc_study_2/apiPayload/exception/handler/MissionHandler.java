package umc.umc_study_2.apiPayload.exception.handler;

import umc.umc_study_2.apiPayload.code.status.ErrorStatus;

public class MissionHandler extends RuntimeException {
    public MissionHandler(ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
    }
}