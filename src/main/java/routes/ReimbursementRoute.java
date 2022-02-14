package routes;

import controllers.ReimbursementController;
import io.javalin.Javalin;

public class ReimbursementRoute extends Route {

    private ReimbursementController rc;

    public ReimbursementRoute(ReimbursementController rc) {
        this.rc = rc;
    }

    @Override
    public void registerLocalRoutes(Javalin app) {
        app.post("/reimbursement/create", rc.createReimbursement);
        app.get("/reimbursement/get-all", rc.getAllReimbursement);
        app.get("/reimbursement/get-by-employee", rc.getReimbursementByEmployee);
        app.get("/reimbursement/get-by-type", rc.getReimbursementByType);
        app.get("/reimbursement/get-by-status", rc.getReimbursementByStatus);
        app.get("/reimbursement/{id}", rc.getReimbursementById);
        app.put("/reimbursement/{id}" , rc.updateReimbursement);
        app.delete("/reimbursement/{id}", rc.deleteReimbursement);
    }
}
