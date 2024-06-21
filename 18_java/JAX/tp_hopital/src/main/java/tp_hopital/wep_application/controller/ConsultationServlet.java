package tp_hopital.wep_application.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tp_hopital.shared.entity.Consultation;
import tp_hopital.shared.entity.Patient;
import tp_hopital.wep_application.service.PatientService;

import java.io.IOException;

@WebServlet(name = "consultation", value = "/consultation/*")
public class ConsultationServlet extends HttpServlet {

    private PatientService patientService;
    private Patient patient;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isLogged = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
        patient = patientService.getPatientById(
                Integer.parseInt(req.getParameter("patient"))
        );
        //        if (!isLogged) {
//            resp.sendRedirect(req.getContextPath() + "/auth/login");
//            return;
//        }

        switch (pathInfo) {
            case "/new" -> newConsultation(req, resp);
            case "/read" -> {}
        }
        req.getRequestDispatcher("/WEB-INF/consultation.jsp").forward(req, resp);
    }

    private void newConsultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("jspImport", "consultationForm");
        req.setAttribute("patient", patient);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
