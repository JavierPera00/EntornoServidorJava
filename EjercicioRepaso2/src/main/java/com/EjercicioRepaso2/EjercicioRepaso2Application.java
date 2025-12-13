package com.EjercicioRepaso2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EjercicioRepaso2.model.Curso;
import com.EjercicioRepaso2.model.DetalleCurso;
import com.EjercicioRepaso2.model.Instructor;
import com.EjercicioRepaso2.service.CursoService;
import com.EjercicioRepaso2.service.DetalleCursoService;
import com.EjercicioRepaso2.service.IntructorService;
@SpringBootApplication
public class EjercicioRepaso2Application implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepaso2Application.class, args);
	}
	@Autowired
	CursoService cursoService;
	@Autowired
	DetalleCursoService detalleCursoService;
	@Autowired
	IntructorService instructorService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//A
		Instructor in1 = new Instructor("Carlos Perez","Backend");
		Curso c1 = new Curso();
		Curso c2 = new Curso();
		DetalleCurso dc1 = new DetalleCurso();
		DetalleCurso dc2 = new DetalleCurso();
		c1.setTitulo("Spring Boot desde cero");
		c1.setCodigo("SPR001");
		c1.setDetalle(dc1);
		dc1.setDuracionHoras(40);
		dc1.setNivel("Intermedio");
		c2.setTitulo("JPA Avanzado");
		c2.setCodigo("JPA002");
		c2.setDetalle(dc2);
		dc2.setDuracionHoras(30);
		dc2.setNivel("Avanzado");
		
		c1.setInstructor(in1);
		c2.setInstructor(in1);
		
		in1.getCursos().add(c1);
		in1.getCursos().add(c2);
		//B
		Instructor in2 = new Instructor("Laura Martínez","Frontend");
		Curso c3 = new Curso();
		Curso c4 = new Curso();
		Curso c5 = new Curso();
		DetalleCurso dc3 = new DetalleCurso();
		DetalleCurso dc4 = new DetalleCurso();
		DetalleCurso dc5 = new DetalleCurso();
		c3.setTitulo("HTML y CSS Básico");
		c3.setCodigo("WEB101");
		c3.setDetalle(dc3);
		dc3.setDuracionHoras(20);
		dc3.setNivel("Basico");
		
		c4.setTitulo("JavaScript Moderno");
		c4.setCodigo("JS202");
		c4.setDetalle(dc4);
		dc4.setDuracionHoras(25);
		dc4.setNivel("Intermedio");
		
		c5.setTitulo("React con Hooks");
		c5.setCodigo("REACT303");
		c5.setDetalle(dc5);
		dc5.setDuracionHoras(35);
		dc5.setNivel("Avanzado");
		
		c3.setInstructor(in2);
		c4.setInstructor(in2);
		c5.setInstructor(in2);
		
		in2.getCursos().add(c3);
		in2.getCursos().add(c4);
		in2.getCursos().add(c5);
		
		
		cursoService.saveCurso(c1);
		cursoService.saveCurso(c2);
		cursoService.saveCurso(c3);
		cursoService.saveCurso(c4);
		cursoService.saveCurso(c5);
		
		detalleCursoService.saveDetalleCurso(dc1);
		detalleCursoService.saveDetalleCurso(dc2);
		detalleCursoService.saveDetalleCurso(dc3);
		detalleCursoService.saveDetalleCurso(dc4);
		detalleCursoService.saveDetalleCurso(dc5);

		instructorService.saveInstructor(in2);
		instructorService.saveInstructor(in1);
		
		//C
		cursoService.getAllCursos().forEach(c->{
			System.out.println(c);
		});
		//D
		System.out.println(cursoService.buscarTituloTexto("Java"));
		
		//E
		System.out.println(cursoService.buscarTituloTexto("Python"));
		
		//F
		/*
		dc5.setDuracionHoras(38);
		detalleCursoService.saveDetalleCurso(dc5);*/
		c5.getDetalle().setDuracionHoras(38);
		cursoService.saveCurso(c5);
		
		//G
		cursoService.findByTitulo("React con Hooks").forEach(c->{
			System.out.println(c);
		});
		
		/*H
		List<Curso> curso = cursoService.findByTitulo("HTML Y CSS Básico");
		cursoService.deleteCurso(curso.get(0).getId());
		*/
		
		/*I
		List<Curso> curso1 = cursoService.findByTitulo("Laravel Profesional");
		cursoService.deleteCurso(curso1.get(0).getId());
		*/
		
		// J
		in2.getCursos().forEach(c->{
			System.out.println(c.getTitulo());
		});
	}

}
