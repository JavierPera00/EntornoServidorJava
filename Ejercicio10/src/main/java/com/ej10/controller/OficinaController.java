package com.ej10.controller;


/*
@RestController
@RequestMapping("/api/oficinas")
public class OficinaController {
	
	 @Autowired
	 private  OficinaService  oficinaService ;

	 @PostMapping
	    public ResponseEntity<Oficina> create(@RequestBody Oficina oficina) {
	        return ResponseEntity.ok(oficinaService.createOrUpdate(oficina));
	    }

	    @GetMapping
	    public ResponseEntity<List<Oficina>> findAll() {
	        return ResponseEntity.ok(oficinaService.findAll());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Oficina> findById(@PathVariable Integer id) {
	        return ResponseEntity.ok(oficinaService.findById(id));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
	        oficinaService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/{id}/empleados/count")
	    public ResponseEntity<Integer> countEmpleadosByOficina(@PathVariable Integer id) {
	        return ResponseEntity.ok(oficinaService.countEmpleadosByOficina(id));
	    }

	    @GetMapping("/empleados/mapa")
	    public ResponseEntity<Map<Integer, Long>> getMapaOficinasConEmpleados() {
	        return ResponseEntity.ok(oficinaService.getMapaOficinasConEmpleados());
	    }

	    @GetMapping("/empleados/mas-de/{n}")
	    public ResponseEntity<List<Oficina>> findWithMoreThanNEmpleados(@PathVariable Long n) {
	        return ResponseEntity.ok(oficinaService.findWithMoreThanNEmpleados(n));
	    }

	    @PutMapping("/{id}/telefono")
	    public ResponseEntity<Void> updateTelefonoByEmpleadoId(@PathVariable Integer id, @RequestBody String telefono) {
	        oficinaService.updateTelefonoByEmpleadoId(id, telefono);
	       
	        return ResponseEntity.noContent().build();
	       
	    }

}*/
