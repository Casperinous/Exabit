package main.java.com.exabit.Controllers;

import main.java.com.exabit.Entities.UsersEntity;
import main.java.com.exabit.Services.UsersEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;

/**
 * Created by nikostot on 4/9/2016.
 */

@Controller
public class WebController {


    @Autowired
    UsersEntityService usersEntityService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestPage() {

        return "test";
    }

    @RequestMapping(value = "/Keys", method = RequestMethod.GET)
    public String getKeysPage() {

        return "keys";
    }

    @RequestMapping(value = "/FriendRequests", method = RequestMethod.GET)
    public String getFriendRequestPage() {

        return "friendrequests";
    }

    @RequestMapping(value = "/Mail", method = RequestMethod.GET)
    public String getMailPage() {

        return "mail";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {

        return "home";
    }
}
