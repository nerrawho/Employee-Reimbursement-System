package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.ReimbursementDaoImp;
import io.javalin.http.Handler;
import models.*;
import services.ReimbursementService;
import io.javalin.http.Context;
import services.UserService;

import java.util.List;

public class ReimbursementController {

    private ReimbursementService rs = new ReimbursementService();
    private UserService us = new UserService();
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
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);

        Integer idParam = Integer.parseInt(context.pathParam("id"));

        if(u.getRole() == UserRole.MANAGER) {
            context.status(200);
            Reimbursement r = rs.getReimbursementById(idParam);
            context.json(r);
        }
        else
            context.status(403);

    };

    public Handler getAllReimbursement = context -> {
        List<Reimbursement> list = rs.getAllReimbursement();
        context.json(list);
    };

    public Handler getReimbursementByEmployee = context -> {
        Integer id = Integer.parseInt(context.pathParam("id"));
        User u = us.getUserById(id);

        List<Reimbursement> list = rs.getReimbursementByEmployee(u);
        context.json(list);
    };

    public Handler getReimbursementByType = context -> {
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);

        String rType = context.body().trim().toUpperCase();
        ReimbursementType t = ReimbursementType.valueOf(rType);

        if(ReimbursementType.exists(t)) {
            if (u.getRole() == UserRole.MANAGER) {
                context.status(200);
                List<Reimbursement> list = rs.getReimbursementByType(t);
                context.json(list);
            } else
                context.status(403);
        }
        else
            context.status(406);
    };

    public Handler getReimbursementByStatus = context -> {
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);

        String rStatus = context.body().trim().toUpperCase();

        ReimbursementStatus t = ReimbursementStatus.valueOf(rStatus);

        if(ReimbursementStatus.exists(t)) {
            if (u.getRole() == UserRole.MANAGER) {
                context.status(200);
                List<Reimbursement> list = rs.getReimbursementByStatus(t);
                context.json(list);
            } else
                context.status(403);
        }
        else
            context.status(406);

    };

    public Handler updateReimbursement = context -> {
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);

        Integer idParam = Integer.parseInt(context.pathParam("id"));
        Reimbursement rToUpdate = context.bodyAsClass(Reimbursement.class);
        rToUpdate.setReimbursementID(idParam);

        if(u.getRole() == UserRole.MANAGER) {
            context.status(200);
            rs.updateReimbursement(rToUpdate);
        }
        else
            context.status(403);
    };

    public Handler deleteReimbursement = context -> {
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));

        if(email == null) {
            context.status(401);
            context.result("User unverified");
        }
        else {
            context.status(200);
            Integer idParam = Integer.parseInt(context.pathParam("id"));
            Reimbursement rToDelete = context.bodyAsClass(Reimbursement.class);
            rToDelete.setReimbursementID(idParam);
            rs.deleteReimbursement(rToDelete);
        }

    };

    public Handler getPendingForEmployee = context -> {
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);

        List<Reimbursement> list = rs.getPendingForEmployee(u);
        context.json(list);
    };

    public Handler getResolvedForEmployee = context -> {
        context.header("Access-Control-Expose-Headers", "*");
        String email = String.valueOf(context.req.getSession().getAttribute("logged-in"));
        User u = us.getUserByEmail(email);

        List<Reimbursement> list = rs.getResolvedForEmployee(u);
        context.json(list);
    };

    public Handler getAllPendingReimbursement = context -> {
        List<Reimbursement> list = rs.getAllPendingReimbursement();
        context.json(list);
    };

    public Handler getAllResolvedReimbursement = context -> {
        List<Reimbursement> list = rs.getAllResolvedReimbursement();
        context.json(list);
    };

    public Handler approve = context -> {

        RID rid = mapper.readValue(context.body(), RID.class);
        Integer reimbursementId = Integer.parseInt(rid.id);
        Reimbursement r = new Reimbursement();
        r.setResolvedBy(rid.managerName);
        r.setReimbursementID(reimbursementId);

        rs.approve(r);
    };

    public Handler deny = context -> {

        RID rid = mapper.readValue(context.body(), RID.class);
        Integer reimbursementId = Integer.parseInt(rid.id);
        Reimbursement r = new Reimbursement();
        r.setResolvedBy(rid.managerName);
        r.setReimbursementID(reimbursementId);

        rs.deny(r);

    };


}

class RID {
    public String id;
    public String managerName;
}

class Ticket {
    public String email;
    public String type;
    public String amount;
    public String description;
}
