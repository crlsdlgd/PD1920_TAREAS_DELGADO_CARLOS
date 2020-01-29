package com.distribuida.principal;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;

public class Main {

	public static final String SIGER_SERVICE_NAME = "singer";
	public static final String ALBUM_SERVICE_NAME = "album";

	public static void main(String[] args) {

		listarServiciosDisponibles(SIGER_SERVICE_NAME);
		listarServiciosDisponibles(ALBUM_SERVICE_NAME);
		
	}

	private static void listarServiciosDisponibles(String sigerServiceName) {
		
		ConsulClient client = new ConsulClient("127.0.0.1");
		Response<Map<String, Service>> ss = client.getAgentServices();
		Map<String, Service> services = ss.getValue();
		
		List<Service> listSingerService = services.values().stream().filter(s -> sigerServiceName.equals(s.getService()))
				.collect(Collectors.toList());
		
		if (listSingerService.isEmpty()) {
			System.err.println("No existe ningun servidor registrado con el nombre " + sigerServiceName);
			return;
		}
	
		for(Service s:listSingerService) {
			String url = String.format("http:// %s:%d/%s/",s.getAddress(),s.getPort(),sigerServiceName);
			System.out.println(s.getId()+"-->"+url);
			
		}
		//validos
		HealthServicesRequest request = HealthServicesRequest.newBuilder()
				.setPassing(true)
				.setQueryParams(QueryParams.DEFAULT)
				.build();
		Response<List<HealthService>> healthyServices = client.getHealthServices(sigerServiceName, request);
		List<HealthService> datos = healthyServices.getValue();
		
		datos.stream()
		.map(s->s.getService())
		.map(s->String.format("%s-->http:// %s:%d/%s/",s.getId(),s.getAddress(),s.getPort(),sigerServiceName)).forEach(System.out::println);
		
	}
	
	
	

}
