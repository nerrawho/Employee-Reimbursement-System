package controllers;

import models.Reimbursement;
import services.ReimbursementService;
import io.javalin.http.Context;

import java.util.List;

public class ReimbursementController {

    private final ReimbursementService rs = new ReimbursementService();

    public void handleGetAll(Context ctx) {
        List<Reimbursement> list = rs.getAllReimbursement();
        ctx.json(list);
    }

    public void handeGetOne(Context ctx){
        String idParam = ctx.pathParam("id");
        int reimbursementId = Integer.parseInt(idParam);
        Reimbursement r = rs.getReimbursementById(reimbursementId);
        if(r != null) {
            ctx.json(r);
        } else {
            ctx.status(404);
        }
    }

    public void handleUpdate(Context ctx) {
        String idParam = ctx.pathParam("id");
        Reimbursement rtu = ctx.bodyAsClass(Reimbursement.class);
        int idToUpdate = Integer.parseInt(idParam);
        rtu.setReimbursementID(idToUpdate);
    }
}
