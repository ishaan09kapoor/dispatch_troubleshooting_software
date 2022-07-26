package com.dispatch.fmi.mor.service.implementation;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;
import com.dispatch.fmi.mor.entity.StepMetadataEntity;
import com.dispatch.fmi.mor.service.StepMetadataServices;
import com.dispatch.fmi.mor.repository.ErrorMetadataRepository;
import com.dispatch.fmi.mor.repository.StepMetadataRepository;
 
@Service
public class StepMetadataServiceImpl
    implements StepMetadataServices {
   
    @Autowired private StepMetadataRepository stepMetadataRepo;
    @Autowired private ErrorMetadataRepository errorMetadataRepo;

 
    
    /** 
     * @return StepMetadataEntity
     */
    @Override public StepMetadataEntity getByStepCode(int stepCode)
    {
        Optional<StepMetadataEntity> optional = stepMetadataRepo.findById(stepCode);
        StepMetadataEntity stepMetadataEntity = null;
        if (optional.isPresent())
            stepMetadataEntity = optional.get();
        else
            throw new RuntimeException(
                "Step not found for step id : " + stepCode);
        return stepMetadataEntity;
    }

    @Override
    public List<StepMetadataEntity> getAllSteps(int errorCode)
    {
        List<StepMetadataEntity> tempList=new ArrayList<StepMetadataEntity>();
        Optional<ErrorMetadataEntity> optional = errorMetadataRepo.findById(errorCode);        
        ErrorMetadataEntity errorMetadataEntity = null;
        if (optional.isPresent()){
            errorMetadataEntity = optional.get();
            try{
                Optional<StepMetadataEntity> step01 = stepMetadataRepo.findById(errorMetadataEntity.getStep01());
                StepMetadataEntity entity01 = null;
                if (step01.isPresent())
                    entity01 = step01.get();
                tempList.add(entity01);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step02 = stepMetadataRepo.findById(errorMetadataEntity.getStep02());
                StepMetadataEntity entity02 = null;
                if (step02.isPresent())
                    entity02 = step02.get();
                tempList.add(entity02);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step03 = stepMetadataRepo.findById(errorMetadataEntity.getStep03());
                StepMetadataEntity entity03 = null;
                if (step03.isPresent())
                    entity03 = step03.get();
                tempList.add(entity03);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step04 = stepMetadataRepo.findById(errorMetadataEntity.getStep04());
                StepMetadataEntity entity04 = null;
                if (step04.isPresent())
                    entity04 = step04.get();
                tempList.add(entity04);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step05 = stepMetadataRepo.findById(errorMetadataEntity.getStep05());
                StepMetadataEntity entity05 = null;
                if (step05.isPresent())
                    entity05 = step05.get();
                tempList.add(entity05);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step06 = stepMetadataRepo.findById(errorMetadataEntity.getStep06());
                StepMetadataEntity entity06 = null;
                if (step06.isPresent())
                    entity06 = step06.get();
                tempList.add(entity06);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step07 = stepMetadataRepo.findById(errorMetadataEntity.getStep07());
                StepMetadataEntity entity07 = null;
                if (step07.isPresent())
                    entity07 = step07.get();
                tempList.add(entity07);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step08 = stepMetadataRepo.findById(errorMetadataEntity.getStep08());
                StepMetadataEntity entity08 = null;
                if (step08.isPresent())
                    entity08 = step08.get();
                tempList.add(entity08);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step09 = stepMetadataRepo.findById(errorMetadataEntity.getStep09());
                StepMetadataEntity entity09 = null;
                if (step09.isPresent())
                    entity09 = step09.get();
                tempList.add(entity09);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            try{
                Optional<StepMetadataEntity> step10 = stepMetadataRepo.findById(errorMetadataEntity.getStep10());
                StepMetadataEntity entity10 = null;
                if (step10.isPresent())
                    entity10 = step10.get();
                tempList.add(entity10);
            }
            catch (Exception e){
                System.out.println(e.toString());   
            }
            

        }
        else
            throw new RuntimeException(
                "Error not found for error id : " + errorCode);
        
        return tempList;
    }

    @Override
    public HashMap<String,Integer> getAllSteps() {
        List<StepMetadataEntity> stepList=stepMetadataRepo.findAll();
        HashMap<String, Integer> stepMap=new HashMap<String, Integer>();
        Iterator<StepMetadataEntity> iterator=stepList.iterator();
        while(iterator.hasNext()){
            stepMap.put(iterator.next().getStepDescription(),iterator.next().getStepCode());
        }
        return stepMap;
    }
}