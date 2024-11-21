package umc.umc_study_2.apiPayload.exception.handler;

import umc.umc_study_2.apiPayload.code.BaseErrorCode;
import umc.umc_study_2.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
