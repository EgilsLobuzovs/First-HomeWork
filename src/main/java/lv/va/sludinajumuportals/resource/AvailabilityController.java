package lv.va.sludinajumuportals.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AvailabilityController {
    public String status = "<h1>503 Service Unavailable</h1>";

    public String htmlPost =
            "<form method=\"post\" action=\"\" class=\"inline\">" + "</br>setStutus poga:</br>"+
            "<button type=\"submit\"  class=\"link-button\">\n" + "setStatus()\n" + "</button>\n" + "</form>";
    public String htmlGet =
            "<form method=\"get\" action=\"\" class=\"inline\">" + "getStutus poga:</br>"+
            "<button type=\"submit\"  class=\"link-button\">\n" + "getStatus()\n" + "</button>\n" + "</form>";

    @GetMapping(value = "/{id}")
    @ResponseBody
    public String getStatus(@PathVariable String id) {
        return status+"</br>PathVariable = "+id+htmlPost+htmlGet+"</br>";
    }

    @PostMapping(value = "/{id}")
    @ResponseBody
    public String setStatus(@PathVariable String id) {
        switch (status) {
            case "<h1>503 Service Unavailable</h1>":
                status = "<h1>200 OK</h1>";
                break;
            case "<h1>200 OK</h1>":
                status = "<h1>503 Service Unavailable</h1>";
                break;
            default:
                status = "default";
                break;
        }

        return status+"</br>PathVariable = "+id+htmlPost+htmlGet+"</br>";
    }
}