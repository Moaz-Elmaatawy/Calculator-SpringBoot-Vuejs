package com.calc.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Rest {

    @GetMapping("/calc")
    public String calculate(String name){
        String [] h=name.split(" ");

        List<String> arr = new ArrayList<>(Arrays.asList(h));
        int i=0;
        while(i<arr.size()){
            if (arr.get(i).equals("*") ){
                arr.add(i-1,String.valueOf(Double.parseDouble(arr.get(i-1))*Double.parseDouble(arr.get(i+1))));
                arr.remove(i);
                arr.remove(i);
                arr.remove(i);
                i=0;
            }
            else if (arr.get(i).equals("÷") && Double.parseDouble(arr.get(i+1)) != 0){
                arr.add(i-1,String.valueOf(Double.parseDouble(arr.get(i-1))/Double.parseDouble(arr.get(i+1))));
                arr.remove(i);
                arr.remove(i);
                arr.remove(i);
                i=0;
            }
            else if (arr.get(i).equals("÷") && Double.parseDouble(arr.get(i+1)) == 0)
                return "Division by zero";
            else
             ++i;

        }
        double ans=Double.parseDouble(arr.get(0));
        for(i=1;i<arr.size()-1;++i) {
            if (arr.get(i).equals("+"))
                ans += Double.parseDouble(arr.get(i+1));
            else if (arr.get(i).equals("-"))
                ans -= Double.parseDouble(arr.get(i+1));
        }
        return String.valueOf(ans);
    }



}
