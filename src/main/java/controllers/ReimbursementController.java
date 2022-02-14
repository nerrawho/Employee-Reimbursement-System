package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;
import models.Reimbursement;
import models.ReimbursementType;
import models.User;
import services.ReimbursementService;
import io.javalin.http.Context;
import services.UserService;

import java.util.List;

public class ReimbursementController {

    private ReimbursementService rs;
    private UserService us;
    private ObjectMapper mapper = new ObjectMapper();

    public ReimbursementController(ReimbursementService rs, UserService ps) {
        this.rs = rs;
        this.us = us;
    }

    public Handler createReimbursement = context -> {

        Ticket tick = mapper.readValue(context.body(), Ticket.class);

        String email = tick.email;
        String type = tick.type.trim().toUpperCase();
        Double amount = Double.parseDouble(tick.amount);
        String description = tick.description;
        
        User u = us.getUserByEmail(email);

        rs.createReimbursement(u, type, amount, description);
    };

    public Handler getReimbursementById = context -> {
        Integer idParam = Integer.parseInt(context.pathParam("id"));
        Reimbursement r = rs.getReimbursementById(idParam);
        context.json(r);
    };

    public Handler getAllReimbursement = context -> {
        List<Reimbursement> list = rs.getAllReimbursement();
        context.json(list);
    };

    public Handler getReimbursementByEmployee = context -> {
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);
        List<Reimbursement> list = rs.getReimbursementByEmployee(u);
        context.json(list);
    };

}

class Ticket {
    public String email;
    public String type;
    public String amount;
    public String description;
}
