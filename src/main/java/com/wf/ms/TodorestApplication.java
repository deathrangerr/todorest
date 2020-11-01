package com.wf.ms;

import io.prometheus.client.Counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodorestApplication {



	private final Counter promRequestsTotal = Counter.build()
	 		.name("requests total")
			.help("Total Number Of Requests .")
			.register();
    

    @RequestMapping(path = "/TodorestApplication")
    public @ResponseBody String sayTodo() {
        promRequestsTotal.inc();
        return "Todo,Rest";
    }
			
    
    @RequestMapping(path = "/prometheus-metrics")
    public void metrics(Writer responseWriter) throws IOException {
        TextFormat.write004(responseWriter, CollectorRegistry.metricFamilySamples());
        responseWriter.close();
    }


	public static void main(String[] args) {
		SpringApplication.run(TodorestApplication.class, args);
	}

}
