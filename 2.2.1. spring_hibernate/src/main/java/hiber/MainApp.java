package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User userNew1 = new User(" Draco ", "Malfoy", "malfoy@mail.ru");
      Car car1 = new Car("Ferrary",812);
      userNew1.setCar(car1);
      userService.add(userNew1);
      User userNew2 = new User("Vincent", "Crabbe", "crabbe@mail.ru");
      Car car2 = new Car("Buggaty",110);
      userNew2.setCar(car2);
      userService.add(userNew2);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getUser("Buggaty",110));
      context.close();
   }
}
