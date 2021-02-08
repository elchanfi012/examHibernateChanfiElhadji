package exam_hibernate_chanfi_elhadji.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam_hibernate_chanfi_elhadji.sevices.CarService;

/**
 * Servlet implementation class DashboardServlet
 */
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarService carService;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.carService = new CarService();
		
		List<?> marques = this.carService.getMarqueList();
		List<?> cars = this.carService.getAll();
		List<Integer> nbCarsMarques = new ArrayList<Integer>();
		
		for (int i = 0; i < marques.size(); i++) {
			nbCarsMarques.add(Collections.frequency(cars, (String) marques.get(i)));
		}
		
		
		Long nbCars = this.carService.getNbCars();
		
		List<?> tenLatestCarsAdded = this.carService.getTenLatestCarAdd();
		
		System.out.println("[ " + nbCarsMarques + " ]");
		
		request.setAttribute("marques", marques);
		request.setAttribute("nbCarsMarque", nbCarsMarques);
		request.setAttribute("nbCars", nbCars);
		request.setAttribute("tenLatestCars", tenLatestCarsAdded);
		
		request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
