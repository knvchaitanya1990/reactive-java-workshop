package io.javabrains.reactiveworkshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * This class is a sample custom Java type used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author koushikkothagal
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    private int id;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}
