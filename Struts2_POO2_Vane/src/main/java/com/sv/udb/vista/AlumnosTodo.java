package com.sv.udb.vista;
import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.sv.udb.modelo.*;
import com.sv.udb.controlador.*;

public class AlumnosTodo extends  ActionSupport{
	private static final long serialVersionUID = 9149826260758390091L;
	private Alumnos objeAlum;
	private List<Alumnos> listAlum;
	private Long id;
	
	private AlumnosBeans alumnosManager;

	public AlumnosTodo() {
		alumnosManager = new AlumnosBeans();
	}

	public String execute() {
		this.listAlum = alumnosManager.findAll();
		System.out.println("execute called");
		return SUCCESS;
	}

	public Alumnos getObjeAlum() {
		return objeAlum;
	}
	public void setObjeAlum(Alumnos objeAlum) {
		this.objeAlum = objeAlum;
	}
	public List<Alumnos> getListAlum() {
		return listAlum;
	}
	public void setListAlum(List<Alumnos> listAlum) {
		this.listAlum = listAlum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String guardar(){
		this.getObjeAlum().setFechNaciAlum(new Date());
		System.out.println(this.getObjeAlum());
		try {
			alumnosManager.persist(this.getObjeAlum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.listAlum = alumnosManager.findAll();
		return SUCCESS;
	}

	public String eliminar() {
		try {
			alumnosManager.remove(this.getObjeAlum());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.listAlum = alumnosManager.findAll();
		return SUCCESS;
	}
        public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// create a new instance of actionerrors
		ActionErrors actionErrors = new ActionErrors();

		// valdiate name
		if (name.length() &lt; 3) {
			actionErrors.add("name", new ActionMessage("error.name"));
		}

		// validate age
		if (age == null || age &lt; 18) {
			actionErrors.add("age", new ActionMessage("error.age"));
		}

		// return collection of action messages
		return actionErrors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// reset properties
		name = "";
		age = 0;

	}
}
