package com.example.keyboard;

import com.sun.deploy.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KeyboardService {

    private static final String[] kb = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void getResult(int index) {
        String in = String.valueOf(index);
        String[] arr = in.split("");
        System.out.println(String.format("Input: arr[] = {%s}", StringUtils.join(Arrays.asList(arr), ",")));

        if (arr.length == 1 && (index == 0 || index == 1)) {
            System.out.println("Output: arr[] = ");
            return ;
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String str = kb[Integer.parseInt(arr[i])];
            if (str.length() == 0)
                continue;
            list.add(str);
        }

        List<String> result = new ArrayList<>();
        int cur = 0;
        while (cur < list.size()) {
            String[] temp = list.get(cur).split("");
            if (cur == 0) {
                result.addAll(Arrays.asList(temp));
                cur ++;
                continue;
            }else {
                List<String> tempArr = new ArrayList<>();
                for (int i = 0; i < temp.length; i++) {
                    for (String s: result) {
                        tempArr.add(s.concat(temp[i]));
                    }
                }
                result = tempArr;
            }
            cur ++;
        }

        System.out.println(String.format("Output: %s", StringUtils.join(result, " ")));
        return;
    }

}
