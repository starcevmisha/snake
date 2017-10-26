package SnakeGame.models;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class JsonToJava {

    public static void main(String[] args) throws IOException {
        File file = new File("src\\SnakeGame\\models\\levels.json");
        JsonReader reader = new JsonReader(new FileReader(file));

        Gson gson = new Gson();
        Level[] arr = gson.fromJson(reader, Level[].class);
        System.out.println(123);

    }

    class Level {
        String name;
        String[] map;
    }
}
