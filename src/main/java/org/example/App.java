package org.example;

import org.example.configuration.Config;
import org.example.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Communication communication = context.getBean("communication", Communication.class);

        List<User> allUsers = communication.getAllUsers();
        System.out.println(allUsers);

        User user = new User(3L, "James", "Brown", (byte) 18);
        String response1 = communication.saveUser(user);

        user.setName("Thomas");
        user.setLastName("Shelby");
        String response2 = communication.editUser(user);

        String response3 = communication.deleteUser(user.getId());

        String sumResponse = response1 + response2 + response3;
        System.out.println(sumResponse);
        System.out.println(sumResponse.length());
    }
}