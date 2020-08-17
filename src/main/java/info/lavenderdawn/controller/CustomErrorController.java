package info.lavenderdawn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{

	private final static String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String error(final HttpServletRequest req, final HttpServletResponse resp, final Model model) {
        final int statusCode = resp.getStatus();
        model.addAttribute("status", statusCode);
        switch (statusCode) {
        case 404:
            return "error/not_found";
        default:
            return "error/general_error";
        }
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
