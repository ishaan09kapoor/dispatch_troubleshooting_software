package com.dispatch.fmi.mor.service;
 
import java.util.HashMap;
import java.util.List;

import com.dispatch.fmi.mor.entity.StepMetadataEntity;
 
 
public interface StepMetadataServices {
    StepMetadataEntity getByStepCode(int stepCode);
    List<StepMetadataEntity> getAllSteps(int errorCode);
    HashMap<String, Integer> getAllSteps();
}