package com.dispatch.fmi.mor.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dispatch.fmi.mor.entity.ErrorMetadataEntity;
import com.dispatch.fmi.mor.service.ErrorMetadataServices;
import com.dispatch.fmi.mor.service.NLPService;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

@Service
public class NLPServiceImpl implements NLPService{

    private ArrayList<String> stopwords;
    @Autowired
    private ErrorMetadataServices errorMetadataService;

    public NLPServiceImpl() throws FileNotFoundException{
        stopwords=getStopwords();
    }

    private static ArrayList<String> getStopwords() throws FileNotFoundException{
        Scanner scanner=new Scanner(new File("C:\\Users\\ikapoor\\OneDrive - Freeport-McMoRan Inc\\project\\DTS\\back_end\\fmi.mor\\src\\main\\resources\\stop_words_english.txt"));
        final ArrayList<String> stopwords=new ArrayList<String>();
        while (scanner.hasNext()){
            stopwords.add(scanner.next());
        }
        scanner.close();
        return stopwords;
    }

    private Integer compare(List<String> reference, List<String> iter){
        reference.retainAll(iter);
        return reference.size();
    }

    private static HashMap<Integer, Integer>
    sortByValue(HashMap<Integer, Integer> hm)
    {
        HashMap<Integer, Integer> temp
            = hm.entrySet()
                  .stream()
                  .sorted((i1, i2)
                              -> i1.getValue().compareTo(
                                  i2.getValue()))
                  .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                      (e1, e2) -> e1, LinkedHashMap::new));
 
        return temp;
    }

    private List<String> getLemmas(String errorDescription) {
        Properties props=new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        List<String> annotatedWordList=new ArrayList<String>();
        List<String> referenceErrorDescriptionWordList= new ArrayList<String>(Arrays.asList(errorDescription.split(" ")));
        referenceErrorDescriptionWordList.removeAll(stopwords);
        Iterator<String> iterator=referenceErrorDescriptionWordList.iterator();
        while(iterator.hasNext()){
            String tempWord=iterator.next();
            Annotation tokenAnnotation = new Annotation(tempWord);
            pipeline.annotate(tokenAnnotation);  // necessary for the LemmaAnnotation to be set.
            List<CoreMap> list = tokenAnnotation.get(SentencesAnnotation.class);
            String tokenLemma = list
                        .get(0).get(TokensAnnotation.class)
                        .get(0).get(LemmaAnnotation.class);
            annotatedWordList.add(tokenLemma);
        }
        return annotatedWordList;
    }


    private HashMap<Integer, List<String>> annotateAll(List<ErrorMetadataEntity> allErrorMetadata) {
        HashMap<Integer, List<String>> allAnnotatedHashMap=new HashMap<Integer, List<String>>();
        Iterator<ErrorMetadataEntity> iterator=allErrorMetadata.iterator();
        while(iterator.hasNext()){
            ErrorMetadataEntity tempErrorMetadataEntity=iterator.next();
            List<String> tempErrorMetadataEntityLemmas=getLemmas(tempErrorMetadataEntity.getErrorDescription());
            allAnnotatedHashMap.put(tempErrorMetadataEntity.getErrorCode(), tempErrorMetadataEntityLemmas);
        }
        return allAnnotatedHashMap;
    }

    private HashMap<Integer, Integer> getScore(List<String> refernceAnnotatedWordList,
            HashMap<Integer, List<String>> allAnnotatedWordList) {
        HashMap<Integer, Integer> score=new HashMap<Integer, Integer>();
        for (Integer key:allAnnotatedWordList.keySet()){
            score.put(key, compare(refernceAnnotatedWordList, allAnnotatedWordList.get(key)));
        }
        score=sortByValue(score);
        return score;
    }
    
    @Override
    public List<ErrorMetadataEntity> getSimilarErrors(Integer errorCode) {
        ErrorMetadataEntity errorMetadataEntity=errorMetadataService.getByErrorCode(errorCode);
        String referenceErrorDescription=errorMetadataEntity.getErrorDescription();
        List<String> refernceAnnotatedWordList=getLemmas(referenceErrorDescription);
        List<ErrorMetadataEntity> allErrorMetadata=errorMetadataService.findAll();
        HashMap<Integer, List<String>> allAnnotatedWordList=annotateAll(allErrorMetadata);
        allAnnotatedWordList.remove(errorCode);
        allAnnotatedWordList.remove(99);
        System.out.println(allAnnotatedWordList.toString());
        HashMap<Integer, Integer> score=getScore(refernceAnnotatedWordList, allAnnotatedWordList);
        List<Integer> errorCodes=new ArrayList<>(score.keySet());
        Collections.reverse(errorCodes);
        System.out.println(score.toString());
        List<ErrorMetadataEntity> similarErrorList;
        try{
            similarErrorList=errorMetadataService.findAllByErrorCode(errorCodes.subList(0,5));
        }
        catch (Exception e){
            similarErrorList=errorMetadataService.findAllByErrorCode(errorCodes);
        }
        System.out.println(similarErrorList.get(0).getErrorDescription());
        return similarErrorList;
    }
}
