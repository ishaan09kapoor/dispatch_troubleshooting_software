package com.dispatch.fmi.mor.service;

import java.util.List;

import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;

public interface NLPService {
    List<ErrorMetadataEntity> getSimilarErrors(Integer errorCode);

}
