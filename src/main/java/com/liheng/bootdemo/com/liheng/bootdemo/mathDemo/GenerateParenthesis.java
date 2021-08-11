package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n){
        List res = new ArrayList<>();
        if(n == 0)  return res;
        dsf("",n,n,res);
        return res;
    }

    /**
     *
     * @param str
     * @param left
     * @param right
     * @param res
     */
    public void dsf(String str,int left,int right,List res){
        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        if(left > right){
            return;
        }
        if(left > 0){
            dsf(str + "(",left-1,right,res);
        }
        if(right > 0){
            dsf(str + ")",left,right-1,res);
        }
    }
}
