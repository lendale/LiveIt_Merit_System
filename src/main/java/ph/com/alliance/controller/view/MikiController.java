package ph.com.alliance.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Example controller class that hadles static view requests.
 * All requests that returns pages (html, xhtml, jsp, jspx, etc.) is handled here.
 */
@Controller
@RequestMapping("/user")
public class MikiController {

    /**
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String viewProfile(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        System.out.println("@/modulename/profile MODULE VIEW CONTROLLER CALLED.");
        return "mymodule/list";
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
