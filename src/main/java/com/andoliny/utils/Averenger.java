package com.andoliny.utils;

import com.andoliny.model.entities.User;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Averenger {
    public static double getAverAge(List<User> users) {
        return users.stream().mapToInt(val -> val.getUserData().getAge()).average().getAsDouble();
    }

    private static String countItems(List<String> properties) {
        Map<String, Long> counted = properties.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        JSONObject jsonObject = new JSONObject(counted);
        return jsonObject.toString();
    }

    public static String createNatList(List<User> users){
        List<String> items = users.stream()
                .map(p -> p.getUserData().getNationality().getName())
                .collect(Collectors.toList());
        return  countItems(items);
    }

    public static String createSexList(List<User> users){
        List<String> items = users.stream()
                .map(p -> p.getUserData().getSex().getDescription())
                .collect(Collectors.toList());
        return countItems(items);
    }

}
