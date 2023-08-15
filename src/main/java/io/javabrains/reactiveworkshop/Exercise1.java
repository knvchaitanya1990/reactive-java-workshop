package io.javabrains.reactiveworkshop;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("<--- Print all numbers in the intNumbersStream stream -->");
        // TODO: Write code here

        StreamSources.intNumbersStream().forEach(System.out::println);

        System.out.println("<--- Print numbers from intNumbersStream that are less than 5 -->");
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(n -> n < 5).
                forEach(System.out::println);
        System.out.println("<--- Print the second and third numbers in intNumbersStream that's greater than 5 -->");
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(n -> n > 5).skip(1).limit(2).
                forEach(System.out::println);

        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        //  If nothing is found, print -1
        // TODO: Write code here

        Integer input = StreamSources.intNumbersStream().filter(n -> n > 5).
                findFirst().
                orElse(-1);
        System.out.println(input);

        System.out.println("<-- Print first names of all users in userStream -->");
        // TODO: Write code here
        StreamSources.userStream().map(User::getFirstName).forEach(System.out::println);

        System.out.println("<-- Print first names in userStream for users that have IDs from number stream-->");
        // TODO: Write code here

        System.out.println("#### First  Option #### ");
        Stream<Integer> numberStream = StreamSources.intNumbersStream();
        Set<Integer> numberSet = numberStream.collect(Collectors.toSet());

        StreamSources.userStream()
                .filter(user -> numberSet.contains(user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);

        System.out.println("#### Second Option #### ");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName()).forEach(System.out::println);
    }

}
