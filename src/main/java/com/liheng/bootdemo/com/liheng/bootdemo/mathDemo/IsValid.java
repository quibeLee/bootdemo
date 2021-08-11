package com.liheng.bootdemo.com.liheng.bootdemo.mathDemo;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {

    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>(){{
            add('?');
        }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if (!map.get(stack.removeLast()).equals(c)) return false;
        }
        return stack.size() == 1;
    }
    @Test
    public void test(){
        int[] a = {1,2,3};
        int[] b = a.clone();
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println(isValid("({}[])}[]"));
    }

}
