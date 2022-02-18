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
        app.post("/reimbursement", rc.createReimbursement);
        app.get("/reimbursement", rc.getAllReimbursement);
        //app.get("/reimbursement/employee", rc.getReimbursementByEmployee);
        app.get("/reimbursement/type", rc.getReimbursementByType);
        app.get("/reimbursement/status", rc.getReimbursementByStatus);
        app.get("/reimbursement/{id}", rc.getReimbursementByEmployee);
        app.put("/reimbursement/{id}" , rc.updateReimbursement);
        app.delete("/reimbursement/{id}", rc.deleteReimbursement);
        app.get("/reimbursement/employee/pending", rc.getPendingForEmployee);
        app.get("/reimbursement/employee/resolved", rc.getResolvedForEmployee);
        app.get("/reimbursement/manager/pending", rc.getAllPendingReimbursement);
        app.get("/reimbursement/manager/resolved", rc.getAllResolvedReimbursement);
        app.put("/reimbursement/manager/approve", rc.approve);
        app.put("/reimbursement/manager/deny", rc.deny);
    }
}
