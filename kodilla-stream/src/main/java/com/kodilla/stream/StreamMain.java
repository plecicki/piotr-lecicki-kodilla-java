package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Locale;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String yourText = "Hello World";
        poemBeautifier.beautify(yourText, text -> "ABC" + text + "ABC");
        poemBeautifier.beautify(yourText, text -> text.toUpperCase());
        poemBeautifier.beautify(yourText, text -> text.length() + " " + text + " " + text.length());
        poemBeautifier.beautify(yourText, text -> "?" + text.toUpperCase() + " " + text.toLowerCase() + "?");
    }
}
