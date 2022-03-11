package controlador;
import modelo.dao.MascotaDao;

import modelo.dao.NacimientoDao;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;
import modelo.dao.ProductoDao;
import modelo.vo.Nacimiento;
import modelo.vo.PersonaVo;
import vista.gui.ConsultarPersonaGui;
import vista.gui.RegistrarMascotasGui;
import vista.gui.RegistrarPersonasGui;
import vista.gui.RegistrarProductosGui;
import vista.gui.VentanaPrincipal;
public class Coordinador {
	
	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	RegistrarMascotasGui miRegistrarMascotasGui;
	RegistrarProductosGui miRegistrarProductosGui;
	ConsultarPersonaGui miConsultarPersonaGui;
	PersonaDao miPersonaDao;
	NacimientoDao miNacimientoDao;
	MascotaDao miMascotaDao;
	ProductoDao miProductoDao;
	PersonaProductoDao miPersonaProductoDao;
	
	
	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal=miVentanaPrincipal;		
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui=miRegistrarPersonasGui;
	}

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		this.miRegistrarMascotasGui=miRegistrarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductosGui) {
		this.miRegistrarProductosGui=miRegistrarProductosGui;
	}
	

	public void setConsultarPersonaGui(ConsultarPersonaGui miConsultarPersonaGui) {
		this.miConsultarPersonaGui=miConsultarPersonaGui;
	}

	public void setPersonaDao(PersonaDao miPersonaDao) {
		this.miPersonaDao=miPersonaDao;
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		this.miMascotaDao=miMascotaDao;
	}

	public void setNacimientoDao(NacimientoDao miNacimientoDao) {
		this.miNacimientoDao=miNacimientoDao;
	}

	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao=miProductoDao;
	}

	public void setPersonaProductoDao(PersonaProductoDao miPersonaProductoDao) {
		this.miPersonaProductoDao=miPersonaProductoDao;
	}
	

	public void mostarVentanaRegistroPersona() {
		miRegistrarPersonasGui.setVisible(true);
		
	}

	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
		
	}

	public String registrarPersona(PersonaVo miPersona) {
		return miPersonaDao.registrarPersona(miPersona);
		
	}
	
	
	

	public Long registrarNacimiento(PersonaVo miPersona) {
		return miNacimientoDao.registrarNacimiento(miPersona.getNacimiento());
	}

	public void mostrarVentanaConsultarPersonas() {
		miConsultarPersonaGui.setVisible(true);
		
	}
	
	public PersonaVo setConsultarPersona(long idDocumento) {
		return miPersonaDao.consultarPersona(idDocumento);
	}
	
	public Nacimiento consultarNacimiento(long idNacimiento) {
		return miNacimientoDao.consultarNacimiento(idNacimiento);
	}

	



}
