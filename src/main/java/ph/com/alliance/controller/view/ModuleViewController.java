package ph.com.alliance.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ph.com.alliance.entity.User2;
import ph.com.alliance.service.ModuleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Example controller class that hadles static view requests.
 * All requests that returns pages (html, xhtml, jsp, jspx, etc.) is handled here.
 */
@Controller
@RequestMapping("/modulename")
public class ModuleViewController {


    @Autowired
    private ModuleService moduleService;

    /**
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String viewProfile(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        return "myfolder/profile";
    }

    /**
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping(value = "/addtwonumbers", method = RequestMethod.GET)
    public String addTwoNumbers(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        String firstNumber = request.getParameter("firstNumber");
        String secondNumber = request.getParameter("secondNumber");

        String sum = moduleService.addTwoNumbers(firstNumber, secondNumber);

        map.addAttribute("firstNumber", firstNumber);
        map.addAttribute("secondNumber", secondNumber);
        map.addAttribute("sum", sum);

        return "myfolder/sumofnumbers";
    }


    /**
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String loadList(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");

        List<User2> userList = moduleService.getAllUsers();
        map.addAttribute("userList", userList);

        return "myfolder/userlist";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        String uid = request.getParameter("userid");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");


        // validate if certan field is wrong
        if (uid == null) {

        }

        User2 user = new User2();
        user.setUid(uid);
        user.setFname(firstName);
        user.setlName(lastName);
        user.setAge(age);
        user.setPassword(password);
        user.setGender(gender);

        moduleService.addUser(user);

        return this.loadList(request, response, map);
    }

    @RequestMapping(value = "/edituser", method = RequestMethod.POST)
    public String editUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        String uid = request.getParameter("userid");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");


        // validate if certan field is wrong
        if (uid == null) {

        }

        User2 user = moduleService.getUser(uid);
        user.setFname(firstName);
        user.setlName(lastName);
        user.setAge(age);
        user.setPassword(password);
        user.setGender(gender);

        moduleService.editUser(user);

        return this.loadList(request, response, map);
    }


    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");

        String[] userIdList = request.getParameterValues("userid");
        if (userIdList != null) {


            for (String userId : userIdList) {
                System.out.println("THIS IS SELECTED === " + userId);
            }

            moduleService.deleteUsers(userIdList);
        }
        return this.loadList(request, response, map);
    }


    @RequestMapping(value = "/loadedit", method = RequestMethod.GET)
    public String loadEditUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        String uid = request.getParameter("userid");

        //validate


        User2 user = moduleService.getUser(uid);
        map.addAttribute("myUser", user);
        map.addAttribute("myFunction", "edit");
        return "myfolder/userlist";
    }


    /**
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String viewMessages(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/messages MODULE VIEW CONTROLLER CALLED.");
        return "messages";
    }

    /**
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping(value = "/userform", method = RequestMethod.GET)
    public String viewUserForm(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/userform MODULE VIEW CONTROLLER CALLED.");
        return "userform";
    }
}
