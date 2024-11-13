package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.odontologoModel;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.Odontologo;


/**
 * Servlet implementation class odontoController
 */
public class odontoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	odontologoModel model = new odontologoModel();

	/**
	 * Default constructor.
	 */
	public odontoController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		proceso(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		proceso(request, response);
	}

	public void proceso(HttpServletRequest request, HttpServletResponse response) {

		try {

			if (request.getParameter("op") == null) {
				listar(request, response);
				return;
			}

			String operacion = request.getParameter("op");

			switch (operacion) {

			case "listar":
				listar(request, response);
				break;

			case "nuevo":

				request.getRequestDispatcher("/odontologo/nuevoOdontologo.jsp").forward(request, response);
				break;

			case "insertar":

				insertar(request, response);

				break;
			case "obtener":
				
				obtener(request, response);
				
				break;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void listar(HttpServletRequest reques, HttpServletResponse response) {

		try {

			reques.setAttribute("listaOdontologo", model.listarOdontologos());
			Iterator<Odontologo> ite = model.listarOdontologos().iterator();

			while (ite.hasNext()) {
				Odontologo odonto = ite.next();

				System.out.println(odonto.getId() + " " + odonto.getNombre() + " " + odonto.getApellido() + " "
						+ odonto.getDni()+ " " + odonto.getFechaN() + " " + odonto.getDireccion());

			}

			reques.getRequestDispatcher("/odontologo/listaOdontologo.jsp").forward(reques, response);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en listar 2:" + e.getMessage());
		}

	}

	public boolean validar(HttpServletRequest request, HttpServletResponse response) {

		boolean res = false;
		List<String> listaError = new ArrayList<String>();

		try {

			if (request.getParameter("nombre").equals("")) {

				res = true;
				listaError.add("Ingrese nombre:");
			}

			if (request.getParameter("apellido").equals("")) {
				res = true;
				listaError.add("Ingrese apellido:");
			}

			if (request.getParameter("dni").equals("")) {
				res = true;
				listaError.add("Ingrese Dni:");
			}

			if (request.getParameter("fecha").equals("")) {
				res = true;
				listaError.add("Ingrese fecha de nacimiento:");
			}

			if (request.getParameter("direccion").equals("")) {
				res = true;
				listaError.add("Ingrese direccion:");
			}

			request.setAttribute("respuesta", res);
			request.setAttribute("listaError", listaError);

		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		return res;

	}

	public void insertar(HttpServletRequest reques, HttpServletResponse response) throws ServletException, IOException {

		try {

			if (!validar(reques, response)) {

				Odontologo odontologo = new Odontologo();
				odontologo.setNombre(reques.getParameter("nombre"));
				odontologo.setApellido(reques.getParameter("apellido"));
				odontologo.setDni(reques.getParameter("dni"));
				odontologo.setFechaN(Date.valueOf(reques.getParameter("fecha")));
				odontologo.setDireccion(reques.getParameter("direccion"));

				if (model.insertarOdontologo(odontologo) > 0) {

					reques.getSession().setAttribute("exito", "se guardo con exito");
					response.sendRedirect(reques.getContextPath() + "/odontoController?op=listar");

				} else {

					reques.getSession().setAttribute("fracaso", "no se gurado con exito");
					response.sendRedirect(reques.getContextPath() + "/odontoController?op=listar");

				}

			}else {
    			reques.getRequestDispatcher("/odontologo/nuevoOdontologo.jsp").forward(reques, response);
    		}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error en insertar Odontologo 2:" + e.getMessage());
		}

	}
	
public void obtener(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			String id=request.getParameter("id");
			Odontologo miOdonto=model.obtenerOdontologo(Integer.parseInt(id));
			if(miOdonto!=null) {
				
				request.setAttribute("odontologo",miOdonto);;
				request.getRequestDispatcher("/odontologo/editarOdontologo.jsp").forward(request, response);
			}
			
			System.out.println(miOdonto.getNombre());
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en obtener 2:"+e.getMessage());
		}
		
	}
	

}
