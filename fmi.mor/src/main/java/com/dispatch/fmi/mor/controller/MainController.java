package com.dispatch.fmi.mor.controller;
 
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;
import com.dispatch.fmi.mor.entity.StepMetadataEntity;
import com.dispatch.fmi.mor.service.ErrorLogServices;
import com.dispatch.fmi.mor.service.ErrorMetadataServices;
import com.dispatch.fmi.mor.service.NLPService;
import com.dispatch.fmi.mor.service.StepMetadataServices;

@Controller
public class MainController {
 
    @Autowired
    private ErrorLogServices errorLogsService;
    
    @Autowired
    private ErrorMetadataServices errorMetadataService;

    @Autowired
    private StepMetadataServices stepMetadataService;

    @Autowired
    private NLPService nlpService;

    
    
    /** 
     * @param model
     * @return String
     */
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allerrorlist", errorMetadataService.getAllErrorMetadata());
        return "homepage";
    }

    @GetMapping("/test")
    public String hello(Model model) {
        return "homepage";
    }
 
    
    /** 
     * @param errorCode
     * @param model
     * @return String
     */
    @GetMapping("/reportError/{errorCode}")
    public String reportError(@PathVariable(value="errorCode") int errorCode,Model model) {
        if(errorCode!=99){
            errorLogsService.addErrorLog(errorCode);
            List<StepMetadataEntity> stepCodes=stepMetadataService.getAllSteps(errorCode);
            model.addAttribute("error", errorMetadataService.getByErrorCode(errorCode));
            model.addAttribute("stepList", stepCodes);
            return "solution";
        }
        else{
            model.addAttribute(new ErrorMetadataEntity());
            return "others";
        }
    }
 
    
    /** 
     * @param errorMetadataEntity
     * @return String
     */
    @GetMapping("/addOtherError")
    public String addOtherError(@ModelAttribute("errorMetadataEntity") ErrorMetadataEntity errorMetadataEntity, Model model)  {
        errorMetadataService.save(errorMetadataEntity);
        Integer errorCode=errorMetadataEntity.getErrorCode();
        errorLogsService.addErrorLog(errorCode);
        List<ErrorMetadataEntity> similarErrorList=nlpService.getSimilarErrors(errorCode);
        model.addAttribute("similarErrorList", similarErrorList);
        return "similarErrors";
    }
    /** 
     * @param errorCode
     * @return String
     */
    @GetMapping("/deleteError/{errorCode}")
    public String deleteError(@PathVariable(value="errorCode") int errorCode, Model model) {
        model.addAttribute("errorCode", errorCode);
        if(errorCode!=99 && errorMetadataService.findById(errorCode).get().isIsTypeOther()){
            errorMetadataService.deleteById(errorCode);
            errorLogsService.deleteAllInstancesOfErrorCode(errorCode);
        }
        return "redirect:/";
    } 

    @GetMapping("/viewError/{errorCode}")
    public String viewError(@PathVariable(value="errorCode") int errorCode,Model model) {
            List<StepMetadataEntity> stepCodes=stepMetadataService.getAllSteps(errorCode);
            model.addAttribute("error", errorMetadataService.getByErrorCode(errorCode));
            model.addAttribute("stepList", stepCodes);
            model.addAttribute("oldEntity", new ErrorMetadataEntity());
            return "solution";
    }

    @GetMapping("/edit/{errorCode}")
    public String editError(@PathVariable(value="errorCode") int errorCode,Model model) {
            List<StepMetadataEntity> existingStepCodes=stepMetadataService.getAllSteps(errorCode);    
            HashMap<String, Integer> allStepMap=stepMetadataService.getAllSteps();
            model.addAttribute("error", errorMetadataService.getByErrorCode(errorCode));
            model.addAttribute("existingStepList", existingStepCodes);
            model.addAttribute("allStepMap", allStepMap);
            model.addAttribute("oldEntity", new ErrorMetadataEntity());
            return "edit";
    }

    @GetMapping("/updateError/{errorCode}")
    public String updateError(@PathVariable(value="errorCode") int errorCode, @ModelAttribute("oldEntity") ErrorMetadataEntity oldEntity){
        oldEntity.setErrorCode(errorCode);
        errorMetadataService.update(oldEntity);
        return "redirect:/";
    }

 
}