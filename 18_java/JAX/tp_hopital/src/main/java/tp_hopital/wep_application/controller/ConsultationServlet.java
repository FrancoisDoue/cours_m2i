package tp_hopital.wep_application.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tp_hopital.shared.entity.Consultation;
import tp_hopital.shared.entity.Doctor;
import tp_hopital.shared.entity.Patient;
import tp_hopital.wep_application.service.DoctorService;
import tp_hopital.wep_application.service.PatientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "consultation", value = "/consultation/*")
public class ConsultationServlet extends HttpServlet {

    private PatientService patientService;
    private DoctorService doctorService;
    private Patient patient;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
        doctorService = new DoctorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isLogged = session.getAttribute("isLoggedIn") != null && (boolean) session.getAttribute("isLoggedIn");
        String pathInfo = req.getPathInfo() == null ? "" : req.getPathInfo();
        //        if (!isLogged) {
//            resp.sendRedirect(req.getContextPath() + "/auth/login");
//            return;
//        }
        try {
            patient = patientService.getPatientById(Integer.parseInt(req.getParameter("patient")));
        } catch (NullPointerException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            throw new ServletException(e.getMessage());
        }
        switch (pathInfo) {
            case "/new" -> newConsultation(req, resp);
            case "/read" -> {}
            case "/create" -> {
                createConsultation(req, resp);
                return;
            }
        }
        req.getRequestDispatcher("/WEB-INF/consultation.jsp").forward(req, resp);
    }

    private void newConsultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Doctor> doctors = doctorService.getDoctors();
        req.setAttribute("jspImport", "consultationForm");
        req.setAttribute("patient", patient);
        req.setAttribute("doctors", (doctors.isEmpty()) ? new ArrayList<Doctor>() : doctors);
    }

    private void createConsultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("patient"));
        System.out.println(req.getParameter("doctor"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
