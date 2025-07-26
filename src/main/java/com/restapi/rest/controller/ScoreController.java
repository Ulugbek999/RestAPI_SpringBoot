package com.restapi.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.rest.score.Score;

@RestController
@CrossOrigin 
public class ScoreController {
    

    static Score score = new Score(30, 20, 10);


    //a health check method to know things are working
    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Situation normal All Fired Up! SNAFU!";
    }

    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    // @GetMapping("/score/wins")
    // public int getWins(){

    //     return score.getWins();
    // }

    // @GetMapping("/score/losses")
    // public int getLosses(){
    //     return score.getLosses();
    // }

    // @GetMapping("/score/ties")
    // public int getTies(){
    //     return score.getTies();
    // }d

    @GetMapping("/score/{winslossesorties}")
    public int getWinsLossesOrTies(@PathVariable String winslossesorties){

        if(winslossesorties.equalsIgnoreCase("wins")){
            return score.getWins();
        }else if(winslossesorties.equalsIgnoreCase("ties")){
            return score.getTies();
        }
        
        return score.getLosses();

    }

    @PostMapping("/score/{increaseVar}")
    public Score increaeWins(@PathVariable String increaseVar){

        if(increaseVar.equalsIgnoreCase("winsUp")){
            score.setWins(score.getWins() + 1);
            return score;

        }else if(increaseVar.equalsIgnoreCase("lossesUp")){
            score.setLosses(score.getLosses() + 1);
            return score;
        }else if(increaseVar.equalsIgnoreCase("tiesUp")){
            score.setTies(score.getTies() + 1);

        }

        return score;
        
        
    }


    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name="new-value")int newValue){
        score.setWins(score.getWins() + newValue);
        return score;
    }


    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore){
        score = newScore;

        return score;
    }

    @DeleteMapping("/score")
    public void deleteScore(){
        score = null;
    }



}
