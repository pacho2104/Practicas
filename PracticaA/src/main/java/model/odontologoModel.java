package model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Odontologo;


public class odontologoModel extends Conectar {

	CallableStatement cst;
	ResultSet rs;

	public List<Odontologo> listarOdontologos() {

		List<Odontologo> lista = new ArrayList<Odontologo>();

		try {
			

			String sql = "CALL sp_listarOdontologo()";
			this.Conectar();
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();

			while (rs.next()) {
				Odontologo odonto = new Odontologo();
				odonto.setId(rs.getInt("id_odontologo"));
				odonto.setNombre(rs.getString("nombre"));
				odonto.setApellido(rs.getString("apellido"));
				odonto.setDni(rs.getString("dni"));
				odonto.setFechaN(rs.getDate("fechanacimiento"));
				odonto.setDireccion(rs.getString("direccion"));
				lista.add(odonto);

			}

			this.Desconectar();
			return lista;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en listar odontologos 1:" + e.getMessage());
			return null;
		}

	}

	public int insertarOdontologo(Odontologo odon) {

		try {

			int filasAfectadas = 0;
			String sql = "CALL  sp_insertarOdontologo(?,?,?,?,?)";
			this.Conectar();
			cst = con.prepareCall(sql);
			cst.setString(1, odon.getNombre());
			cst.setString(2, odon.getApellido());
			cst.setString(3, odon.getDni());
			cst.setDate(4, odon.getFechaN());
			cst.setString(5, odon.getDireccion());
			filasAfectadas=cst.executeUpdate();
			return filasAfectadas;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error en insertar odontologo 1:"+e.getMessage());
			return 0;
		}

	}
	
public Odontologo obtenerOdontologo(int id) {
		
		try {
			
			Odontologo odonto=new Odontologo();
			String sq="CALL sp_obtenerOdontologo(?)";
			this.Conectar();
			cst=con.prepareCall(sq);
			cst.setInt(1, id);
			rs=cst.executeQuery();
			
		 	    if(rs.next()) {
				odonto.setId(rs.getInt("id_odontologo"));
				odonto.setNombre(rs.getString("nombre"));
				odonto.setApellido(rs.getString("apellido"));
				odonto.setDni(rs.getString("dni"));
				odonto.setFechaN(rs.getDate("fechanacimiento"));
				odonto.setDireccion(rs.getString("direccion"));	
				
			}
		 	    
		 	    this.Desconectar();;
				return odonto;
		 	    
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error de obtener 1:"+e.getMessage());
			return null;
		}
		
	}

}
